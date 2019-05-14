package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.AuthenticationDao;
import com.cs307.sustc.project.entity.EmailInfo;
import com.cs307.sustc.project.tools.EmailUtil;
import com.cs307.sustc.project.tools.RandomCode;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailAuthentication {

    @Autowired
    private AuthenticationDao authenticationDao;

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    public String authentication(String code, String email){
        EmailUtil emailUtil = new EmailUtil();
        RandomCode randomCode = new RandomCode();
        EmailInfo emailInfo = new EmailInfo(email, "二手交易市场验证码", "<h2>验证码: </h2><h3>" +
                randomCode.generate(6) + "</h3>");
        emailUtil.sendHtmlMail(emailInfo);
        authenticationDao.insertAuthentication(new AuthenticationDao());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", "0");
        return jsonObject.toString();
    }
}
