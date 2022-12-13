package com.iit.dao.impl;

import com.iit.bean.Order;
import com.iit.bean.Product;
import com.iit.dao.BaseDao;
import com.iit.dao.OrderDao;
import com.iit.utils.MySqlDataStoreUtilities;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {

    @Override
    public void insertOrder(Order order) throws Exception {
        String sql = "insert into `order` (username,userid," +
                "email,creditcard,state,city,street,mobile,"+
                "orderquantity,zipcode,productid,totalamount,productname,createtime) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        update(sql,order.getUsername(), order.getUserid(),order.getEmail(),order.getCreditcard(),
                order.getState(),order.getCity(),order.getStreet(),
                order.getMobile(),order.getOrderquantity(),order.getZipcode(),order.getProductid(),
                order.getTotalamount(),order.getProductname(), order.getCreatetime());
    }

    @Override
    public Order getOrderById(int id) throws Exception {
        Order order;
        String sql = "select * from order_item where orderid=?";
        order = getBean(Order.class,sql,id);
        return order;
    }

    @Override
    public List<Order> selectOrderByUser(String userid) {
        List<Order> resultData = new ArrayList<Order>();
        String sql = "select * from `order` where userid="+"'"+userid+"'";
        resultData = getBeanList(Order.class,sql);
        return resultData;
    }

    @Override
    public int getLastOrderID() throws Exception {
        int result = -1;
        String sql = "select max(orderid) as lastid from `order`";
        Connection conn = MySqlDataStoreUtilities.getConnection();
        ResultSet rs = conn.prepareStatement(sql).executeQuery();
        while (rs.next()) {
            result = rs.getInt(1);
        }
        return result;
    }

    public void deleteOrder(Integer id) throws Exception {
        String sql = "delete from `order` where orderid=?";
        update(sql,id);
    }
}
