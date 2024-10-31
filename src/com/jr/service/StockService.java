package com.jr.service;

import com.jr.pojo.Stock;

import java.util.ArrayList;

public interface StockService {

    /**
     *  新增库存功能
     * ware 要添加的库存对象
     * @return true添加成功  false添加失败
     */
    boolean addStock();


    /**
     * queryStock:查询所有库存
     * @return 符合条件的仓库数据的集合
     */
    ArrayList queryAllStock();



    /**
     * 产品入库
     * @return true-入库成功，false-入库失败
     */
    boolean addProduct();


    /**
     * 产品出库
     * @return true-出库成功，false-出库失败
     */
    boolean removeProduct();


    /**
     * 产品调拨
     * @return 成功返回true，失败返回false
     */
    boolean changeProduct();
}
