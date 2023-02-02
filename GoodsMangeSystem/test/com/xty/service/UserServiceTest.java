package com.xty.service;

import com.xty.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void login() {
        UserServiceImpl userService = new UserServiceImpl();

        String uname = "xingtingyu";
        String psd = "123";

        boolean login = userService.login(uname, psd);

        System.out.println("login = " + login);
    }

    @Test
    public void regist() {

        String un  = "xiaozhang123";
        String name = "小张";
        String psd = "123";

        boolean regist = new UserServiceImpl().regist(un, name, psd);

        System.out.println("regist = " + regist);

    }
}