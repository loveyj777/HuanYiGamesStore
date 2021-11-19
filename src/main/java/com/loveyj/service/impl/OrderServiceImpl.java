package com.loveyj.service.impl;


import com.loveyj.mapper.OrderMapper;
import com.loveyj.mapper.UserMapper;
import com.loveyj.pojo.Order;
import com.loveyj.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<Order> getOrderByUid(int uid) {

        return orderMapper.getOrderByUid(uid);
    }

    @Override
    public List<Order> getFinishOrderByUid(int uid) {
        return orderMapper.getFinishOrderByUid(uid);
    }


    @Override
    public List<Order> getNoPayOrderByUid(int uid) {

        return orderMapper.getNoPayOrderByUid(uid);
    }

    @Override
    public int deleteUserOrderById(int id) {
        return orderMapper.deleteUserOrderById(id);
    }


    @Override
    public int insertOrderNotPay(int uid, String uName, int orderPoints) {
        return  orderMapper.insertOrderNotPay(uid,uName,orderPoints);
    }

    @Override
    public int updateOrderIsPay( int id) {
        return orderMapper.updateOrderIsPay(id);
    }

    @Override
    public Order getOrderIDByUid(int uid) {
        return orderMapper.getOrderIDByUid(uid);
    }
}
