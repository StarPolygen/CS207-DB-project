package com.cs307.sustc.project.web.Controllers;

import com.cs307.sustc.project.dao.AdminDao;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Random;

@RestController
@CrossOrigin
public class AdminLoginController {
    @Autowired
    private AdminDao adminDao;

    static BijectiveMap tokens=new BijectiveMap();

    @CrossOrigin
    @RequestMapping("/login")
    public String login(@RequestParam("account") String account,@RequestParam("password") String password){
        String str=adminDao.check(account);
//        return str != null && str.equals(password);
        if(str==null||(!str.equals(password))){
            return "login failed";
        }
        else{
            Random random=new Random(System.currentTimeMillis());
            int len=Math.abs(random.nextInt())%500+45;
            String token =  RandomStringUtils.randomAlphanumeric(len).substring(0,45);
            tokens.put(account,token);
            System.out.println(token);
            return token;
        }
    }
    @CrossOrigin
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public boolean logout(String account){
        if(tokens.containsx(account)){
            tokens.removex(account);
            return true;
        }
        return false;
    }

    static class BijectiveMap{
        HashMap<String,String> f;
        HashMap<String,String> g;

        BijectiveMap(){
            f=new HashMap<>();
            g=new HashMap<>();
        }

        public void put(String x,String y){
            f.put(x,y);
            g.put(y,x);
        }

        public void removex(String x){
            String y=f.get(x);
            f.remove(x);
            g.remove(y);
        }

        public void removey(String y){
            String x=f.get(y);
            f.remove(x);
            g.remove(y);
        }

        public String getx(String y){
            return g.get(y);
        }

        public String gety(String x){
            return f.get(x);
        }

        public boolean containsx(String x){
            return f.containsKey(x);
        }

        public boolean containsy(String y){
            return g.containsKey(y);
        }
    }
}
