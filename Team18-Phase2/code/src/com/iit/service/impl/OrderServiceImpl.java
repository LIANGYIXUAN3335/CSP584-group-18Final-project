package com.iit.service.impl;

import com.iit.bean.Order;
import com.iit.dao.OrderDao;
import com.iit.dao.impl.OrderDaoImpl;
import com.iit.service.OrderService;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();
    @Override
    public void saveOrder(Order order) throws Exception {
        orderDao.insertOrder(order);
    }

    @Override
    public int getLastID() throws Exception {
        return orderDao.getLastOrderID();
    }
}
