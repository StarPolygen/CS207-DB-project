package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.CommentDao;
import com.cs307.sustc.project.dao.GoodDao;
import com.cs307.sustc.project.dao.UserInfoDao;
import com.cs307.sustc.project.entity.UserInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
public class PersonalPageController {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private GoodDao goodDao;

    @RequestMapping(value = "/personal/goodsAndComments", method = RequestMethod.GET)
    public String goodsAndComments(HttpServletRequest httpServletRequest, Integer self, Integer id){
        UserInfo userInfo;
        if(self == 1){
            String openid = (String) httpServletRequest.getSession().getAttribute("openid");
            System.out.println(openid);
            userInfo = userInfoDao.queryUserInfoByOpenID(openid);
        }else{
            userInfo = userInfoDao.queryUserInfoById(id);
        }
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        List<Map> list = commentDao.queryCommentsAndAvatarByID(userInfo.getId());
        JSONArray jsonArray = new JSONArray();
        for(Map map : list){
            JSONObject js = new JSONObject();
            js.put("rate", map.get("rate"));
            js.put("avatar", map.get("avatar"));
            js.put("time", ft.format(map.get("time")));
            js.put("content", map.get("content"));
            jsonArray.add(js);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("commentList", jsonArray);
        jsonObject.put("selfAvatar", userInfo.getAvatar_url());
        jsonObject.put("nickName", userInfo.getnickname());
        jsonObject.put("goodList", GoodsController.getString(goodDao.queryGoodsByUserId(userInfo.getId())));
        return jsonObject.toString();
    }
}
