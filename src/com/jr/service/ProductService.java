package com.jr.service;

import com.jr.pojo.Product;

import java.util.ArrayList;

public interface ProductService {


    /**
     * 查询产品是否在表中的方法
     * @return true-产品在表中，false-产品不在表中
     */
    Product queryProduct(String pno);


    /**
     * 查询所有产品和库存及仓库信息
     * @return 并将新集合返回
     */
    ArrayList qualityList();


    /**
     * 函数，展示所有10天内过期的产品信息
     */
    void showExpireProduct();


}
