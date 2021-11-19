package com.loveyj.mapper;

import com.loveyj.pojo.Order;
import com.loveyj.pojo.OrderDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {


        @Select("SELECT * FROM `order` WHERE uid =#{uid}")
        @Results({
                @Result(column = "id",property = "id",id = true),
                @Result(column = "uid",property = "uid"),
                @Result(column = "uname",property = "uname"),
                @Result(column = "orderPoints",property = "orderPoints"),
                @Result(column = "status",property = "status"),
                @Result(column = "createTime",property = "createTime"),
                @Result(column = "payTime",property = "payTime"),
                @Result(property = "orderDetail",column = "id",
                        javaType = OrderDetail.class,
                        one = @One(select = "com.loveyj.mapper.OrderDetailsMapper.getOrderDetailByOid")
                )
        })
        List<Order> getOrderByUid(@Param("uid") int uid);


        @Select("SELECT * FROM `order` WHERE uid =#{uid} and status=1")
        @Results({
                @Result(column = "id",property = "id",id = true),
                @Result(column = "uid",property = "uid"),
                @Result(column = "uname",property = "uname"),
                @Result(column = "orderPoints",property = "orderPoints"),
                @Result(column = "status",property = "status"),
                @Result(column = "createTime",property = "createTime"),
                @Result(column = "payTime",property = "payTime"),
                @Result(property = "orderDetail",column = "id",
                        javaType = OrderDetail.class,
                        one = @One(select = "com.loveyj.mapper.OrderDetailsMapper.getOrderDetailByOid")
                )
        })
        List<Order> getFinishOrderByUid(@Param("uid") int uid);


        @Select("SELECT * FROM `order` WHERE uid =#{uid} and status=0")
        @Results({
                @Result(column = "id",property = "id",id = true),
                @Result(column = "uid",property = "uid"),
                @Result(column = "uname",property = "uname"),
                @Result(column = "orderPoints",property = "orderPoints"),
                @Result(column = "status",property = "status"),
                @Result(column = "createTime",property = "createTime"),
                @Result(column = "payTime",property = "payTime"),
                @Result(property = "orderDetail",column = "id",
                        javaType = OrderDetail.class,
                        one = @One(select = "com.loveyj.mapper.OrderDetailsMapper.getOrderDetailByOid")
                )
        })
        List<Order> getNoPayOrderByUid(@Param("uid") int uid);

        @Delete("DELETE `order`.*,order_detail.* FROM `order`,order_detail WHERE `order`.`id`= order_detail.`oid` AND `order`.id=#{id} ")
        int  deleteUserOrderById(@Param("id") int id);


        @Insert("<script> " +
                "" +
                "INSERT INTO `order`(uid,uName,`orderPoints`,`status`) " +
                "" +
                "VALUES" +
                "(#{uid},#{uName},#{orderPoints},'0')" +

                "" +
                "</script>")
        int insertOrderNotPay(@Param("uid") int uid,@Param("uName") String uName,@Param("orderPoints") int orderPoints);


        @Update(" UPDATE `order` SET `status` ='1' ,`payTime` =NOW()   WHERE id =#{id}   ")
        int updateOrderIsPay( @Param("id") int id);

        @Select("SELECT * FROM `order` WHERE `uid` =#{uid} ORDER BY `id` DESC limit 0,1")
        Order getOrderIDByUid(@Param("uid") int uid);
}
