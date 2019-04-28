package com.java.dao;

import com.java.entity.OrderCar;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nsp
 * Date: 2019-04-28
 * Time: 19:17
 * Description: No Description
 */
public interface OrederCarDao {
    //加入购物车
    public int addOrder(OrderCar orderCar);
    //从购物车删除
    public int delete(int id);
    //修改订单
    public int update(OrderCar orderCar);
    //查询购物车单个订单
    public OrderCar queryOne(int id);
    //查看购物车所有订单
    public List<OrderCar> queryAll();
}
