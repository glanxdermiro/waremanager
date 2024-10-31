package com.jr.dao;

import com.jr.pojo.Product;

import java.util.ArrayList;

public interface ProductDao {


    /**
     * 根据编号查询产品信息：确认产品是否在产品表中的方法
     * @return 返回产品，返回null则代表产品不存在
     */
    Product selectByPno(String pno);



    /**
     * 多表查询，获得产品基本信息及所在仓库和库存
     * @return 结果以集合形式返回
     */
    ArrayList selectProductByDate();



}
