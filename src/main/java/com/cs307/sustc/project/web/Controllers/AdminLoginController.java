package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.AdminDao;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RestController
@CrossOrigin
public class AdminLoginController {
    @Autowired
    private AdminDao adminDao;
    public static Set<String> tokens=new HashSet<>();

    @CrossOrigin
    @RequestMapping("/login")
    public String login(@RequestParam("account") String account,@RequestParam("password") String password){
        String str=adminDao.check(account);
//        return str != null && str.equals(password);
        if(str==null||(!str.equals(password))){
            return "login failed";
        }
        else{
            String token =  RandomStringUtils.randomAlphanumeric(45);
            tokens.add(token);
            System.out.println(token);
            return token;
        }
    }
}
