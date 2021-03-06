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
        System.out.println(goodDao);
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
//        Good good = new Good(1, 1, "iphone", "ip X", 1, (float) 2.50, (float) 1.20);
//        for(int x = 0; x < 20; x++)
//            goodDao.insertGood(good);
    }

    @Test
    public void updateTest(){
        for(int i=1;i<=100;i++){
            Good good=goodDao.queryGoodByID(i);
            if(good!=null){
                good.setPicture_url("https://www.npmjs.com/package/mdi-vue");
            }
        }
    }

    @Test
    public void randomTest(){
//        System.out.println(goodDao.queryGoodsRandom());
//        System.out.println(goodDao.queryServersRandom());
    }

    @Test
    public void queryListTest(){
        System.out.println(goodDao.queryAllRealGoods());
        System.out.println(goodDao.queryAllService());

        List<Integer> a=List.of(1,2,3,4,5,6,7);
//        System.out.println(goodDao.queryByIds(a).size());
    }
}
