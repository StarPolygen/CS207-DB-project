package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Good;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodDaoTest {
    @Autowired
    private GoodDao goodDao;

    @Test
    public void queryAllGoods(){
        List<Good> list = goodDao.queryAllGoods();
        for(Good good : list)
            System.out.println(good);
    }

    @Test
    public void queryGoodsByNumber(){
        List<Good> list = goodDao.queryGoodsByNumber("2019-05-13 22:15:19", 4);
        for(Good good : list)
            System.out.println(good);
    }

    @Test
    public void queryGoodByID(){
        Good good = goodDao.queryGoodByID(1);
        System.out.println(good);
    }

    @Test
    public void insertGood(){
        Good good = new Good(1, 1, "iphone", "ip X", 1, (float) 2.50, (float) 1.20);
        for(int x = 0; x < 20; x++)
            goodDao.insertGood(good);
    }
}
