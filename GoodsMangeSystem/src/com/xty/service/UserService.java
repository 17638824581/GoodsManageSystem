package com.xty.service;

public interface UserService {
    
    /**
     * 用户登录的业务
     * @param username: 用户输入的用户名
	 * @param password: 用户输入的密码
     * @return boolean: 登录是否成功
     * @author Mr.yu
     * @date 2023/2/2 15:17
     */
    boolean login(String username,String password);


    /**
     * 用户注册的业务
     * @param username: 用户输入的用户名
     * @param name: 账号昵称
     * @param password: 用户密码
     * @return boolean: 返回是否注册成功
     * @author Mr.yu
     * @date 2023/2/2 15:19
     */
    boolean regist(String username,String name,String password);
}
