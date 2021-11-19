package com.loveyj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserCouponMapper {


    @Update("UPDATE `user_coupon` SET `user_coupon`.`status`='1',`useTime`=NOW() WHERE uid =#{uid} AND cid =#{cid} ")
        int updateCouponToUse(@Param("uid") int uid,@Param("cid") int cid);


}
