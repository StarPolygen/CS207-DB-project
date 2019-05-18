package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.GoodDao;
import com.cs307.sustc.project.dao.GoodPictureDao;
import com.cs307.sustc.project.entity.Good;
import com.cs307.sustc.project.tools.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class GoodController {
    @Autowired
    GoodDao goodDao;
    @Autowired
    Search search;
    @Autowired
    GoodPictureDao goodPictureDao;

    @RequestMapping(value = "/good/default",method = RequestMethod.GET)
    @CrossOrigin
    public List<Good> search(@RequestParam("token") String token) {
        if(token==null||(!AdminLoginController.tokens.containsy(token))){
            return new ArrayList<>();
        }
//        if(name.length()==0){
            return goodDao.queryAllGoods();
//        }
//        return search.search(List.of(name.split(" ")),1);
    }

    @RequestMapping(value = "/good/search",method = RequestMethod.GET)
    @CrossOrigin
    public List<Good> search(@RequestParam("token") String token, @RequestParam(value = "name") String name) {
//        if(name.length()==0){
//        return goodDao.queryAllGoods();
//        }
        if(token==null||(!AdminLoginController.tokens.containsy(token))){
            return new ArrayList<>();
        }
        return search.search(List.of(name.split(" ")),-1);
    }


    @RequestMapping(value = "good/remove",method = RequestMethod.GET)
    @CrossOrigin
    public String remove(@RequestParam("token") String token,@RequestParam(value = "id", required = false, defaultValue = "-1") Integer id) {
        if(token==null||(!AdminLoginController.tokens.containsy(token))){
            return "登录信息错误，操作失败";
        }
        if(id==-1){
            return "请选择一项下架";
        }
        Good good=goodDao.queryGoodByID(id);
        if(good!=null&&good.getGood_status()==1){
//            System.out.println("changed!");
            goodDao.changeStatus(id,-1);
            return "下架成功";
        }
        else{
            return "下架失败";
        }
    }

    @RequestMapping(value = "good/picture",method = RequestMethod.GET)
    @CrossOrigin
    public List<String> getPictures(@RequestParam("good") Integer good){
        List<String> list=goodPictureDao.queryAllGoodPicturesUrl(good);
        List<String> res=new ArrayList<>();
        res.add("1");
        res.addAll(list);
        return res;
    }
}
