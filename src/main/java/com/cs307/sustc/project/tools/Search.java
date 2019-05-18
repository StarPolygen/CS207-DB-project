package com.cs307.sustc.project.tools;

import com.cs307.sustc.project.dao.GoodDao;
import com.cs307.sustc.project.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Search {
    // Test Result: can not be autowired????
    @Autowired
    private GoodDao goodDao;

    private static final int BUFFER_SIZE=8;
    private static Map<String,Map<Good,Integer>> cacheWithoutTag;
    private static Map<StringIntegerKey,Map<Good,Integer>> cacheWithTag;
    private static Date lastClearTime;

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

    public List<Good> search(List<String> keywords, Integer page, String sortKey,boolean decrease,float low,float up){
        List<Good> res=search(keywords,-1);
        return getGoodsHelp(page, sortKey, decrease, res, low, up);
    }

    private List<Good> getGoodsHelp(Integer page, String sortKey, boolean decrease, List<Good> res, float low, float up) {
        float l = Math.max(0,low);
        float h = Math.min(up,0x3f3f3f3f);
        if(sortKey.equals("price")){
            res=res.stream().filter(t->t.getPrice()>=l&&t.getPrice()<=h).sorted((a,b)->Float.compare(a.getPrice(),b.getPrice())).collect(Collectors.toList());
        }
        else if(sortKey.equals("time")){
            res=res.stream().filter(t->t.getPrice()>=l&&t.getPrice()<=h).sorted(Comparator.comparing(Good::getrelease_time)).collect(Collectors.toList());
        }
        else{
            res=res.stream().filter(t->t.getPrice()>=l&&t.getPrice()<=h).collect(Collectors.toList());
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

    public List<Good> search(List<String> keywords,Integer tag, Integer page, String sortKey,boolean decrease,Integer low,Integer up){
        List<Good> res=search(keywords,tag,-1);
        return getGoodsHelp(page, sortKey, decrease, res, low, up);
    }

    private void maintain(){
        if(System.currentTimeMillis()-lastClearTime.getTime()>1800000){
            cacheWithoutTag=new HashMap<>();
            cacheWithTag=new HashMap<>();
        }
        if(cacheWithoutTag.size()>BUFFER_SIZE){
            cacheWithoutTag=new HashMap<>();
        }
        if(cacheWithTag.size()>BUFFER_SIZE){
            cacheWithTag=new HashMap<>();
        }
    }

    public Search() {
        cacheWithTag=new HashMap<>();
        cacheWithoutTag=new HashMap<>();
        lastClearTime=new Date();
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
            if(obj instanceof StringIntegerKey) {
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
