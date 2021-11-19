package com.loveyj.pojo;

import org.springframework.stereotype.Component;


import java.sql.Date;


public class Coupon {

    private  int id;

    private  String couponName;

    private Date beginTime;

    private String endTime;

    private String condition;

    private double couponPrice;

    private double threshold;

    private int gtype;

    private  int needPoints;


    public int getNeedPoints() {
        return needPoints;
    }

    public void setNeedPoints(int needPoints) {
        this.needPoints = needPoints;
    }

    private UserCoupon userCoupon;

    public UserCoupon getUserCoupon() {
        return userCoupon;
    }


    public double getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(double couponPrice) {
        this.couponPrice = couponPrice;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public int getGtype() {
        return gtype;
    }

    public void setGtype(int gtype) {
        this.gtype = gtype;
    }

    public void setUserCoupon(UserCoupon userCoupon) {
        this.userCoupon = userCoupon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }


    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", couponName='" + couponName + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", condition='" + condition + '\'' +
                ", userCoupon=" + userCoupon +
                '}';
    }
}
