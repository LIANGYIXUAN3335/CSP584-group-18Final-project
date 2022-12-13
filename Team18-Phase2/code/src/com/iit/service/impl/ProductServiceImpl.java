package com.iit.service.impl;

import com.iit.bean.Product;
import com.iit.dao.ProductDao;
import com.iit.dao.impl.ProductDaoImpl;
import com.iit.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductDao productDao = new ProductDaoImpl();
    @Override
    public void saveProduct(Product product) throws Exception{
        productDao.insertProduct(product);
    }
    @Override
    public List<Product> filterByType(String type) throws Exception {
        return productDao.selectProductByType(type);
    }

    @Override
    public List<Product> filterByManufacturer(String type, String manufacturer) throws Exception {
        return productDao.selectProductByManufacturer(type, manufacturer);
    }

    @Override
    public Product filterById(Integer id) throws Exception {
        return productDao.fetchProductById(id);
    }

    @Override
    public List<Product> findAccessoryByProductID(Integer productId) throws Exception {
        return productDao.selectAccessoryByProductID(productId);
    }
}
