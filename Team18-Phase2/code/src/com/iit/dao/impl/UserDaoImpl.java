package com.iit.dao.impl;

import com.iit.bean.User;
import com.iit.dao.BaseDao;
import com.iit.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User findByUsername(String username) throws Exception{
        String sql = "select * from user where userid=?";
        return getBean(User.class,sql,username);
    }

    @Override
    public void addUser(User user) throws Exception {
        String sql = "insert into user (userid,password,fname,lname,email,mno,preference,role) values (?,?,?,?,?,?,?,?)";
        update(sql,user.getUserid(),user.getPassword(),user.getFname(),user.getLname(),user.getEmail(),user.getMno(),user.getPreference(),user.getRole());
    }

    @Override
    public void updateUser(User user) throws Exception {
        String sql = "update user set password=?,fname=?,lname=?,email=?,mno=?,preference=? where userid=?";
        update(sql,user.getPassword(),user.getFname(),user.getLname(),user.getEmail(),user.getMno(),user.getPreference(),user.getUserid());
    }
}
