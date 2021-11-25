package com.loveyj.service;

import com.loveyj.pojo.Coupon;

import java.util.List;

public interface CouponService {



    List<Coupon> getUsedCouponByUid(int uid);

    List<Coupon> getUserOverdueCoupon(int uid);

    int updateUserCouponIfIsOverdue(int uid,int cid);

    List<Coupon> getCoupon();

    List<Coupon> getNotUseCouponByUid(int uid);

    List<Coupon> getNotUserCouponByUid(int uid);

    int addUserCoupon( int uid,int cid);

    List<Coupon> getPointsShopCoupon();

    List<Coupon> getNotUserCouponByUidPointsShop(int uid);

    Coupon getCouponByCid(int id);


    List<Coupon> getCanUseCoupon( double price, int uid);

    int addCoupon(Coupon coupon);
}
