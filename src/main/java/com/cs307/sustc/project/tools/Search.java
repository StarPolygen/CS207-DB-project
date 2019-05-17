package com.cs307.sustc.project.tools;

import com.cs307.sustc.project.dao.GoodDao;
import com.cs307.sustc.project.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Search {
    // Test Result: can not be autowired????
    @Autowired
    private GoodDao goodDao;

    private static final int BUFFER_SIZE=8;
    private static Map<String,Map<Good,Integer>> cacheWithoutTag;
    private static Map<StringIntegerKey,Map<Good,Integer>> cacheWithTag;

    public List<Good> search(List<String> keywords, Integer page){
        int offset,end;
        if(page==null||page<=0){
            offset=0;
            end=2000;
        }
        else{
            offset=(page-1)*20;
            end=offset+20;
        }
        HashMap<Good,Integer> hashMap=new HashMap<>();
        for(String keyword:keywords){
            if(!cacheWithoutTag.containsKey(keyword)){
                new SearchResult().searchFromDatabaseWithoutTag(keyword);
            }
            for(Map.Entry<Good,Integer> entry:cacheWithoutTag.get(keyword).entrySet()){
                hashMap.merge(entry.getKey(),entry.getValue(),Integer::sum);
            }
        }
        List<Good> res=sortedList(hashMap);
        return res.subList(Math.min(offset,res.size()),Math.min(end,res.size()));
    }

    public List<Good> search(List<String> keywords,Integer tag,Integer page){
        int offset,end;
        if(page==null||page<=0){
            offset=0;
            end=2000;
        }
        else{
            offset=(page-1)*20;
            end=offset+20;
        }
        HashMap<Good,Integer> hashMap=new HashMap<>();
        for(String keyword:keywords){
            StringIntegerKey key=new StringIntegerKey(tag,keyword);
            if(!cacheWithTag.containsKey(key)){
                new SearchResult().searchFromDatabaseWithTag(keyword,tag);
            }
            for(Map.Entry<Good,Integer> entry:cacheWithTag.get(key).entrySet()){
                hashMap.merge(entry.getKey(),entry.getValue(),Integer::sum);
            }
        }
        List<Good> res=sortedList(hashMap);
        return res.subList(Math.min(offset,res.size()),Math.min(end,res.size()));
    }

    public List<Good> search(List<String> keywords, Integer page, String sortKey,boolean decrease){
        List<Good> res;
        if(sortKey.equals("price")){
            res=search(keywords,-1);
            res.sort((a,b)->Float.compare(a.getPrice(),b.getPrice()));
        }
        else if(sortKey.equals("time")){
            res=search(keywords,-1);
            res.sort(Comparator.comparing(Good::getrelease_time));
        }
        else{
            return new ArrayList<>();
        }
        if(decrease){
            Collections.reverse(res);
        }
        if(page<=0){
            return res;
        }
        else{
            int offset=(page-1)*20;
            int end=offset+20;
            return res.subList(Math.min(offset,res.size()),Math.min(end,res.size()));
        }
    }

    private void maintain(){
        if(cacheWithoutTag.size()>BUFFER_SIZE){
            cacheWithoutTag=new HashMap<>();
        }
        if(cacheWithTag.size()>BUFFER_SIZE){
            cacheWithTag=new HashMap<>();
        }
    }

    public Search() {
        this.cacheWithTag=new HashMap<>();
        this.cacheWithoutTag=new HashMap<>();
    }


    private class SearchResult{

        private SearchResult(){
            this.priority=new HashMap<>();
        }

        private final Map<Good,Integer> priority;

        private void searchFromDatabaseWithoutTag(String keyword){
            System.out.println(goodDao);
            searchHelp(goodDao.findByName(keyword), goodDao.findByKeyword(keyword));
            cacheWithoutTag.put(keyword,priority);
        }

        private void searchFromDatabaseWithTag(String keyword,Integer tag){
            searchHelp(goodDao.findWithTag(keyword,tag), goodDao.findKeywordWithTag(keyword,tag));
            cacheWithTag.put(new StringIntegerKey(tag,keyword),priority);
        }

        private void searchHelp(List<Good> list1, List<Good> list2) {
            for(Good g:list1){
                priority.merge(g,1,Integer::sum);
            }
            for(Good g:list2){
                priority.merge(g,1,Integer::sum);
            }
            maintain();
        }
    }

    private List<Good> sortedList(Map<Good,Integer> priority){
            List<Good> goods=new ArrayList<>(priority.keySet());
            goods.sort(
                    (o1, o2) -> {
                        if(priority.get(o1).equals(priority.get(o2))){
                            return o2.getrelease_time().compareTo(o1.getrelease_time());
                        }
                        else return priority.get(o2).compareTo(priority.get(o1));
                    }
            );
            return goods.subList(0,Math.min(1000,goods.size()));
    }



    private class StringIntegerKey {
        private Integer tag;
        private String str;

        StringIntegerKey(Integer tag,String keyword){
            this.tag=tag;
            this.str=keyword;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj != null && obj instanceof StringIntegerKey) {
                StringIntegerKey s = (StringIntegerKey)obj;
                return tag.equals(s.tag) && str.equals(s.str);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (tag + str).hashCode();
        }
    }
}
