package com.iit.service;

import com.iit.bean.Order;

public interface OrderService {
    void saveOrder(Order order) throws Exception;
    int getLastID() throws  Exception;
}
