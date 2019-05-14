package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Good;

import java.util.List;

public interface GoodDao {

    List<Good> queryAllGoods();

    List<Good> queryGoodsByNumber(String time, Integer number);

    Good queryGoodByID(Integer id);

    void insertGood(Good good);
}
