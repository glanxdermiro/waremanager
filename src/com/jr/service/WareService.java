package com.jr.service;

import com.jr.pojo.Ware;

import java.util.ArrayList;

public interface WareService {

    /**
     *  新增仓库功能
     * ware 要添加的仓库对象
     * @return true添加成功  false添加失败
     */
    boolean addWare();


    /**
     * queryWares(Ware ware);按条件查询
     * @return 符合条件的仓库数据的集合
     */
    ArrayList<Ware> queryWares();


    /**
     * removeByName;根据仓库名称，删除仓库信息
     * @return 返回值：true删除成功  false删除失败
     */
    boolean removeByName();


    /**
     * changeWare 修改仓库属性
     * @return 返回值：int=0 修改失败  否则修改成功
     */
    boolean changeWare();
}
