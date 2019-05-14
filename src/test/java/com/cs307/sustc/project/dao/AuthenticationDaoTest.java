package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Authentication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationDaoTest {

    @Autowired
    AuthenticationDao authenticationDao;

    @Test
    public void queryAllAuthentications(){
        List<Authentication> list = authenticationDao.queryAllAuthentications();
        for(Authentication authentication : list)
            System.out.println(authentication);
    }

    @Test
    public void queryAuthentication(){
        Authentication authentication = authenticationDao.queryAuthentication(1);
        System.out.println(authentication);
    }

    @Test
    public void deleteAuthentication(){
        authenticationDao.deleteAuthentication(1);
    }

    @Test
    public void insertAuthentication(){
        authenticationDao.insertAuthentication(2, "co", "djfiewjik");
    }
}
