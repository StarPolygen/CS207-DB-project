package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.GoodDao;
import com.cs307.sustc.project.dao.GoodPictureDao;
import com.cs307.sustc.project.dao.UserInfoDao;
import com.cs307.sustc.project.entity.Good;
import com.cs307.sustc.project.entity.GoodPicture;
import com.cs307.sustc.project.entity.UserInfo;
import com.cs307.sustc.project.tools.RandomGoods;
import com.cs307.sustc.project.tools.Search;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {
    @Autowired
    private RandomGoods randomGoods;

    @Autowired
    private GoodPictureDao goodPictureDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private Search search;

    @Autowired
    private GoodDao goodDao;

    @RequestMapping(value = "/good/queryGoodsRandom", method = RequestMethod.GET)
    public String queryGoodsRandom(){
        List<Good> list = randomGoods.queryGoodsRandom();
        return getString(list);

    }

    @RequestMapping(value = "/good/queryServersRandom", method = RequestMethod.GET)
    public String queryServersRandom(){
        List<Good> list = randomGoods.queryServersRandom();
        return getString(list);
    }

    @RequestMapping(value = "/good/findKeywordWithTag", method = RequestMethod.GET)
    public String findKeywordWithTag(String name, Integer tag, Integer page){
        if(name == null){
            name = "";
        }
        List<Good> list = search.search(Arrays.asList(name.split(" ")),tag,page);
        return getString(list);
    }

    @RequestMapping(value="/good/findByKeyword", method = RequestMethod.GET)
    public String findByKeyword(String name, Integer page){
        List<Good> list = search.search(Arrays.asList(name.split(" ")),page);
        return getString(list);
    }

    @RequestMapping(value="/good/priceSort",  method = RequestMethod.GET)
    public String priceSort(String keyString, Integer min, Integer max, Integer increase, Integer page){
        if(min == null)
            min = 0;
        if(max == null)
            max = Integer.MAX_VALUE;
        List<Good> goods=search.search(Arrays.asList(keyString.split(" ")),page,"price",increase.equals(1),min,max);
        return getString(goods);
    }

    @RequestMapping(value="/good/timeSort", method = RequestMethod.GET)
    public String timeSort(String keyString, Integer min, Integer max, Integer increase,Integer page){
        if(min == null)
            min = 0;
        if(max == null)
            max = Integer.MAX_VALUE;
        List<Good> goods=search.search(Arrays.asList(keyString.split(" ")),page,"time",increase.equals(1),min,max);
        return getString(goods);
    }

    @RequestMapping(value = "/good/goodDetail", method = RequestMethod.GET)
    public String goodDetail(Integer goodId){
        Map<String, Object> map = goodDao.queryGoodAndSellerByGoodId(goodId);
        List<GoodPicture> list = goodPictureDao.queryGoodPicture(goodId);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(map.get("good_picture_url"));
        for(GoodPicture goodPicture : list){
            jsonArray.add(goodPicture.getUrl());
        }
        jsonObject.put("images", jsonArray.toString());
        jsonObject.put("title", map.get("good_name"));
        jsonObject.put("price", map.get("good_price"));
        jsonObject.put("detail", map.get("good_description"));
        jsonObject.put("sellerAvatar", map.get("seller_avatar_url"));
        jsonObject.put("sellerId", map.get("seller_id"));
        jsonObject.put("sellerName", map.get("seller_nickname"));
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        jsonObject.put("time", ft.format(map.get("good_release_time")));
        jsonObject.put("tag", map.get("good_tag"));
        return jsonObject.toString();
    }

    @RequestMapping(value = "/good/releaseGood", method = RequestMethod.GET)
    public String releaseGood(HttpServletRequest httpServletRequest, String img, String title, String content, Integer price,
                              Integer tag){
        Object[] objects = JSONArray.fromObject(img).toArray();
        Integer userId = userInfoDao.queryUserInfoByOpenID((String)
                httpServletRequest.getSession().getAttribute("openid")).getId();
        Integer goodId = goodDao.insertGood(new Good(userId, tag, title, content,1, price, price, (String) objects[0]));
        for(int x = 1; x < objects.length; x++)
            goodPictureDao.insertGoodPicture(new GoodPicture(goodId, (String) objects[x]));
        return "ok";
    }

    @RequestMapping(value = "/good/queryPersonalGood", method = RequestMethod.GET)
    public String queryPersonalGood(HttpServletRequest httpServletRequest, Integer status){
        String openid = (String) httpServletRequest.getSession().getAttribute("openid");
        UserInfo userInfo = userInfoDao.queryUserInfoByOpenID(openid);
        List<Good> goods = goodDao.queryGoodsByUserIdAndStatus(userInfo.getId(), status);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        JSONArray jsonArray = new JSONArray();
        for(Good good : goods){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", good.getId());
            jsonObject.put("title", good.getName());
            jsonObject.put("time", ft.format(good.getRelease_time()));
            jsonObject.put("price", good.getPrice());
            jsonObject.put("image", good.getPicture_url());
            jsonObject.put("status", good.getGood_status());
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }

    @RequestMapping(value = "/good/offGood", method = RequestMethod.GET)
    public String offGood(HttpServletRequest httpServletRequest, Integer goodId){
        String openid = (String) httpServletRequest.getSession().getAttribute("openid");
        UserInfo userInfo = userInfoDao.queryUserInfoByOpenID(openid);
        System.out.println(userInfo);
        System.out.println(goodId);
        goodDao.changeStatus(userInfo.getId(), goodId, 2);
        return "ok";
    }

    @RequestMapping(value = "/good/reReleaseGood", method = RequestMethod.GET)
    public String reReleaseGood(HttpServletRequest httpServletRequest, Integer goodId){
        String openid = (String) httpServletRequest.getSession().getAttribute("openid");
        UserInfo userInfo = userInfoDao.queryUserInfoByOpenID(openid);
        goodDao.changeStatus(userInfo.getId(), goodId, 1);
        return "ok";
    }

    @RequestMapping(value = "/good/changePrice", method = RequestMethod.GET)
    public String changePrice(HttpServletRequest httpServletRequest, Integer id, Integer price){
        String openid = (String) httpServletRequest.getSession().getAttribute("openid");
        UserInfo userInfo = userInfoDao.queryUserInfoByOpenID(openid);
        goodDao.changePrice(userInfo.getId(), id, price);
        return "ok";
    }

    @RequestMapping(value = "/good/changeContent", method = RequestMethod.GET)
    public String changeContent(HttpServletRequest httpServletRequest, Integer id, String title, String content){
        String openid = (String) httpServletRequest.getSession().getAttribute("openid");
        UserInfo userInfo = userInfoDao.queryUserInfoByOpenID(openid);
        goodDao.changeContent(userInfo.getId(), id, title, content);
        return "ok";
    }

    public static String getString(List<Good> list){
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
