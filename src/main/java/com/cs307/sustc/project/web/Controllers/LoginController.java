package com.cs307.sustc.project.web.Controllers;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.cs307.sustc.project.dao.UserInfoDao;
import com.cs307.sustc.project.entity.UserInfo;
import com.cs307.sustc.project.tools.HttpClientUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    static Log log = LogFactory.get(LoginController.class);

    @Value("${wxlogin_url}")
    private String url;

    @Value("${appid}")
    private String appid;

    @Value("${secret}")
    private String secret;

    @Autowired
    private UserInfoDao userInfoDao;


    @RequestMapping(value = "/wxlogin", method = RequestMethod.GET)
    public String wxLogin(HttpServletRequest request, String code, String avatarUrl, String nickName, String email){
        HttpSession session = request.getSession();
        Map<String, String> param = new HashMap<>();
        if(code == null)
        {
            JSONObject js = new JSONObject();
            log.info("/wxlogin 无效访问");
            return "Invalid access";
        }else{
            param.put("appid", this.appid);
            param.put("secret", this.secret);
            param.put("js_code", code);
            param.put("grant_type", "authorization_code");
            String result = HttpClientUtil.doGet(this.url, param);
            // session_key, openid
            JSONObject jsonObject = JSONObject.fromObject(result);
            String open_id = (String)jsonObject.get("openid");
            UserInfo userInfo = userInfoDao.queryUserInfoByOpenID(open_id);
            if(userInfo == null && email == null){
                JSONObject js = new JSONObject();
                js.put("code", "01");
                return js.toString();
            }else if(email != null){
//                UserInfo regist = new UserInfo(1, 1, email, );
//                userInfoDao.insertUserInfo();
                JSONObject js = new JSONObject();
                js.put("code", "02");
                return js.toString();
            }else{
                session.setAttribute("session_key", jsonObject.get("session_key"));
                session.setAttribute("openid", jsonObject.get("openid"));
                session.setAttribute("userID", userInfo.getId());
                session.setMaxInactiveInterval(30 * 60);
                log.info("session_id: " + session.getId() + ": 有用户登入，openid: " + jsonObject.get("openid") + "， session_key: " + jsonObject.get("session_key"));
                return "success";
            }
        }
    }

}
