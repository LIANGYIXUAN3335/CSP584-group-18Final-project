package com.iit.servlet.model;

import com.iit.bean.Product;
import com.iit.bean.User;
import com.iit.constant.StoreConstants;
import com.iit.dao.UserDao;
import com.iit.dao.impl.UserDaoImpl;
import com.iit.service.UserService;
import com.iit.service.impl.UserServiceImpl;
import com.iit.servlet.base.ModelBaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;

public class UserServlet extends ModelBaseServlet {
    private UserService userService = new UserServiceImpl();

    public void toLoginPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processTemplate("user/login", request, response);
    }

    public void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();

        try {
            BeanUtils.populate(user,parameterMap);
            User loginUser = userService.doLogin(user);
            request.getSession().setAttribute(StoreConstants.USERSESSIONKEY,loginUser);
            processTemplate("user/login_success",request,response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage","login failed,"+e.getMessage());
            processTemplate("user/login",request,response);
        }
    }

    public void toRegisterPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processTemplate("user/regist", request, response);
    }

    public void toEditUserPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid = request.getParameter("id");
        UserDao userDao = new UserDaoImpl();
        try {
            User user = userDao.findByUsername(uid);
            request.setAttribute("user",user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        processTemplate("user/edit_user", request, response);
    }

    public void doRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user, parameterMap);
            userService.doRegister(user);
            processTemplate("user/regist_success", request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage","register failed,"+e.getMessage());
            processTemplate("user/regist",request,response);
        }

    }

    public void doUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserDao userDao = new UserDaoImpl();
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user, parameterMap);
            userDao.updateUser(user);
            response.sendRedirect(request.getContextPath()+"/user?method=toEditUserPage&id="+user.getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath()+"/index.html");
    }

}
