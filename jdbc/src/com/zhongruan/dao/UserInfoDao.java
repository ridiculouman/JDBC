package com.zhongruan.dao;

import com.zhongruan.bean.UserInfo;
import com.zhongruan.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDao {
    public List<UserInfo> findAll() {
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        List<UserInfo> list = new ArrayList<>();
        try {
            // 1.加载驱动
            // 2.创建连接
            connection = DBUtil.getConnection();
            System.out.println("创建连接成功");
            // 3.写sql
            String sql = "select * from userinfo";
            // 4.得到statement对象
            statement = connection.prepareStatement(sql);
            // 5.执行sql得到结果集
            rs = statement.executeQuery();
            // 6.处理结果集
            while (rs.next()) {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(rs.getInt(1));
                userInfo.setUsername(rs.getString(2));
                userInfo.setPassword(rs.getString(3));
                list.add(userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 7.关闭资源
            DBUtil.close(rs, statement, connection);
        }
        return list;
    }

    public void add() {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "insert into userinfo(username,password) values(?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "hahaha");
            statement.setString(2, "1234");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            DBUtil.close(null, statement, connection);
        }
    }

    public void del() {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "delete from userinfo where username=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "hahaha");
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, statement, connection);
        }
    }

    public void update() {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "update userinfo set password=? where id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "1234567");
            statement.setInt(2, 2);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null, statement, connection);
        }
    }
}
