package com.iit.dao.impl;

import com.iit.bean.Product;
import com.iit.dao.BaseDao;
import com.iit.dao.ProductDao;
import com.iit.utils.MySqlDataStoreUtilities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ProductDaoImpl extends BaseDao<Product> implements ProductDao {

    @Override
    public List<Product> selectProductByType(String type) throws SQLException {
        List<Product> resultData = new ArrayList<Product>();
        String sql = "select * from productcatalog where type="+"'"+type+"'";
        resultData = getBeanList(Product.class,sql);
        return resultData;
    }

    @Override
    public List<Product> selectProductByManufacturer(String type, String manufacturer) throws SQLException {
        List<Product> resultData = new ArrayList<Product>();
        String sql = "select * from productcatalog where type="+"'"+type+"'"+" and manufacturer="+"'"+manufacturer+"'";
        resultData = getBeanList(Product.class,sql);
        return resultData;
    }

    @Override
    public Product fetchProductById(int id) throws SQLException {
        Product resultProduct;
        String sql = "select * from productcatalog where productid=?";
        resultProduct = getBean(Product.class,sql,id);
        return resultProduct;
    }
    @Override
    public void insertProduct(Product product) throws Exception {
        String sql = "insert into `productcatalog` (productid,name," +
                "price,loanamount,image,manufacturer,rating,quantity,"+
                "type,creditscore) values (?,?,?,?,?,?,?,?,?,?)";
        update(sql,product.getProductid(),product.getName(),product.getPrice(),product.getLoanamount(),
                product.getImage(),product.getManufacturer(),product.getRating(),
                product.getQuantity(),product.getType(),product.getCreditscore());
    }

    @Override
    public List<Product> selectAccessoryByProductID(Integer productId) throws Exception {
        List<Product> resultData = new ArrayList<Product>();
        String sql = "SELECT * from productcatalog WHERE productid in (SELECT a.a_id from productcatalog as p JOIN product_accessory as a ON p.productid=a.p_id WHERE a.p_id="+productId+") LIMIT 3";
        resultData = getBeanList(Product.class,sql);
        return resultData;
    }

    @Override
    public LinkedHashMap<String, Integer> getMostSelled() {
        LinkedHashMap<String, Integer> p = new LinkedHashMap();
        String sql = "SELECT productcatalog.name, SUM(`order`.orderquantity) AS TotalItemsSold FROM productcatalog, `order` where productcatalog.productid=`order`.productid group by `order`.productid order by SUM(`order`.orderquantity) DESC limit 5";
        Connection conn = MySqlDataStoreUtilities.getConnection();
        ResultSet rs = null;
        try {
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String model = rs.getString(1);
                int count = rs.getInt(2);
                p.put(model, count);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }

    @Override
    public LinkedHashMap<String, Integer> getTopZip() {
        LinkedHashMap<String, Integer> p = new LinkedHashMap();
        String sql = "SELECT zipcode, SUM(orderquantity) AS TotalItemsSold FROM `order` group by zipcode ORDER BY SUM(orderquantity) DESC limit 5";

        Connection conn = MySqlDataStoreUtilities.getConnection();
        ResultSet rs = null;
        try {
            rs = conn.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                String model = rs.getString(1);
                int count = rs.getInt(2);
                p.put(model, count);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        String sql = "update productcatalog set name=?,price=?,loanamount=?,image=?,manufacturer=?,rating=?,quantity=?,type=?,creditscore=? where productid=?";
        update(sql,product.getName(),product.getPrice(),product.getLoanamount(),product.getImage(),product.getManufacturer(),product.getRating(),product.getQuantity(),product.getType(),product.getCreditscore(),product.getProductid());
    }

    public void deleteProduct(Integer id) throws Exception {
        String sql = "delete from productcatalog where productid=?";
        update(sql,id);
    }
}
