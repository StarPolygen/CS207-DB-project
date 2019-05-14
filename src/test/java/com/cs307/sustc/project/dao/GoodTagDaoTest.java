package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.GoodTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodTagDaoTest {

    @Autowired
    GoodTagDao goodTagDao;

    @Test
    public void queryAllGoodTags(){
        List<GoodTag> list = goodTagDao.queryAllGoodTags();
        for(GoodTag goodTag : list)
            System.out.println(goodTag);
    }

    @Test
    public void insertGoodTag(){
        goodTagDao.insertGoodTag(new GoodTag("电脑"));
    }
}
