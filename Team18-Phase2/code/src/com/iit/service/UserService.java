package com.iit.service;

import com.iit.bean.User;

public interface UserService {
    void doRegister(User user) throws Exception;
    User doLogin(User parameterUser) throws Exception;
}
