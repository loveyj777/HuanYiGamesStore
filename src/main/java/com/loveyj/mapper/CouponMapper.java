package com.loveyj.mapper;

import com.loveyj.pojo.Coupon;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CouponMapper {


    @Select("SELECT *,user_coupon.`id` ucid FROM user_coupon ,coupon WHERE cid=coupon.`id` AND uid=#{uid}  and status='0' and `isOverdue`='0' ")
    List<Coupon> getNotUseCouponByUid(int uid);



    @Select("SELECT *,user_coupon.`id` ucid FROM user_coupon ,coupon WHERE cid=coupon.`id` AND uid=#{uid} and status='1' ")
    List<Coupon> getUsedCouponByUid(int uid);




    @Select("SELECT *,user_coupon.`id` ucid FROM user_coupon ,coupon WHERE cid=coupon.`id` AND uid=#{uid} AND user_coupon.`isOverdue`='1' and user_coupon.`status`='0' ")
    List<Coupon> getUserOverdueCoupon(int uid);



    @Update("UPDATE user_coupon,coupon SET user_coupon.`isOverdue`='1' WHERE NOW()>coupon.`endTime` AND user_coupon.`uid`=#{uid} and `status` !='1' ")
    int updateUserCouponIfIsOverdue(int uid);



    @Select("SELECT * FROM coupon where needPoints = '0'")
    List<Coupon> getCoupon();



    @Select(" SELECT * FROM coupon WHERE id NOT IN (SELECT coupon.`id` FROM user_coupon,coupon WHERE user_coupon.`cid` = coupon.`id` AND uid =#{uid} and needPoints ='0' )  AND needPoints ='0'")
    List<Coupon> getNotUserCouponByUid(@Param("uid") int uid);



    @Insert("INSERT INTO user_coupon(uid,cid)  VALUES(#{uid},#{cid})")
    int addUserCoupon(@Param("uid") int uid,@Param("cid") int cid);



    @Select("SELECT * FROM coupon where needPoints != '0'")
    List<Coupon> getPointsShopCoupon();



    @Select("SELECT * FROM coupon WHERE id NOT IN (SELECT coupon.`id` FROM user_coupon,coupon WHERE user_coupon.`cid` = coupon.`id` AND uid =#{uid} AND needPoints !='0' ) AND needPoints !='0' ")
    List<Coupon> getNotUserCouponByUidPointsShop(@Param("uid") int uid);



    @Select("SELECT * FROM coupon where id=#{id}")
    Coupon getCouponByCid(@Param("id") int id);



    @Select(" SELECT *,`coupon`.`id` as a,`user_coupon`.`id` as b  FROM `user_coupon`,`coupon` WHERE  `user_coupon`.`cid`=`coupon`.`id` And `user_coupon`.uid =#{uid} AND threshold BETWEEN '0' AND #{price} AND `user_coupon`.`isOverdue` !='1' AND `user_coupon`.`status` !='1'")
    List<Coupon> getCanUseCoupon(@Param("price") double price,@Param("uid") int uid);


    @Insert("insert into coupon(`couponName`,`endTime`,`condition`,`couponPrice`,`threshold`,`needPoints`) values('${couponName}','${endTime}','${condition}','${couponPrice}','${threshold}','${needPoints}')")
    int addCoupon(Coupon coupon);
}
