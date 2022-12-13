package com.iit.servlet.model;

import com.iit.bean.Cart;
import com.iit.bean.Product;
import com.iit.dao.OrderDao;
import com.iit.dao.impl.OrderDaoImpl;
import com.iit.service.ProductService;
import com.iit.service.impl.ProductServiceImpl;
import com.iit.servlet.base.ModelBaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CartServlet extends ModelBaseServlet {

    ProductService productService = new ProductServiceImpl();
    public void addToCart(HttpServletRequest request,HttpServletResponse response) {
        try {
            int productID = Integer.parseInt(request.getParameter("productid"));
            Product product = productService.filterById(productID);
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                cart.addToCart(product);
                session.setAttribute("cart",cart);
            }else {
                cart.addToCart(product);
            }
            processTemplate("cart/cartdetail",request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void toCartPage(HttpServletRequest request,HttpServletResponse response) throws IOException {
        processTemplate("cart/cartdetail",request,response);
    }

    public void cleanCart(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("cart");
        processTemplate("cart/cartdetail",request,response);
    }

    public void removeOrderItem(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        OrderDao orderDao = new OrderDaoImpl();
        try {
            orderDao.deleteOrder(id);
            response.sendRedirect(request.getContextPath()+"/order?method=toVieworderPage");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCartItemCount(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        Integer newCount = Integer.valueOf(request.getParameter("newCount"));
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.updateItemCount(id,newCount);
        processTemplate("cart/cartdetail",request,response);
    }
}
