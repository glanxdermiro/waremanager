package util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class DBHelper {
    public Connection getCon(){
        Connection con=null;
        try {
            //1.手动加载数据库驱动类：
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获得连接对象：
            String url = "jdbc:mysql://127.0.0.1:3306/waremanager?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
            String username ="root";
            String password ="123456";
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


    //[增删改 通用代码]，3以参数形式传入。
    public int updateTable(String sql,Object... objs){
        Connection con=null;
        PreparedStatement ps=null;
        int count=0;
        try {
            //1+2
            con = getCon();
            //4.获得执行对象
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            //5.执行sql，获得结果
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(con, ps, null);
        }
        //6.忽略
        //7.关闭
        return count;
    }


    //[查 通用方法]，3以参数形式传入。
    public ArrayList queryBooks(String sql, Class c, Object... objs){
        ArrayList list=new ArrayList();
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //1+2
            con = getCon();
            //4.获得执行对象
            ps = con.prepareStatement(sql);
            for (int i = 0; i < objs.length; i++) {
                ps.setObject(i + 1, objs[i]);
            }
            //5.执行sql，获得结果
            rs = ps.executeQuery();//executeQuery()处理查询sql命令
            //6.处理结果：
            while(rs.next()){
                Object obj= c.newInstance();
                Field[] fs = c.getDeclaredFields();
                for (Field f:fs) {
                    String name = f.getName();
                    f.setAccessible(true);//暴力授权；
                    f.set(obj,rs.getObject(name));
                }
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            //7.关闭
            closeAll(con, ps, rs);
        }
        return list;
    }

    public void closeAll(Connection con, PreparedStatement ps, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
