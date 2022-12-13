package com.iit.servlet.model;

import com.iit.dao.ProductDao;
import com.iit.dao.impl.ProductDaoImpl;
import com.iit.servlet.base.ModelBaseServlet;
import com.iit.utils.MongoDBDataStoreUtilities;
import com.iit.utils.MySqlDataStoreUtilities;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;

public class TrendServlet extends ModelBaseServlet {

    ProductDao productDao = new ProductDaoImpl();
    public void toTrendPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MongoDBDataStoreUtilities mdsu = new MongoDBDataStoreUtilities();
        LinkedHashMap<String, Integer> zipCode = productDao.getTopZip();
        LinkedHashMap<String, Float> mostLiked = mdsu.getMostLiked();
        LinkedHashMap<String,Integer> mostSold = productDao.getMostSelled();
        request.setAttribute("mostsold",mostSold);
        request.setAttribute("mostlike",mostLiked);
        request.setAttribute("zipcode",zipCode);

        processTemplate("product/trend", request, response);
    }
}
