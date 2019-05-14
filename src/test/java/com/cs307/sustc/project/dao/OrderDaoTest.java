package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {
    @Autowired
    OrderDao orderDao;

    @Test
    public void queryAllOrders(){
        List<Order> list = orderDao.queryAllOrders();
        for(Order order : list)
            System.out.println(order);
    }

    @Test
    public void queryOrdersByBuyerID(){
        List<Order> list = orderDao.queryOrdersByBuyerID(1);
        for(Order order : list)
            System.out.println(order);
    }

    @Test
    public void queryOrdersByGoodID(){
        System.out.println(orderDao.queryOrdersByGoodID(7));
    }

    @Test
    public void insertOrder(){
        orderDao.insertOrder(new Order(1, 9, 1));
    }
}
