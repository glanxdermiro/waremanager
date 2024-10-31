package com.jr.service.impl;


import com.jr.dao.StockDao;
import com.jr.dao.WareDao;
import com.jr.dao.impl.StockDaoImpl;
import com.jr.dao.impl.WareDaoImpl;
import com.jr.pojo.Stock;
import com.jr.pojo.Ware;
import com.jr.service.ProductService;
import com.jr.service.WareService;
import com.jr.test.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class WareServiceImpl implements WareService {
    ProductService productService = new ProductServiceImpl();
    StockDao stockDao = new StockDaoImpl();
    WareDao wareDao = new WareDaoImpl();
    Scanner input = new Scanner(System.in);

    @Override
    public boolean addWare() {
        System.out.println("请输入想要增加的仓库名称：");
        String name = input.next();
        int i = 0;
        if (wareDao.selectWare(name) == null) {
            Ware ware = new Ware();
            ware.setwName(name);
            System.out.println("请输入仓库容量：");
            int capacity = input.nextInt();
            ware.setwV(capacity);
            System.out.println("请输入仓库地址：");
            String address = input.next();
            ware.setwAddress(address);
            ware.setWno(UUID.randomUUID().toString().substring(30));
            i = wareDao.insertWare(ware);

        } else {
            System.out.println("仓库已经存在，请重新输入！");
            new WareServiceImpl().addWare();
        }
        return i == 0 ? false : true;
    }

    @Override
    public ArrayList<Ware> queryWares() {
        System.out.println("请输入查询类型？（1.按照名称查询2.按照类型查询)");
        int number = input.nextInt();
        if (number == 1) {
            System.out.println("请输入要查询的仓库名称：");
            String name = input.next();
            Ware ware = wareDao.selectWare(name);
            if (ware == null) {
                System.out.println("您查找的仓库不存在！");
                new Test().wareMenu();
            } else {
                ArrayList<Ware> list = new ArrayList<>();
                list.add(ware);

                return list;
            }
        } else if (number == 2) {
            System.out.println("请输入要查询的仓库类型：（高温，常温，低温）");
            String type = input.next();
            ArrayList list = wareDao.selectByType(type);
            if (list == null) {
                System.out.println("没有符合条件的仓库");
                new Test().wareMenu();
            } else {
                return list;
            }

        } else {
            System.out.println("输入错误，请重新输入！");
            new WareServiceImpl().queryWares();
        }
        return null;
    }

    @Override
    public boolean removeByName() {

        String name="123";
        String name2="321";
        while (!name.equals(name2)) {
            System.out.println("请输入想要删除的仓库名称(两次名称要一致）");
            System.out.println("请输入想要删除的仓库名称：");
            name = input.next();
            System.out.println("请再次输入想要删除的仓库名称：");
            name2 = input.next();
        }

        Ware ware = wareDao.selectWare(name);
        Integer wid = ware.getwID();
        Stock stock = stockDao.selectByWid(wid);
        if (stock == null) {
            System.out.println("此仓库无库存，已删除成功！");
            int i = wareDao.deleteWare(wid);
            if (i != 0) {
                return true;
            } else {
                return false;
            }
        } else {
            if (stock.getsVed() == 0) {
                System.out.println("此仓库中有库存，但库存为空，因此将仓库与库存一同删除！");
                wareDao.deleteWare(wid);
                stockDao.deleteStock(stock.getsID());
                return true;
            } else {
                System.out.println("仓库中有产品，删除失败！");
                new Test().wareMenu();
            }
        }
        return false;
    }


    @Override
    public boolean changeWare() {
        System.out.println("以下是仓库列表");
        Ware ware = null;
        ArrayList<Ware> wares = wareDao.selectWare(ware);
        for (Ware s : wares) {
            System.out.println(s);
        }
        System.out.println("请输入想要修改的仓库名称：");
        String name = input.next();
        Ware ware1 = wareDao.selectWare(name);
        while (ware1 == null) {
            System.out.println("仓库不存在，请重新输入:");
            System.out.println("请输入想要修改的仓库名称：");
            ware1 = wareDao.selectWare(input.next());
        }
        System.out.println("您想要修改仓库的哪些信息？（1.仓库名称2.仓库容量3.仓库地址）");
        int number = input.nextInt();
        if (number == 1) {
            System.out.println("请输入新的仓库名称：");
            String newname = input.next();
            while (wareDao.selectWare(newname) != null) {
                System.out.println("仓库名称重复，请重新输入！");
                newname = input.next();
            }
            ware1.setwName(newname);
            wareDao.updateWare(ware1);
            return true;
        } else if (number == 2) {
            Integer wid = ware1.getwID();
            Stock stock = stockDao.selectByWid(wid);
            if (stock == null) {
                System.out.println("请输入修改后的仓库容量：");
                Integer wv = input.nextInt();
                System.out.println("修改成功！");
                ware1.setwV(wv);
                wareDao.updateWare(ware1);
                return true;
            } else {
                Integer sv = stock.getsV();
                System.out.println("请输入修改后的仓库容量：");
                Integer wv = input.nextInt();
                if(wv>=sv){
                    System.out.println("修改成功！");
                    ware1.setwV(wv);
                    wareDao.updateWare(ware1);
                    return true;
                }else {
                    System.out.println("输入内容少于库存容量，修改失败！");
                    new Test().wareMenu();
                    return false;
                }
            }
        } else if (number == 3) {
            System.out.println("请输入新的仓库地址：");
            String newaddress = input.next();
            ware1.setwAddress(newaddress);
            wareDao.updateWare(ware1);
            return true;
        }
        return false;
    }
}
