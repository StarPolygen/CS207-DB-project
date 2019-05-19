package com.cs307.sustc.project.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RandomTest {
    @Autowired
    RandomGoods randomGoods;

    @Test
    public void mainTest(){
        System.out.println(Arrays.toString(randomGoods.queryGoodsRandom().stream().map(t->t.getId()).toArray()));
        System.out.println(randomGoods.queryServersRandom());
    }
}
