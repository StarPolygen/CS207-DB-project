package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoDaoTest {
    @Autowired
    UserInfoDao userInfoDao;

    @Test
    public void queryAllUserInfo(){
        List<UserInfo> list = userInfoDao.queryAllUserInfo();
        for(UserInfo userInfo : list)
            System.out.println(userInfo);
    }

    @Test
    public void queryUserInfoByOpenID(){
        System.out.println(userInfoDao.queryUserInfoByOpenID("2"));
    }

    @Test
    public void queryUserInfoByEmailAddress(){
        System.out.println(userInfoDao.queryUserInfoByEmailAddress("@qq.com"));
    }

    @Test
    public void insertUserInfo(){
        userInfoDao.insertUserInfo(new UserInfo(1, 1, "@gmail.com", "3", "nickname", "123"));
    }
}
