package com.iit.servlet.model;

import com.iit.bean.Product;
import com.iit.bean.Review;
import com.iit.bean.User;
import com.iit.dao.ProductDao;
import com.iit.dao.impl.ProductDaoImpl;
import com.iit.service.ProductService;
import com.iit.service.impl.ProductServiceImpl;
import com.iit.servlet.base.ModelBaseServlet;
import com.iit.utils.MongoDBDataStoreUtilities;
import com.iit.utils.MySqlDataStoreUtilities;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import javax.servlet.http.HttpSession;

public class ProductServlet extends ModelBaseServlet {
    MongoDBDataStoreUtilities mdsu;
    MySqlDataStoreUtilities msql;
    ProductService productService = new ProductServiceImpl();
    public void showProductList(HttpServletRequest request,HttpServletResponse response) {
        String type = request.getParameter("type");
        String manufacturer = request.getParameter("manufacturer");
        List<Product> productlist = new ArrayList<Product>();
        try {
            if(manufacturer==null) {
                productlist = productService.filterByType(type);
            }else {
                productlist = productService.filterByManufacturer(type, manufacturer);
            }
            request.setAttribute("type",type);
            request.setAttribute("productlist",productlist);
            processTemplate("product/productlist",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showInsInvProductList(HttpServletRequest request,HttpServletResponse response) {
        String type = request.getParameter("type");
        String manufacturer = request.getParameter("manufacturer");
        List<Product> InsInvproductlist = new ArrayList<Product>();
        try {
            if(manufacturer==null) {
                InsInvproductlist = productService.filterByType(type);
            }else {
                InsInvproductlist = productService.filterByManufacturer(type, manufacturer);
            }
            request.setAttribute("type",type);
            request.setAttribute("productlist",InsInvproductlist);
            processTemplate("product/InsInvproductlist",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toViewProductPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        int productID = Integer.parseInt(request.getParameter("id"));
        try {
            Product product = productService.filterById(productID);
            request.setAttribute("product",product);
            mdsu = new MongoDBDataStoreUtilities();
            HashMap<String, ArrayList<Review>> reviews = mdsu.readReview(productID);
            ArrayList<Review> review = reviews.get(request.getParameter("id"));
            request.setAttribute("review",review);
        } catch (Exception e) {
            e.printStackTrace();
        }
        processTemplate("product/viewproduct",request,response);
    }

    public void storeReviewToMongo(HttpServletRequest request,HttpServletResponse response) {
        Integer productId = Integer.parseInt(request.getParameter("productId"));
        try {
            storeDataToMongoDB(request, response, productId);
            response.sendRedirect(request.getContextPath()+"/product?method=toViewProductPage&id="+productId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toAddProductPage(HttpServletRequest request,HttpServletResponse response) throws IOException {

        processTemplate("product/addproduct",request,response);
    }

    public void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        Integer productId = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("productName");
        Double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        String manufacturer = request.getParameter("manufacturer");
        Double rating = Double.parseDouble(request.getParameter("rating"));
        String creditscore = request.getParameter("creditscore");
        Double loanamount = Double.parseDouble(request.getParameter("loanamount"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        String type = request.getParameter("type");
        Product product= new Product(productId,name,price,image,manufacturer,creditscore,loanamount,rating,quantity,type);
        try {
            productService.saveProduct(product);
            processTemplate("product/add_product_success",request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage","add product failed,"+e.getMessage());
            processTemplate("product/addproduct",request,response);
        }
    }

    public void toEditProductPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productID = Integer.parseInt(request.getParameter("id"));
        try {
            Product product = productService.filterById(productID);
            request.setAttribute("product",product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        processTemplate("product/editproduct",request,response);
    }

    public void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductDao productDao = new ProductDaoImpl();
        try {
            int productID = Integer.parseInt(request.getParameter("productid"));
            Map<String, String[]> parameterMap = request.getParameterMap();
            Product product = new Product();
            BeanUtils.populate(product, parameterMap);
            productDao.updateProduct(product);
            response.sendRedirect(request.getContextPath()+"/product?method=toViewProductPage&id="+productID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int productID = Integer.parseInt(request.getParameter("id"));
        ProductDao productDao = new ProductDaoImpl();
        try {
            productDao.deleteProduct(productID);
            request.setAttribute("productid",productID);
            processTemplate("product/delete_success",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void storeDataToMysql(HttpServletRequest request, HttpServletResponse response,
                                    Integer productId,String name, Double price,String image,Double loanamount,String manufacturer,Double rating,int quantity,String type,String creditscore) {
        Product product= new Product(productId,name,price,image,manufacturer,creditscore,loanamount,rating,quantity,type);
        try {
            productService.saveProduct(product);
        } catch (Exception e) {
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
