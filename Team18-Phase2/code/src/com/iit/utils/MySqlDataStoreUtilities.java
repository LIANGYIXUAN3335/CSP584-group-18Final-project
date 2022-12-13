package com.iit.utils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.iit.bean.DailySale;
import com.iit.bean.Sales;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class MySqlDataStoreUtilities {
    private static DataSource dataSource;
    static {
        try {
            InputStream is = MySqlDataStoreUtilities.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void releaseConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public HashMap<Integer, String> getAjaxData(String searchId) {
        HashMap<Integer, String> data = new HashMap<Integer, String>();
        try {
            Connection con = getConnection();
            String sql = "select productid, name from productcatalog where name like '%" + searchId
                    + "%' and type!= 'Accessory'";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String model = rs.getString(2);
                data.put(id, model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public HashMap<String, ArrayList<Sales>> getAllSale() {
        HashMap<String, ArrayList<Sales>> result = new HashMap<String, ArrayList<Sales>>();
        ArrayList<Sales> sales = new ArrayList<Sales>();
        try {
            Connection con = getConnection();
            String SQL = "select c.productid ,p.name, p.price,p.price * sum(c.orderquantity) as totalsale, sum(c.orderquantity),p.type from `order` as c Join productcatalog as p on c.productid = p.productid group by c.productname";
            ResultSet rs = con.prepareStatement(SQL).executeQuery();
            // System.out.println(rs);
            Sales s = null;
            while (rs.next()) {
                s = null;
                s = new Sales(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getInt(5), rs.getString(6));
                sales.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sales.size() == 0) {
            result.put("ERROR", null);
        } else {

            result.put("All Sale", sales);
        }
        return result;
    }

    public HashMap<String, ArrayList<DailySale>> getDailySale() {
        HashMap<String, ArrayList<DailySale>> result = new HashMap<String, ArrayList<DailySale>>();
        ArrayList<DailySale> sale = new ArrayList<DailySale>();
        try {
            Connection con = getConnection();
            String SQL = "select DATE(DATE_SUB(c.createtime, Interval 15 day)),sum(c.orderquantity) , sum(c.orderquantity * p.price) from `order` as c Join productcatalog as p on c.productid = p.productid group by DATE(DATE_SUB(c.createtime, Interval 15 day)) order by DATE(DATE_SUB(c.createtime, Interval 15 day)) ASC";
            ResultSet rs = con.prepareStatement(SQL).executeQuery();
            DailySale ds = null;
            while (rs.next()) {
                ds = null;
                ds = new DailySale(rs.getString(1), rs.getInt(2), rs.getDouble(3));
                sale.add(ds);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (sale.size() > 0) {
            result.put("Daily Sale", sale);
        } else {
            result.put("ERROR", sale);
        }
        return result;
    }

}
