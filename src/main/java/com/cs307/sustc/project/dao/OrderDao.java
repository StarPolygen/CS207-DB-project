package com.cs307.sustc.project.dao;

import com.cs307.sustc.project.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {

    List<Order> queryAllOrders();

    List<Order> queryOrdersByBuyerID(Integer buyer_id);

    Order queryOrdersByGoodID(Integer good_id);

    void insertOrder(Order order);
}
