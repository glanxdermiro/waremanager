package com.jr.dao;


import com.jr.pojo.P_stock;
import com.jr.pojo.Product;
import com.jr.pojo.Stock;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StockDao {

    /**
     * insertStock在仓库里添加库存
     * @param stock：要存储的库存对象
     * @return 该方法返回值是int类型：0--添加失败；>0--添加成功
     */
    int insertStock(Stock stock);


    /**
     * selectStock 根据条件查询库存：
     * @param type 根据产品类型（常温，低温，高温）和可存储的数量查询符合条件的库存信息
     * @return 返回的是符合条件的所有库存对象的集合
     */

    ArrayList<Stock> selectStock(String type,int num) throws SQLException;


    /**
     * 根据库存编号查库存
     * @param sid
     * @return
     */
    Stock selectStock(Integer sid);



    /**
     * 查询所有库存（全查）
     * @return 返回所有库存信息：内容包括仓库名称和仓库地址
     */
    ArrayList selectWare() throws ClassNotFoundException, SQLException;



    /**
     * updateBook 修改库存信息：实现产品入库
     * @param num：增加的库存量
     * @return 该方法返回值是int类型：0--修改失败；>0--修改成功
     */
    int insertInStock(Integer sid,int num);


    /**
     * 在产品库存关联表里插入数据
     * @param pid
     * @param sid
     * @return
     */
    int insertInP_Stock(Integer pid, Integer sid,String time,Integer sum);


    /**
     * 在产品仓库关联表里插入数据
     * @param pid
     * @param wid
     * @return
     */
    int insertInP_Ware(Integer pid, Integer wid);


    /**
     * 根据产品编号查询产品存储信息（存于哪个库存之中）
     * @param pid
     * @return
     */
    ArrayList getP_Stock(Integer pid,Integer sum);


    /**
     * 根据psid主键，查询关联表对象
     * @param psid
     *
     */
    P_stock getP_Stock(Integer psid);



    /**
     * deleteInStock 修改库存信息：实现产品出库
     * @param num：减少的库存量
     * @return 该方法返回值是int类型：0--修改失败；>0--修改成功
     */
    int deleteInStock(Integer sid,int num);


    /**
     * 当库存内容全部取出时调用
     *根据主键删除产品库存关联表
     * @param psID
     * @return 返回0删除失败，>0--删除成功
     */
    int deleteP_Stock(Integer psID);


    /**
     * 当库存内容全部取出时才会调用
     * 根据产品主键和仓库主键删除产品仓库关联表
     * @param pid
     * @param wid
     * @return 0->删除失败，>0--删除成功
     */
    int deleteP_Ware(Integer pid, Integer wid);


    /**
     * 减少产品库存关联表中产品的数量
     * @param psID
     * @param sum  减少的数量
     * @return
     */
    int deleteInP_Stock(Integer psID, Integer sum);


    /**
     * 查询库存信息
     * @param wid 根据仓库id进行查询，查询仓库是否有库存
     * @return 有则将库存返回，null则表示仓库没有库存
     */
    Stock selectByWid(Integer wid);


    /**
     * 删除库存
     * @param sid 参数为库存的id
     * @return 0删除失败，>0--删除成功
     */
    int deleteStock(Integer sid);


}
