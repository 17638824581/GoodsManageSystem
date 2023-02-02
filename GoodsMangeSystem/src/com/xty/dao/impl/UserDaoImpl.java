package com.xty.dao.impl;

import com.xty.bean.User;
import com.xty.dao.BaseDao;
import com.xty.dao.UserDao;
import com.xty.utils.JdbcUtils;

import java.sql.Connection;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public boolean addUser(String username, String name, String password) {
        Connection conntion = JdbcUtils.getConntion();
        String sql = "insert into `user`(`username`,`name`,`password`) values(?,?,?)";
        int update = update(conntion, sql, username, name, password);
        JdbcUtils.close(conntion);

        return update >= 1;
    }

    @Override
    public User queryByUsername(String username) {
        Connection conntion = JdbcUtils.getConntion();
        String sql = "select * from `user` where `username` = ?";
        User user = queryOne(User.class, conntion, sql, username);
        JdbcUtils.close(conntion);

        return user;
    }
}
