package com.loveyj.doMain;

import org.springframework.stereotype.Component;


import java.sql.Date;

@Component("coupon")
public class coupon {

    private  int id;

    private  int uid;

    private  String couponName;

    private Date beginTime;

    private Date endTime;

    private String condition;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public coupon(int id, int uid, String couponName, Date beginTime, Date endTime, String condition) {
        this.id = id;
        this.uid = uid;
        this.couponName = couponName;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.condition = condition;
    }

    public coupon() {
    }
}
