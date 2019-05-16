package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.GoodDao;
import com.cs307.sustc.project.entity.Good;
import com.cs307.sustc.project.tools.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class GoodController {
    @Autowired
    GoodDao goodDao;
    @Autowired
    Search search;

    //???? 当使用restful风格传入参数时，会cors
    @RequestMapping(value = "/good/default",method = RequestMethod.GET)
    @CrossOrigin
    public List<Good> search() {
//        if(name.length()==0){
            return goodDao.queryAllGoods();
//        }
//        return search.search(List.of(name.split(" ")),1);
    }

    @RequestMapping(value = "/good/search",method = RequestMethod.GET)
    @CrossOrigin
    public List<Good> search(@RequestParam(value = "name") String name) {
//        if(name.length()==0){
//        return goodDao.queryAllGoods();
//        }
        return search.search(List.of(name.split(" ")),-1);
    }


    @RequestMapping(value = "good/remove",method = RequestMethod.GET)
    @CrossOrigin
    public String remove(@RequestParam(value = "id", required = false, defaultValue = "-1") Integer id) {
        if(id==-1){
            return "请选择一项下架";
        }
        Good good=goodDao.queryGoodByID(id);
        if(good!=null&&good.getgood_status()==1){
//            System.out.println("changed!");
            goodDao.changeStatus(id,-1);
            return "下架成功";
        }
        else{
            return "下架失败";
        }
    }
}
