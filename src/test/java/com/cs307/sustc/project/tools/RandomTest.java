package com.cs307.sustc.project.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RandomTest {
    @Autowired
    RandomGoods randomGoods;

    @Test
    public void mainTest(){
        System.out.println(randomGoods.queryGoodsRandom());
        System.out.println(randomGoods.queryServersRandom());
    }
}
