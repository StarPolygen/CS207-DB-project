package com.cs307.sustc.project.dao;


import com.cs307.sustc.project.entity.GoodPicture;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodPictureDaoTest {
    @Autowired
    GoodPictureDao goodPictureDao;

    @Test
    public void queryAllGoodPictures(){
        List<GoodPicture> list = goodPictureDao.queryAllGoodPictures();
        for(GoodPicture goodPicture : list)
            System.out.println(goodPicture);
    }

    @Test
    public void queryGoodPicture(){
        List<GoodPicture> list = goodPictureDao.queryGoodPicture(7);
        for(GoodPicture goodPicture : list)
            System.out.println(goodPicture);
    }

    @Test
    public void insertGoodPicture(){
        for(int x = 0; x < 20; x++)
            goodPictureDao.insertGoodPicture(new GoodPicture(1, "https://bilibili.com"));
    }

    @Test
    public void test(){
        System.out.println(goodPictureDao.queryAllGoodPicturesUrl(1));
    }
}
