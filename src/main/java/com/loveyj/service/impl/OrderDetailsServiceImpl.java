package com.loveyj.service.impl;

import com.loveyj.mapper.OrderDetailsMapper;
import com.loveyj.pojo.OrderDetail;
import com.loveyj.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderDetailsServiceImpl")
public class OrderDetailsServiceImpl implements OrderDetailsService {

    @Autowired
    OrderDetailsMapper orderDetailsMapper;


    @Override
    public int insertUserOrderDetails(OrderDetail orderDetail) {

        return orderDetailsMapper.insertUserOrderDetails(orderDetail);
    }
}
