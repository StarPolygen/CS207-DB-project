package com.cs307.sustc.project.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminDaoTest {
    @Autowired
    private AdminDao adminDao;
    @Test
    public void test(){
        System.out.println(adminDao.check("123"));
    }
}
