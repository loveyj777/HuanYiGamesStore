package com.loveyj.controller;

import com.loveyj.pojo.Coupon;
import com.loveyj.pojo.User;
import com.loveyj.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author lov3YJ
 * @description 积分商城
 * @date 2021/11/10 9:42
 */
@Controller
@RequestMapping("/pointsShop")
public class PointsShopController {


@Autowired
CouponService couponService;


    private  int uid;

    @RequestMapping()
    public ModelAndView pointsShop(ModelAndView modelAndView, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            uid = user.getId();
            List<Coupon>  userCoupons = couponService.getNotUserCouponByUidPointsShop(uid);
            modelAndView.addObject("notUserCoupons", userCoupons);
        }

        List<Coupon> coupons = couponService.getPointsShopCoupon();

        modelAndView.addObject("coupons",coupons);
        modelAndView.setViewName("pointsShop");

        return modelAndView;
    }
}
