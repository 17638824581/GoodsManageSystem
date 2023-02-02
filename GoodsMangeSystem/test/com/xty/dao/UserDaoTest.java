package com.xty.dao;

import com.xty.bean.User;
import com.xty.dao.impl.UserDaoImpl;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void addUser() {
        // 只针对于 addUser() 方法进行测试
        String uname = "xingtingyu";
        String name = "老邢";
        String psd = "123";

        UserDao ud = new UserDaoImpl();

        // 调用 addUser() 方法，获取返回值（实际结果）
        boolean actual = ud.addUser(uname, name, psd);
        // 预期结果
        boolean expect = true;

        // 断言 实际返回值和预期返回值是否一致
        Assert.assertEquals(expect,actual);

    }

    @Test
    public void queryByUsername() {
        String name = "xingtingyu";
        UserDao ud = new UserDaoImpl();
        User user = ud.queryByUsername(name);

        System.out.println("user = " + user);

        // 预期结果
        String expect = name;
        // 实际结果
        String actual = user.getUsername();

        // 断言查询到的用户的 用户名 是否 和 xingtingyu 一致
        Assert.assertEquals(expect,actual);

    }
}