package com.iit.test;

import com.iit.bean.*;
import com.iit.dao.BaseDao;
import com.iit.dao.ProductDao;
import com.iit.dao.impl.ProductDaoImpl;
import com.iit.dao.impl.UserDaoImpl;
import com.iit.service.ProductService;
import com.iit.service.impl.ProductServiceImpl;
import com.iit.utils.MySqlDataStoreUtilities;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

public class TestDao extends BaseDao<Order> {
    @Test
    public void adduser() throws Exception {
//        	public User(String userId, String password, String fname, String lname, String email, String mno, int role) {

            User user = new User("@binghan", "binghan", "Geng", "Binghan","bgeng@hawk.iit.edu","3123949380","loan",2);
            new UserDaoImpl().addUser(user);
    }

    @Test
    public void filterProduct() throws Exception {
        List<Product> productlist = new ArrayList<Product>();
        ProductDao productDao = new ProductDaoImpl();
        HashMap<String, List<Product>> result = new HashMap<String, List<Product>>();
        productlist = productDao.selectProductByType("TV");
        result.put("TV",productlist);
    }

    @Test
    public void filterProductById() throws Exception {
        Cart cart = new Cart();
        Product product;
        ProductDao productDao = new ProductDaoImpl();
        product = productDao.fetchProductById(1);
        cart.addToCart(product);
    }

    @Test
    public void getAccessories() throws Exception {
        ProductService productService = new ProductServiceImpl();
        List<Product> accessories = productService.findAccessoryByProductID(1);
    }

    @Test
    public void getMaxId() throws Exception {
        QueryRunner queryRunner = new QueryRunner();

        int result = -1;
        String sql = "select max(orderid) as lastid from `order`";
        Connection conn = MySqlDataStoreUtilities.getConnection();
        ResultSet rs = conn.prepareStatement(sql).executeQuery();
        while (rs.next()) {
            result = rs.getInt(1);
        }
    }
}
