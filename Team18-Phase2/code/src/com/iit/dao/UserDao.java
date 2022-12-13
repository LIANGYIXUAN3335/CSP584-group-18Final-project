package com.iit.dao;

import com.iit.bean.User;

public interface UserDao {
    User findByUsername(String username) throws Exception;

    void addUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

}
