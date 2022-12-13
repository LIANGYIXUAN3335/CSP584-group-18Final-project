package com.iit.dao;

import com.iit.bean.Order;
import com.iit.bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    void insertOrder(Order order) throws Exception;

    int getLastOrderID() throws Exception;

    Order getOrderById(int id) throws Exception;

    List<Order> selectOrderByUser(String userid) throws SQLException;

    public void deleteOrder(Integer id) throws Exception;
}
