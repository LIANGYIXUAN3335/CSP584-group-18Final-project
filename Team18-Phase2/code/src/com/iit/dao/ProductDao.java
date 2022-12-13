package com.iit.dao;

import com.iit.bean.Order;
import com.iit.bean.Product;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

public interface ProductDao {

    void insertProduct(Product product) throws Exception;
    List<Product> selectProductByType(String type) throws SQLException;

    List<Product> selectProductByManufacturer(String type, String manufacturer) throws SQLException;

    Product fetchProductById(int id) throws SQLException;

    List<Product> selectAccessoryByProductID(Integer productId) throws Exception;

    LinkedHashMap<String, Integer> getMostSelled();

    LinkedHashMap<String, Integer> getTopZip();

    void updateProduct(Product product) throws Exception;

    public void deleteProduct(Integer id) throws Exception;
}
