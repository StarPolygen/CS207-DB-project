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

    //???? 当使用restful风格传入参数时，会有cors
    @RequestMapping(value = "/good",method = RequestMethod.GET)
    @CrossOrigin
    public List<Good> search(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
//        response.addHeader("*", "http://localhost:3000");
        if(name.length()==0){
            return goodDao.queryAllGoods();
        }
        return search.search(List.of(name.split(" ")),1);
    }
}
