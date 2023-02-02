package com.xty.dao;

import com.xty.bean.User;

/**
 * UserDao 针对于 user 表的增删改查方法
 */
public interface UserDao {

    // 向user中插入数据
    boolean addUser(String username, String name, String password);

    // 根据用户名查询用户信息
    User queryByUsername(String username);

}
