package com.jr.dao.impl;


import com.jr.dao.StockDao;
import com.jr.pojo.P_stock;
import com.jr.pojo.Product;
import com.jr.pojo.Stock;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;

public class StockDaoImpl implements StockDao {
    DBHelper db = new DBHelper();
    @Override
    public int insertStock(Stock stock) {
        String sql = "insert into stock(wID,sV,sVed,sVwarn,sType) values(?,?,?,?,?)";
        return db.updateTable(sql, stock.getwID(),stock.getsV(),stock.getsVed(),stock.getsVwarn(),stock.getsType());
    }

    @Override
    public ArrayList<Stock> selectStock(String type, int num) throws SQLException {
        //使用工具类中的连接
        Connection con = db.getCon();
        String sql = "select DISTINCT sID,wID,sV,sVed,sVwarn,sType from stock,product where stock.sType=product.pType and sVwarn-sVed>=? and stock.sType=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1,num);
        ps.setString(2,type);
        //5.执行sql，获得结果
        ResultSet rs = ps.executeQuery();
        //6.处理结果
        ArrayList<Stock> list = new ArrayList<>();
        while (rs.next()) {
            Stock stock = new Stock();
            stock.setsID(rs.getInt("sID"));
            stock.setwID(rs.getInt("wID"));
            stock.setsV(rs.getInt("sV"));
            stock.setsVed(rs.getInt("sVed"));
            stock.setsVwarn(rs.getInt("sVwarn"));
            stock.setsType(rs.getString("sType"));
            list.add(stock);
        }
        //7.关闭
        db.closeAll(con, ps, rs);
        return list;
    }

    @Override
    public Stock selectStock(Integer sid) {
        String sql = "select * from stock where sID=? ";
        ArrayList list = db.queryBooks(sql, Stock.class, sid);
        if (list.size() >= 1) {
            return (Stock)list.get(0);
        }
        return null;
    }


    @Override
    public ArrayList selectWare() throws ClassNotFoundException, SQLException {
        //使用工具类中的连接
        Connection con = db.getCon();
        String sql = "select DISTINCT sID,wName,sType,sV,sVed,sVwarn,wAddress from stock,ware where stock.wID=ware.wID ";
        PreparedStatement ps = con.prepareStatement(sql);
        //5.执行sql，获得结果
        ResultSet rs = ps.executeQuery();
        ArrayList list = new ArrayList();
        //6.处理结果
        class All{
            Integer sID;
            String wName;
            String sType;
            Integer sV;
            Integer sVed;
            Integer sVwarn;
            String wAddress;

            @Override
            public String toString() {
                return "All{" +
                        "sID=" + sID +
                        ", wName='" + wName + '\'' +
                        ", sType='" + sType + '\'' +
                        ", sV=" + sV +
                        ", sVed=" + sVed +
                        ", sVwarn=" + sVwarn +
                        ", wAddress='" + wAddress + '\'' +
                        '}';
            }
        }
        while (rs.next()) {
            All all = new All();
            all.sID=rs.getInt("sID");
            all.wName=rs.getString("wName");
            all.sType=rs.getString("sType");
            all.sV=rs.getInt("sV");
            all.sVed=rs.getInt("sVed");
            all.sVwarn=rs.getInt("sVwarn");
            all.wAddress=rs.getString("wAddress");
            list.add(all);
        }
            //7.关闭
            db.closeAll(con, ps, rs);
        return list;
    }

    @Override
    public int insertInStock(Integer sid,int num) {
        String sql = "update stock set sVed=sVed+? where sID=? ";
        return db.updateTable(sql, num, sid);
    }

    @Override
    public int deleteInStock(Integer sid,int num) {
        String sql="update stock set sVed=sVed-? where sID=? ";
        return db.updateTable(sql, num, sid);
    }

    @Override
    public int deleteP_Stock(Integer psID) {
        String sql = "delete from p_stock where psID=? ";
        return db.updateTable(sql, psID);
    }

    @Override
    public int deleteP_Ware(Integer pid, Integer wid) {
        String sql = "delete from p_ware where pID=? and wID=? ";
        return db.updateTable(sql, pid, wid);
    }

    @Override
    public int deleteInP_Stock(Integer psID, Integer sum) {
        String sql="update p_stock set productSum=productSum-? where psID=?";
        return db.updateTable(sql,sum, psID);
    }

    @Override
    public Stock selectByWid(Integer wid) {
        String sql = "select * from stock where wID=?";
        ArrayList list = db.queryBooks(sql, Stock.class, wid);
        if (list.size() >= 1) {
            return (Stock)list.get(0);
        }
        return null;
    }

    @Override
    public int deleteStock(Integer sid) {
        String sql = "delete from stock where sID=? ";
        return db.updateTable(sql, sid);
    }

    @Override
    public int insertInP_Stock(Integer pid, Integer sid,String time,Integer sum) {
        String sql = "insert into p_stock(pID,sID,inputDate,productSum) values(?,?,?,?)";
        return db.updateTable(sql,pid,sid,time,sum);
    }

    @Override
    public int insertInP_Ware(Integer pid, Integer wid) {
        String sql = "insert into p_ware(pID,wID) values(?,?) ";
        return db.updateTable(sql, pid, wid);
    }

    @Override
    public ArrayList getP_Stock(Integer pid, Integer sum) {
        String sql = "select * from p_stock where pID=? and productSum>=? ";
        return db.queryBooks(sql, P_stock.class, pid, sum);
    }

    @Override
    public P_stock getP_Stock(Integer psid) {
        String sql = "select * from p_stock where psID=? ";
        ArrayList list = db.queryBooks(sql, P_stock.class, psid);
        if (list.size() >= 1) {
            return (P_stock)list.get(0);
        }
        return null;
    }


}
