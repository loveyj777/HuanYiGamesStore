package com.loveyj.controller;


import com.loveyj.mapper.CouponMapper;
import com.loveyj.pojo.Coupon;
import com.loveyj.service.CouponService;
import com.loveyj.service.impl.CouponServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lov3YJ
 * @date 2021/11/9 15:29
 */
@Controller
@RequestMapping("/admin/coupon")
public class AddCouponController {

    @Autowired
    CouponService couponService;

    @RequestMapping()
    public  String coupon(){

        return "houtai/addCoupon";
    }

    /**
     * @param couponName:
     * @param endTime:
     * @param condition:
     * @param couponPrice:
     * @param threshold:
     * @param needPoints:
     * @return String
     * @author lov3YJ
     * @description 添加优惠卷
     * @date 2021/11/9 15:28
     */
    @RequestMapping("/addCoupon")
    @ResponseBody
    public String addCoupon(String couponName,String endTime,String condition,int couponPrice,int threshold,int needPoints){

        Coupon coupon = new Coupon();
        coupon.setCouponName(couponName);
        coupon.setCouponPrice(couponPrice);
        coupon.setEndTime(endTime);
        coupon.setThreshold(threshold);
        coupon.setCondition(condition);
        coupon.setNeedPoints(needPoints);
       if (couponService.addCoupon(coupon)>0){
           return "ok";
       }
        else {
            return "false";
       }
    }
}
