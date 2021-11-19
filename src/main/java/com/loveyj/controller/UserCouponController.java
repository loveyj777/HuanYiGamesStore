package com.loveyj.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.loveyj.pojo.Coupon;
import com.loveyj.pojo.User;
import com.loveyj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author lov3YJ
 * @description 用户优惠卷详情
 * @date 2021/11/10 9:44
 */
@Controller
@RequestMapping("/user/coupon")
public class UserCouponController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    CouponService couponService;

    @Autowired
    UserPointsService userPointsService;

    @Autowired
    UserPointsDetailsService userPointsDetailsService;

    private int uid;


    /**
     * @param request:
     * @return String
     * @author lov3YJ
     * @description 载入数据
     * @date 2021/11/10 9:44
     */
    @RequestMapping()
    public String userCoupon(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            uid = user.getId();
            couponService.updateUserCouponIfIsOverdue(uid);
        }
        return "userCoupon";
    }

    /**
     * @param :  
     * @return String
     * @author lov3YJ
     * @description 未使用优惠卷
     * @date 2021/11/10 9:45
     */
    @RequestMapping(value="/notUseCoupon",produces = "application/json;charset=utf-8")
    @ResponseBody
    public  String notUseCoupon(){


        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject = new JSONObject();

        List<Coupon> couponList =   couponService.getNotUseCouponByUid(uid);

        return getCouponString(jsonArray, jsonObject, couponList);

    }



    /**
     * @param :  
     * @return String
     * @author lov3YJ
     * @description 已使用优惠卷
     * @date 2021/11/10 9:45
     */
    @RequestMapping(value="/usedCoupon",produces = "application/json;charset=utf-8")
    @ResponseBody
    public  String usedCoupon(){

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        List<Coupon> couponList =   couponService.getUsedCouponByUid(uid);

        return getCouponString(jsonArray, jsonObject, couponList);

    }


    /**
     * @param :  
     * @return String
     * @author lov3YJ
     * @description 已过期优惠卷
     * @date 2021/11/10 9:45
     */
    @RequestMapping(value="/overdueCoupon",produces = "application/json;charset=utf-8")
    @ResponseBody
    public  String overdueCoupon(){

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        List<Coupon> couponList =   couponService.getUserOverdueCoupon(uid);

        return getCouponString(jsonArray, jsonObject, couponList);

    }


    private String getCouponString(JSONArray jsonArray, JSONObject jsonObject, List<Coupon> couponList) {
        for ( Coupon coupon :couponList) {

            jsonArray.add(coupon);

        }
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",couponList.size());
        jsonObject.put("data",jsonArray);

        return jsonObject.toJSONString();
    }


}
