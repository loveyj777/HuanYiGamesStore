package com.loveyj.mapper;

import com.loveyj.pojo.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDetailsMapper {


    @Select("SELECT * from `order_detail` where oid=#{id}")
    OrderDetail getOrderDetailByOid(int id);

    @Insert("INSERT INTO `order_detail`(`oid`,`productName`,`productPrice`,`productImg`,`gid`) values('${oid}','${productName}','${productPrice}','${productImg}','${gid}')")
    int insertUserOrderDetails(OrderDetail orderDetail);
}
