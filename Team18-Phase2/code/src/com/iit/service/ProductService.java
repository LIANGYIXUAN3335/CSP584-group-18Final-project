package com.iit.service;
import com.iit.bean.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product) throws Exception;
    List<Product> filterByType(String type) throws Exception;

    List<Product> filterByManufacturer(String type, String manufacturer) throws Exception;

    Product filterById(Integer id) throws Exception;

    List<Product> findAccessoryByProductID(Integer productId) throws Exception;
}
