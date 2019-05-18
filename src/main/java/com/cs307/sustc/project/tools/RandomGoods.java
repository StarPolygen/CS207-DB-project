package com.cs307.sustc.project.tools;

import com.cs307.sustc.project.dao.GoodDao;
import com.cs307.sustc.project.entity.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class RandomGoods {
    @Autowired
    private GoodDao goodDao;

    public List<Good> queryGoodsRandom(){
        List<Integer> list=goodDao.queryAllRealGoods();
        Collections.shuffle(list,new Random(System.currentTimeMillis()));
        return goodDao.queryByIds(list.subList(0,Math.min(list.size(),14)));
    }

    public List<Good> queryServersRandom(){
        List<Integer> list=goodDao.queryAllService();
        Collections.shuffle(list,new Random(System.currentTimeMillis()));
        return goodDao.queryByIds(list.subList(0,Math.min(list.size(),14)));
    }

}
