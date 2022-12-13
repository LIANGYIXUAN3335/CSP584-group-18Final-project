package com.iit.servlet.model;

import com.iit.bean.Product;
import com.iit.bean.Review;
import com.iit.service.ProductService;
import com.iit.service.impl.ProductServiceImpl;
import com.iit.servlet.base.ModelBaseServlet;
import com.iit.utils.MongoDBDataStoreUtilities;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ReviewServlet extends ModelBaseServlet {

    ProductService productService = new ProductServiceImpl();
    MongoDBDataStoreUtilities mdsu;

    public void storeReviewToMongo(HttpServletRequest request,HttpServletResponse response) {
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        storeDataToMongoDB(request, response, productId);
        try {
            response.sendRedirect(request.getContextPath()+"/product?method=toViewProductPage&id="+productId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void storeDataToMongoDB(HttpServletRequest request, HttpServletResponse response,
                                    Integer productId) {
        Product product;
        try {
            product = productService.filterById(productId);
            int prodId = product.getProductid();
            String productName = product.getName();
            double productPrice = product.getPrice();
            String type = product.getType();
            String manufacturer = product.getManufacturer();
            String manufacturerRebate="Yes";
            boolean productOnSale = (product.getQuantity() > 0 ? true : false);
            String retailername = request.getParameter("retailername");
            String retailerzip = request.getParameter("retailerzip");
            String retailercity = request.getParameter("retailercity");
            String retailerstate = request.getParameter("retailerstate");
            String username = request.getParameter("reviewername");
            String age = request.getParameter("reviewerage");
            String gender = request.getParameter("reviewergender");
            String occupation = request.getParameter("revieweroccupation");
            int rating = Integer.parseInt(request.getParameter("ratings"));
            String review = request.getParameter("review");
            String time = new Date(System.currentTimeMillis()).toString();
            // System.out.println(time);
            Review rev = new Review(prodId, productName, productPrice, type, manufacturer,manufacturerRebate, productOnSale ,retailername, retailerzip, retailercity, retailerstate,
                    username, age, gender, occupation, rating, review, time);
            mdsu = new MongoDBDataStoreUtilities();
            mdsu.storeReview(rev);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
