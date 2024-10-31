package com.jr.dao.impl;


import com.jr.dao.ProductDao;
import com.jr.pojo.InformationOfProduct;
import com.jr.pojo.Product;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDaoImpl implements ProductDao {
    DBHelper db = new DBHelper();
    @Override
    public Product selectByPno(String pno) {
        String sql = "select * from product where pno=? ";
        ArrayList list = db.queryBooks(sql, Product.class, pno);
        return (Product)list.get(0);
    }

    @Override
    public ArrayList<InformationOfProduct> selectProductByDate() {
        ArrayList<InformationOfProduct> list = new ArrayList<>();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //使用工具类中的连接
            con = db.getCon();
            String sql = "select DISTINCT product.pID,pName,pDate,pDeadDate,p_stock.productSum,stock.sID,sType,wName from stock,ware,product,p_stock,p_ware where product.pID=p_ware.pID and product.pID=p_stock.pID and p_ware.wID=ware.wID and p_stock.sID=stock.sID and stock.wID=ware.wID ";
            ps = con.prepareStatement(sql);
            //5.执行sql，获得结果
            rs = ps.executeQuery();

            //6.处理结果
            while (rs.next()) {
                InformationOfProduct information = new InformationOfProduct();
                information.nProId = rs.getInt("product.pID");
                information.nProName = rs.getString("pName");
                information.nDate = rs.getString("pDate");
                information.nDeadDate = rs.getString("pDeadDate");
                information.nProductSum = rs.getInt("p_stock.productSum");
                information.nSID = rs.getInt("stock.sID");
                information.nType = rs.getString("sType");
                information.nName = rs.getString("wName");
                list.add(information);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.closeAll(con,ps,rs);
        }
        return list;
    }

}
