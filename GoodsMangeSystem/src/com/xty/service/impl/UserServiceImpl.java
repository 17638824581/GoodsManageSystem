package com.xty.service.impl;

import com.xty.bean.User;
import com.xty.dao.impl.UserDaoImpl;
import com.xty.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    /**
     * 用户登录的业务
     *
     * @param username : 用户输入的用户名
     * @param password : 用户输入的密码
     * @return boolean: 登录是否成功
     * @author Mr.yu
     * @date 2023/2/2 15:17
     */
    @Override
    public boolean login(String username, String password) {
        //1. 首先使用用户输入的 username 查询这个用户的信息
        User user = new UserDaoImpl().queryByUsername(username);
        // 当查询不存在的账号信息时，user = null，此时说明此用户不存在，返回 false 登录失败
        if (user == null){
            return false;
        }
        //2. 验证用户输入的 password 是否和数据库中记录一致
        return password.equals(user.getPassword());
    }

    /**
     * 用户注册的业务
     *
     * @param username : 用户输入的用户名
     * @param name     : 账号昵称
     * @param password : 用户密码
     * @return boolean: 返回是否注册成功
     * @author Mr.yu
     * @date 2023/2/2 15:19
     */
    @Override
    public boolean regist(String username, String name, String password) {
        boolean b  = false;
        try {
            b = new UserDaoImpl().addUser(username, name, password);
        }catch (RuntimeException e){
            System.out.println("注册账号重复！");
            return false;
        }
        return b;
    }
}
