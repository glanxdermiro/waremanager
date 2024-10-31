package com.jr.dao.impl;


import com.jr.dao.WareDao;
import com.jr.pojo.Ware;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WareDaoImpl implements WareDao {
    DBHelper db = new DBHelper();
    @Override
    public int insertWare(Ware ware) {
        String sql = "insert into ware(wno,wName,wV,wAddress) values(?,?,?,?)";
        return db.updateTable(sql, ware.getWno(),ware.getwName(),ware.getwV(),ware.getwAddress());
    }

    @Override
    public ArrayList<Ware> selectWare(Ware ware) {
        if (ware == null) {
            String sql = "select * from ware";
            return db.queryBooks(sql, Ware.class);
        }else {

        }
        return null;
    }

    @Override
    public Ware selectWare(String name) {
        String sql = "select * from ware where wName=?";
        ArrayList list = db.queryBooks(sql, Ware.class, name);
        if (list.size() >= 1) {
            return (Ware)list.get(0);
        }
        return null;
    }

    @Override
    public int deleteWare(Integer wid) {
        String sql = "delete from ware where wID=? ";
        return db.updateTable(sql, wid);
    }

    @Override
    public int updateWare(Ware ware) {
        String sql = "update ware set wName=?,wV=?,wAddress=? where wno=? ";
        return db.updateTable(sql, ware.getwName(), ware.getwV(), ware.getwAddress(),ware.getWno());
    }

    @Override
    public ArrayList selectByType(String type){
        ArrayList list = new ArrayList();
        try {
            //使用工具类中的连接
            Connection con = db.getCon();
            String sql = "select DISTINCT ware.wID,wno,wName,wV,wAddress from stock,ware where sType=? and stock.wID=ware.wID";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, type);
            //5.执行sql，获得结果
            ResultSet rs = ps.executeQuery();
            //6.处理结果
            while (rs.next()) {
                Ware ware = new Ware();
                ware.setwID(rs.getInt("wID"));
                ware.setWno(rs.getString("wno"));
                ware.setwName(rs.getString("wName"));
                ware.setwV(rs.getInt("wV"));
                ware.setwAddress(rs.getString("wAddress"));
                list.add(ware);
            }
            //7.关闭
            db.closeAll(con, ps, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
