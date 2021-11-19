package com.loveyj.service.impl;

import com.loveyj.mapper.CouponMapper;
import com.loveyj.pojo.Coupon;
import com.loveyj.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("CouponService")
public class CouponServiceImpl implements CouponService {

    @Autowired
    CouponMapper couponMapper;

    @Override
    public List<Coupon> getNotUseCouponByUid(int uid) {
        return couponMapper.getNotUseCouponByUid(uid);
    }

    @Override
    public List<Coupon> getUsedCouponByUid(int uid) {

        return couponMapper.getUsedCouponByUid(uid);
    }

    @Override
    public List<Coupon> getUserOverdueCoupon(int uid) {
        return couponMapper.getUserOverdueCoupon(uid);
    }

    @Override
    public int updateUserCouponIfIsOverdue(int uid) {
        return couponMapper.updateUserCouponIfIsOverdue(uid);
    }

    @Override
    public List<Coupon> getCoupon() {

        return couponMapper.getCoupon();
    }

    @Override
    public List<Coupon> getNotUserCouponByUid(int uid) {
        return couponMapper.getNotUserCouponByUid(uid);
    }

    @Override
    public int addUserCoupon(int uid, int cid) {
        return couponMapper.addUserCoupon(uid,cid);
    }


    @Override
    public List<Coupon> getPointsShopCoupon() {
        return couponMapper.getPointsShopCoupon();
    }

    @Override
    public List<Coupon> getNotUserCouponByUidPointsShop(int uid) {
        return couponMapper.getNotUserCouponByUidPointsShop(uid);
    }

    @Override
    public Coupon getCouponByCid(int id) {
        return couponMapper.getCouponByCid(id);
    }

    @Override
    public List<Coupon> getCanUseCoupon(double price, int uid) {
        return couponMapper.getCanUseCoupon(price,uid);
    }

    @Override
    public int addCoupon(Coupon coupon) {
        return couponMapper.addCoupon(coupon);
    }
}
