package com.loveyj.controller;

import com.loveyj.pojo.Coupon;
import com.loveyj.pojo.User;
import com.loveyj.pojo.UserPoints;
import com.loveyj.service.CouponService;
import com.loveyj.service.UserPointsDetailsService;
import com.loveyj.service.UserPointsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import java.util.List;


/**
 * @author lov3YJ
 * @description 优惠卷管理
 * @date 2021/11/10 9:23
 */
@Controller
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @Autowired
    UserPointsService userPointsService;

    @Autowired
    UserPointsDetailsService userPointsDetailsService;

    //用户ID
    private  int uid;
    
    /**
     * @param modelAndView: 
     * @param request:  
     * @return ModelAndView
     * @author lov3YJ
     * @description 跳转优惠卷管理界面
     * @date 2021/11/10 9:24
     */
    @RequestMapping()
    public ModelAndView coupon(ModelAndView modelAndView, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            uid = user.getId();
            List<Coupon>  userCoupons = couponService.getNotUserCouponByUid(uid);
            modelAndView.addObject("userCoupons", userCoupons);
        }
        List<Coupon>  coupons = couponService.getCoupon();
        modelAndView.addObject("coupons", coupons);
        modelAndView.setViewName("coupons");

        return modelAndView;
    }


    /**
     * @param uid:
     * @param cid:
     * @return String
     * @author lov3YJ
     * @description 添加优惠卷
     * @date 2021/11/10 9:25
     */
    @RequestMapping("/addCoupon")
    @ResponseBody
    public String addCoupon(Integer uid, Integer cid) {

        UserPoints userPoints = userPointsService.getUserPointsByUid(uid);
        Coupon coupon = couponService.getCouponByCid(cid);
        if (coupon.getNeedPoints()==0)
        {
            couponService.addUserCoupon(uid, cid) ;

            return "ok";
        }
       else if (coupon.getNeedPoints()!=0&&userPoints.getPoints()>=coupon.getNeedPoints())
        {
            couponService.addUserCoupon(uid, cid) ;
           userPointsService.updatePoints4pointsShop(uid,coupon.getNeedPoints());
           userPointsDetailsService.insertDetails4PointsShop(uid,coupon.getNeedPoints());
            return "ok";
        }
        else {
        return "false";
        }

    }


}
