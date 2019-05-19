package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.GoodDao;
import com.cs307.sustc.project.entity.Good;
import com.cs307.sustc.project.tools.RandomGoods;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainPageController {

    @Autowired
    private GoodDao goodDao;
    @Autowired
    private RandomGoods randomGoods;

    @RequestMapping(value = "/main/queryGoodsRandom", method = RequestMethod.GET)
    public String queryGoodsRandom(){
        List<Good> list = randomGoods.queryGoodsRandom();
        return getString(list);

    }

    @RequestMapping(value = "/main/queryServersRandom", method = RequestMethod.GET)
    public String queryServersRandom(){
        List<Good> list = randomGoods.queryServersRandom();
        return getString(list);
    }

    private static String getString(List<Good> list){
        JSONArray jsonArray = new JSONArray();
        for(Good good : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", good.getId());
            jsonObject.put("image", good.getPicture_url());
            jsonObject.put("title",  good.getName());
            jsonObject.put("price", good.getPrice());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}
