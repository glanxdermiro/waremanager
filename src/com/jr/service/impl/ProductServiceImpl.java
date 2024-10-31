package com.jr.service.impl;


import com.jr.dao.ProductDao;
import com.jr.dao.impl.ProductDaoImpl;
import com.jr.pojo.InformationOfProduct;
import com.jr.pojo.Product;
import com.jr.service.ProductService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();


    @Override
    public Product queryProduct(String pno) {
        return productDao.selectByPno(pno);
    }



    @Override
    public ArrayList<InformationOfProduct> qualityList() {
        ArrayList<InformationOfProduct> products = productDao.selectProductByDate();//得到所有产品信息
        Iterator iterator ;  //写一个遍历器
        ArrayList<InformationOfProduct> expireProduct = new ArrayList<>();
        try {
            iterator= products.iterator();
            while (iterator.hasNext()) {
                InformationOfProduct next = (InformationOfProduct)iterator.next();
                String deadDate = next.getnDeadDate();
                String date = next.getnDate();

                //现在时间-生产时间<保质期<现在时间-生产时间+10
                Date now = new Date();//获取当前系统时间
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.format(now);

                Date dateForProduce = sdf.parse(date);
                System.out.println(now);

                long time1 = dateForProduce.getTime();
                long time2 = now.getTime();
                int days = (int) (time2 - time1) / (1000 * 60 * 60 * 24);

                if (Integer.parseInt(deadDate)<(days+10) && Integer.parseInt(deadDate)>(days)) {
                    expireProduct.add(next);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return expireProduct;
    }

    @Override
    public void showExpireProduct() {
        ArrayList<InformationOfProduct> informationOfProducts = qualityList();
        System.out.println(informationOfProducts.get(0));
        if (informationOfProducts !=null) {
            System.out.println("----------------------------------------------------------------");
            System.out.println("以下是即将过期的产品，请注意！");
            System.out.println("产品id\t产品名称\t生产日期\t保质期\t产品数量\t库存id\t库存类型\t仓库名字");
            for (InformationOfProduct s : informationOfProducts) {
                System.out.println(s.getnProId()+"\t"+s.getnProName()+"\t"+s.getnDate()+"\t"+s.getnDeadDate()+"\t"+s.getnProductSum()
                        +"\t"+s.getnSID()+"\t"+s.getnType()+"\t"+s.getnName());
            }
            System.out.println("----------------------------------------------------------------");
        }
    }




}
