package com.jr.service;

public interface UserService {

    /**
     * 注册功能
     * @return
     * 返回true：注册成功
     * 返回false：注册失败
     */
    boolean register();


    /**
     * 登录功能
     * @return
     * 返回true：登录成功
     * 返回false：登录失败
     */
    boolean login();
}
