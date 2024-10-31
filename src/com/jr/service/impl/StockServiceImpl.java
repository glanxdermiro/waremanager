package com.jr.service.impl;


import com.jr.dao.StockDao;
import com.jr.dao.WareDao;
import com.jr.dao.impl.StockDaoImpl;
import com.jr.dao.impl.WareDaoImpl;
import com.jr.pojo.P_stock;
import com.jr.pojo.Product;
import com.jr.pojo.Stock;
import com.jr.pojo.Ware;
import com.jr.service.ProductService;
import com.jr.service.StockService;
import com.jr.test.Test;
import com.sun.javafx.css.CssError;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockServiceImpl implements StockService {
    Scanner input = new Scanner(System.in);
    ProductService productService = new ProductServiceImpl();
    WareDao wareDao = new WareDaoImpl();
    StockDao stockDao = new StockDaoImpl();

    @Override
    public boolean addStock() {
        System.out.println("请选择您要添加库存的仓库名称：");
        String name = input.next();
        Ware ware = wareDao.selectWare(name);
        if (ware == null) {
            System.out.println("不存在此仓库，请重新输入：");
            new StockServiceImpl().addStock();
            return false;
        } else {
            Stock stock = new Stock();
            System.out.println("请输入库存容量：");
            int capacity = input.nextInt();
            while (capacity > ware.getwV()) {
                System.out.println("库存容量超出仓库容量，请重新输入！");
                capacity = input.nextInt();
            }
            System.out.println("请输入库存已用容量");
            int usedCapacity = input.nextInt();
            while (usedCapacity > capacity) {
                System.out.println("库存已用容量超过库存容量，请重新输入！");
                usedCapacity = input.nextInt();
            }
            System.out.println("请输入库存预警容量");
            int warnCapacity = input.nextInt();
            while (warnCapacity > capacity) {
                System.out.println("预警容量超过库存容量，请重新输入！");
                warnCapacity = input.nextInt();
            }
            System.out.println("请输入库存类型：");
            String type = input.next();
            stock.setwID(ware.getwID());
            stock.setsV(capacity);
            stock.setsVed(usedCapacity);
            stock.setsVwarn(warnCapacity);
            stock.setsType(type);
            stockDao.insertStock(stock);
            return true;
        }
    }

    @Override
    public ArrayList queryAllStock() {
        ArrayList list = null;
        try {
            list = stockDao.selectWare();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public boolean addProduct() {
        try {
            System.out.println("请输入要入库的产品编号：");
            String pno = input.next();
            Product product = productService.queryProduct(pno);
            if (product == null) {
                System.out.println("此产品不在产品表中，请重新输入！");
                new StockServiceImpl().addProduct();
            } else {
                String type = product.getpType();
                System.out.println("请输入产品的数量：");
                int number = input.nextInt();
                ArrayList<Stock> stocks = stockDao.selectStock(type, number);
                if (stocks.size() >= 1) {
                    System.out.println("以下是符合条件的库存：");
                    System.out.println("sID\twID\tsV\tsVed\tsVwarn\tsType");
                    for (Stock s : stocks) {
                        System.out.println(s.getsID() + "\t" + s.getwID() + "\t" + s.getsV() + "\t" + s.getsVed() + "\t" + s.getsVwarn() + "\t" + s.getsType());
                    }
                    System.out.println("请从以上库存中选择想要存放的库存编号：");
                    Integer sid = input.nextInt();
                    int i = stockDao.insertInStock(sid, number);
                    if (i != 0) {
                        System.out.println("请输入产品入库时间（年-月-日）");
                        String time = input.next();
                        stockDao.insertInP_Stock(product.getpID(), sid, time,number);
                        stockDao.insertInP_Ware(product.getpID(), stockDao.selectStock(sid).getwID());
                    }
                    return i == 0 ? false : true;
                } else {
                    System.out.println("没有符合条件的库存");
                    new Test().stockMenu();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeProduct() {
        System.out.println("请选择想要出库的产品编号：");
        String pno = input.next();
        Product product = productService.queryProduct(pno);
        if (product == null) {
            System.out.println("此产品不在产品表中，请重新输入！");
            new StockServiceImpl().removeProduct();
        } else{
            System.out.println("请输入要出库的产品数量：");
            Integer sum = input.nextInt();
            ArrayList p_stock = stockDao.getP_Stock(product.getpID(), sum);
            if (p_stock == null) {
                System.out.println("没有符合条件的出库产品信息！");
                new StockServiceImpl().removeProduct();
            }else {
                System.out.println("以下是所有符合条件的产品存储信息");
                for (Object ps : p_stock) {
                    ps=(P_stock)ps;
                    System.out.println("编号\t产品编号\t库存编号\t入库时间\t产品数量");
                    System.out.println(((P_stock) ps).getPsID() + "\t" + ((P_stock) ps).getpID() + "\t" + ((P_stock) ps).getsID() + "\t" + ((P_stock) ps).getInputDate() + "\t" + ((P_stock) ps).getProductSum());
                }
                System.out.println("请从上面的所有结果中选择并输入您要出库的编号：");
                int ps_id = input.nextInt();
                P_stock p_stock1 = stockDao.getP_Stock(ps_id);
                if(p_stock1==null){
                    System.out.println("输入错误，请重新输入！");
                }else {
                    Integer sid = p_stock1.getsID();
                    Integer pid = p_stock1.getpID();
                    Stock stock = stockDao.selectStock(sid);
                    Integer wid = stock.getwID();

                    if (sum == p_stock1.getProductSum()) {
                        stockDao.deleteInStock(sid, sum);
                        stockDao.deleteP_Stock(ps_id);
                        stockDao.deleteP_Ware(pid, wid);
                    } else {
                        stockDao.deleteInStock(sid, sum);
                        stockDao.deleteInP_Stock(ps_id, sum);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean changeProduct() {
        try {
            System.out.println("请选择想要调度的产品编号：");
            String pno = input.next();
            Product product = productService.queryProduct(pno);
            if (product == null) {
                System.out.println("此产品不在产品表中，请重新输入！");
                new StockServiceImpl().removeProduct();
            } else {
                System.out.println("请输入调度的产品数量：");
                Integer sum = input.nextInt();
                ArrayList p_stock = stockDao.getP_Stock(product.getpID(), sum);
                if (p_stock == null) {
                    System.out.println("没有符合条件的产品信息！");
                    new StockServiceImpl().removeProduct();
                } else {
                    System.out.println("以下是所有符合条件的产品信息");
                    for (Object ps : p_stock) {
                        ps = (P_stock) ps;
                        System.out.println("编号\t产品编号\t库存编号\t入库时间\t产品数量");
                        System.out.println(((P_stock) ps).getPsID() + "\t" + ((P_stock) ps).getpID() + "\t" + ((P_stock) ps).getsID() + "\t" + ((P_stock) ps).getInputDate() + "\t" + ((P_stock) ps).getProductSum());
                    }
                    System.out.println("请从上面的所有结果中选择并输入您要调度的编号：");
                    int ps_id = input.nextInt();
                    P_stock p_stock1 = stockDao.getP_Stock(ps_id);
                    if (p_stock1 == null) {
                        System.out.println("输入错误，请重新输入！");
                    } else {
                        Integer sid = p_stock1.getsID();
                        Integer pid = p_stock1.getpID();
                        Stock stock = stockDao.selectStock(sid);
                        Integer wid = stock.getwID();
                        Integer productsum = p_stock1.getProductSum();

                        if (sum == p_stock1.getProductSum()) {
                            stockDao.deleteInStock(sid, sum);
                            stockDao.deleteP_Stock(ps_id);
                            stockDao.deleteP_Ware(pid, wid);
                        } else {
                            stockDao.deleteInStock(sid, sum);
                            stockDao.deleteInP_Stock(ps_id, sum);
                        }

                        ArrayList<Stock> stocks = stockDao.selectStock(product.getpType(), productsum);
                        if (stocks.size() >= 1) {
                            System.out.println("以下是符合条件的库存：");
                            System.out.println("sID\twID\tsV\tsVed\tsVwarn\tsType");
                            for (Stock s : stocks) {
                                System.out.println(s.getsID() + "\t" + s.getwID() + "\t" + s.getsV() + "\t" + s.getsVed() + "\t" + s.getsVwarn() + "\t" + s.getsType());
                            }
                            System.out.println("请从以上库存中选择想要存放的库存编号：");
                            Integer sid2 = input.nextInt();
                            int i = stockDao.insertInStock(sid2,sum);
                            if (i != 0) {
                                System.out.println("请输入产品入库时间（年-月-日）");
                                String time = input.next();
                                stockDao.insertInP_Stock(product.getpID(), sid2, time, sum);
                                stockDao.insertInP_Ware(product.getpID(), stockDao.selectStock(sid2).getwID());
                            }
                            return i == 0 ? false : true;
                        } else {
                            System.out.println("没有符合条件的库存");
                            new Test().stockMenu();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
