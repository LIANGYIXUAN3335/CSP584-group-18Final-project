package com.iit.servlet.model;

import com.iit.bean.*;
import com.iit.constant.StoreConstants;
import com.iit.dao.OrderDao;
import com.iit.dao.impl.OrderDaoImpl;
import com.iit.service.OrderService;
import com.iit.service.impl.OrderServiceImpl;
import com.iit.servlet.base.ModelBaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderServlet extends ModelBaseServlet {
    OrderService orderService = new OrderServiceImpl();

    public void toPlaceOrderPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = (User)request.getSession().getAttribute(StoreConstants.USERSESSIONKEY);

        if (user != null) {
            processTemplate("order/placeorder", request, response);
        } else {
            processTemplate("user/login",request,response);
        }
    }

    public void toVieworderPage(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = (User)request.getSession().getAttribute(StoreConstants.USERSESSIONKEY);
        String uid = user.getUserid();
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> orderlist = new ArrayList<Order>();
        try {
            orderlist = orderDao.selectOrderByUser(uid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("orderlist",orderlist);
        processTemplate("order/orderlist", request, response);
    }

    public void placeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        Order order = new Order();

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Map<Integer,CartItem> cartItemMap = cart.getCartItemMap();

        try {
            BeanUtils.populate(order, parameterMap);

            for (Map.Entry<Integer, CartItem> cartItemEntry : cartItemMap.entrySet()) {
                Integer productId = cartItemEntry.getValue().getProductid();
                order.setProductid(productId);
                order.setTotalamount(cartItemEntry.getValue().getPrice());
                order.setOrderquantity(cartItemEntry.getValue().getCount());
                order.setProductname(cartItemEntry.getValue().getName());
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String strDate = dateFormat.format(new Date(System.currentTimeMillis()));
                order.setCreatetime(strDate);
                System.out.println("order:"+order);
                orderService.saveOrder(order);
            }

            int orderid = orderService.getLastID();

            request.setAttribute("orderid",orderid);
            request.setAttribute("createDate",new Date(System.currentTimeMillis()));
            processTemplate("order/order_success", request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}