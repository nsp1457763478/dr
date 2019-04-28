package com.java.dao.impl;

import com.java.dao.OrederCarDao;
import com.java.entity.OrderCar;
import com.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nsp
 * Date: 2019-04-28
 * Time: 19:22
 * Description: No Description
 */
public class OrderDaoImpl implements OrederCarDao{
    @Override
    public int addOrder(OrderCar orderCar) {
        Connection conn = JdbcUtil.getConnection();
        String sql = "insert into ordercar(cid,typeName,gid,goodsName,price,amount,sumPrice) values(?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderCar.getCid());
            ps.setString(2,orderCar.getTypeName());
            ps.setInt(3,orderCar.getGid());
            ps.setString(4,orderCar.getGoodsName());
            ps.setDouble(5,orderCar.getPrice());
            ps.setInt(6,orderCar.getAmount());
            ps.setDouble(7,orderCar.getSumPrice());
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from ordercar where cid =?";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(OrderCar orderCar) {
        String sql = "update ordercar set typeName = ?,gid = ?,goodsName =?,price = ?,amount = ?,sumPrice = ? where cid = ?";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,orderCar.getCid());
            ps.setString(2,orderCar.getTypeName());
            ps.setInt(3,orderCar.getGid());
            ps.setString(4,orderCar.getGoodsName());
            ps.setDouble(5,orderCar.getPrice());
            ps.setInt(6,orderCar.getAmount());
            ps.setDouble(7,orderCar.getSumPrice());
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public OrderCar queryOne(int id ) {
        String sql = "select * from ordercar where cid=?";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int cid = rs.getInt("cid");
                String typeName = rs.getString("typeName");
                int gid = rs.getInt("gid");
                String goodsName = rs.getString("goodsName");
                double price = rs.getDouble("price");
                int amount = rs.getInt("amount");
                double sumPrice = rs.getDouble("sumPrice");
                OrderCar orderCar = new OrderCar(cid, typeName, gid, goodsName, price, amount, sumPrice);
                return orderCar;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderCar> queryAll() {
        List<OrderCar> list = new ArrayList<>();
        String sql = "select * from ordercar";
        Connection conn = JdbcUtil.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int cid = rs.getInt("cid");
                String typeName = rs.getString("typeName");
                int gid = rs.getInt("gid");
                String goodsName = rs.getString("goodsName");
                double price = rs.getDouble("price");
                int amount = rs.getInt("amount");
                double sumPrice = rs.getDouble("sumPrice");
                OrderCar orderCar = new OrderCar(cid, typeName, gid, goodsName, price, amount, sumPrice);
                list.add(orderCar);
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
