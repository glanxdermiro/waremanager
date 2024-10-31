package com.jr.dao;

import com.jr.pojo.Ware;

import java.sql.SQLException;
import java.util.ArrayList;

public interface WareDao {
    /**
     * insertWare添加仓库
     * @param ware：要存储的仓库对象
     * @return 该方法返回值是int类型：0--添加失败；>0--添加成功
     */
    int insertWare(Ware ware);

    /**
     * selectWare 根据条件查询仓库：
     * @param ware 如果ware为null---表示全查；再逐一判断拥有属性值的个数
     * @return 返回的是符合条件的所有仓库
     */
    ArrayList<Ware> selectWare(Ware ware);


    /**
     * 查询仓库是否存在
     * @param name 仓库名字
     * @return 存在则返回用户，不存在返回null
     */
    Ware selectWare(String name);

    /**
     * deleteWare 删除仓库
     * @param
     * @return 该方法返回值是int类型：0--删除失败；>0--删除成功
     */
    int deleteWare(Integer wid);


    /**
     * updateBook 修改仓库信息
     * @param ware
     * @return 该方法返回值是int类型：0--修改失败；>0--修改成功
     */
    int updateWare(Ware ware);


    /**
     * 根据类型（高温，常温，低温）查询
     * @param type
     * @return 有则返回集合，没有则返回null
     */
    ArrayList selectByType(String type);

}
