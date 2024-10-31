package com.jr.service.impl;


import com.jr.dao.UserDao;
import com.jr.dao.impl.UserDaoImpl;
import com.jr.pojo.User;
import com.jr.service.UserService;

import java.util.Scanner;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    Scanner input = new Scanner(System.in);

    @Override
    public boolean register() {
        System.out.println("请输入用户名：");
        String name=input.next();
        //根据用户名在用户表中进行查询，若存在此名字，则得到的user为null
        if(userDao.selectUser(name)==null) {
            User user = new User();
            String password="123";   //给两次输入的password赋初始值，确保第一次进入循环
            String password2="321";
            while (!password.equals(password2)) {
                System.out.println("请输入密码：");
                password = input.next();
                System.out.println("请再次输入密码：");
                password2 = input.next();
            }
            user.setuName(name);
            user.setuPassword(password);
            user.setuID(UUID.randomUUID().toString().substring(30));
            int i = userDao.insertUser(user);
            return i==0?false:true;
        }else {
            System.out.println("此用户名已存在，请重新注册！");
            new UserServiceImpl().register();
        }
        return true;
    }

    @Override
    public boolean login() {
        System.out.println("请输入用户名：");
        String name = input.next();
        int i=0;
        if (userDao.selectUser(name) != null) {
            User user = userDao.selectUser(name);
            System.out.println("请输入密码：");
            String password = input.next();
            if(user.getuPassword().equals(password)){
                System.out.println("登录成功！");
                i=1;
            }else {
                System.out.println("密码输入错误，请重新登录！");
                new UserServiceImpl().login();
            }
        }else {
            System.out.println("不存在此用户，请重新登录！");
            new UserServiceImpl().login();
        }

        return i==0?false:true;
    }
}
