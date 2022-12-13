package com.iit.service.impl;

import com.iit.bean.User;
import com.iit.dao.UserDao;
import com.iit.dao.impl.UserDaoImpl;
import com.iit.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User doLogin(User parameterUser) throws Exception {
        User loginUser = userDao.findByUsername(parameterUser.getUserid());

        if (loginUser != null) {
            String password = parameterUser.getPassword();
            String dbPwd = loginUser.getPassword();
            if (dbPwd.equals(password)) {
                return loginUser;
            } else {
                throw new RuntimeException("Password is wrong");
            }
        }
        throw new RuntimeException("Username is wrong");
    }

    @Override
    public void doRegister(User user) throws Exception {

        User existUser = userDao.findByUsername(user.getUserid());
        if (existUser != null) {
            throw new RuntimeException("User have existed");
        }
        userDao.addUser(user);
    }
}
