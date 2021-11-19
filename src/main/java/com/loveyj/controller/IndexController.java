package com.loveyj.controller;

import com.alibaba.fastjson.JSONObject;
import com.loveyj.pojo.*;
import com.loveyj.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @author：Love YJ❤Ghy
 * @description ：主页
 *
 * */
@Controller
@RequestMapping("/index")
public class IndexController {


    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    RollImgService rollImgService;

    @Autowired
    UserPointsService userPointsService;

    @Autowired
    UserPointsDetailsService userPointsDetailsService;

    @Autowired
    GamesService gamesService;

    @Autowired
    CouponService couponService;

    //用户Id
    private int uid;

    /**
     * @param modelAndView:
     * @param request:
     * @return ModelAndView
     * @author lov3YJ
     * @description 初始化主页
     * @date 2021/11/10 9:38
     */
    @RequestMapping()
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            uid = user.getId();
            List<Coupon>  userCoupons = couponService.getNotUserCouponByUid(uid);
            System.out.println(userCoupons);
            modelAndView.addObject("userCoupons", userCoupons);
        }
        List<RollImg> rollImg = rollImgService.getAllRollImg();
        List<Games>   games =  gamesService.getGamesDiscountList(0,0);
        List<Games>   games2 =  gamesService.getNewGame(0,0);
        List<Coupon>  coupons = couponService.getCoupon();
        List<Games>   game4 = gamesService.getHotSale(0,0);


        modelAndView.addObject("rollImg", rollImg);
        modelAndView.addObject("discountGame", games);
        modelAndView.addObject("newGames", games2);
        modelAndView.addObject("coupons", coupons);
        modelAndView.addObject("hotSale", game4);



        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("quit")
    public String quit(HttpServletRequest request){

        HttpSession session =  request.getSession();
        session.removeAttribute("user");
        return "redirect:/index";
    }


    /**
     * @param :
     * @return String
     * @author lov3YJ
     * @description 签到积分
     * @date 2021/11/10 9:38
     */
    @RequestMapping(value = "/signInPoints", produces = "application/json")
    @ResponseBody
    public String signInPoints() throws ParseException {
        List<UserPointsDetails> details = userPointsDetailsService.getUserPointsDetailsByUid(uid,0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date date = new Date();

        Date nowTime =simpleDateFormat.parse(simpleDateFormat.format(date));

        Date time = null;

        if (details.size()==0){
            userPointsService.updatePoints4SignIn(uid);
            userPointsDetailsService.insertDetails4SignIN(uid);
            return "ok";
        }else {

            for (UserPointsDetails details1 : details) {

                time =simpleDateFormat.parse(details1.getTime()) ;

            }
//
//            System.out.println(time);
//            System.out.println(nowTime);
//            System.out.println(nowTime.compareTo(time));
            if (nowTime.compareTo(time) == 1) {
                userPointsService.updatePoints4SignIn(uid);
                userPointsDetailsService.insertDetails4SignIN(uid);
                return "ok";
            } else {
                return "false";
            }
        }



    }



    /**
     * @param request:
     * @return String
     * @author lov3YJ
     * @description 获取用户积分和订单数
     * @date 2021/11/10 9:39
     */
    @RequestMapping(value = "/getPointsAndOrders", produces = "application/json")
    @ResponseBody
    public String getPointsAndOrders(HttpServletRequest request) {

        HttpSession session = request.getSession();
        JSONObject jsonObject = new JSONObject();

        if (session.getAttribute("user") != null) {

            UserPoints userPoints = userPointsService.getUserPointsByUid(uid);
            List<Order> orders = orderService.getOrderByUid(uid);
            jsonObject.put("points", userPoints.getPoints());
            jsonObject.put("orders", orders.size());


            return jsonObject.toJSONString();
        } else {
            return "false";

        }
    }


}



