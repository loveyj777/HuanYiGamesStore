package com.loveyj.service;

import com.loveyj.pojo.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderService {

    List<Order> getOrderByUid(int uid);

    List<Order> getFinishOrderByUid(int uid);

    List<Order> getNoPayOrderByUid(int uid);


    int  deleteUserOrderById(int id);

    int insertOrderNotPay(int uid,String uName,int orderPoints);


    int updateOrderIsPay( int id);

    Order getOrderIDByUid(int uid);

}
