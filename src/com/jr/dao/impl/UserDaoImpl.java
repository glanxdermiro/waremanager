package com.jr.dao.impl;


import com.jr.dao.UserDao;
import com.jr.pojo.User;
import util.DBHelper;

import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    DBHelper db = new DBHelper();

    @Override
    public User selectUser(String name) {
        String sql = "select * from user where uName=? ";
        ArrayList list = db.queryBooks(sql, User.class, name);
        if (list.size() >= 1) {
            return (User)list.get(0);
        }
        return null;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into user values(?,?,?)";
        return db.updateTable(sql, user.getuID(),user.getuName(),user.getuPassword());
    }
}
