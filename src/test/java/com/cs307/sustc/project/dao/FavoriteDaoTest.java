package com.cs307.sustc.project.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteDaoTest {

    @Autowired
    FavoriteDao favoriteDao;

    @Test
    public void queryAllFavorite(){

    }

    @Test
    public void queryFavorite(){

    }

    @Test
    public void insertFavorite(){

    }

    @Test
    public void queryFavoriteTest(){
        System.out.println(favoriteDao.queryFavoriteByUser(1));
    }
}
