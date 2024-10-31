package com.jr.dao;

import com.jr.pojo.User;

public interface UserDao {

    /**
     * 查询用户是否存在
     * @param name
     * @return 存在则返回用户，不存在返回null
     */
    User selectUser(String name);


    /**
     * 在用户表里插入新用户
     * @param user
     * @return 返回值1，表示插入成功，0表示不成功
     */
    int insertUser(User user);
}
