package com.loveyj.controller;


import com.loveyj.pojo.*;
import com.loveyj.service.*;
import com.loveyj.service.impl.*;
import com.loveyj.utility.AlipayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;


/**
 * @author lov3YJ
 * @description 游戏付款界面
 * @date 2021/11/9 15:33
 */
@Controller
@RequestMapping("/buy")
public class BuyController {


    @Autowired
    GamesService gamesService;

    @Autowired
    CouponService couponService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailsService orderDetailsService;

    @Autowired
    UserCouponService userCouponService;

    @Autowired
    ShopCarService shopCarService;

    @Autowired
    UserPointsService userPointsService;

    @Autowired
    UserPointsDetailsService userPointsDetailsService;

    @Autowired
    UserGamesService userGamesService;

    //游戏id
    private  String[] id;

    //结束金额
    private  String finalPrice;

    //游戏名称
    private String[] gameName;

    //游戏主图
    private  String[] productImg;

    //用户id
    private int uid;

    //订单id
    private String oid;

    //继续支付订单id
    private String oid4continue;

    //订单Id
    private Integer[] oid4update;

    //用户名称
    private   String uName;

    //订单金额
    private Double price;

    //优惠卷Id
    private int couponId;

    /**
     * @param modelAndView:
     * @param request:
     * @return ModelAndView
     * @author lov3YJ
     * @description 跳转至付款界面
     * @date 2021/11/9 15:34
     */
    @RequestMapping()
    public ModelAndView buying(ModelAndView modelAndView, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

          uid=user.getId();
         uName = user.getUserName();

        List<Games> games= gamesService.getGamesDetailById4Buy(id);

        List<Coupon> coupons =couponService.getCanUseCoupon(this.price,uid);

        modelAndView.addObject("coupon",coupons);
        modelAndView.addObject("games",games);
        modelAndView.addObject("count",games.size());
        modelAndView.addObject("allPrice",price);
        modelAndView.setViewName("buying");

        return modelAndView;
    }

    /**
     * @param request:
     * @param price:
     * @param oid:
     * @return String
     * @author lov3YJ
     * @description 获取订单异常状态数据
     * @date 2021/11/9 15:35
     */
    @RequestMapping("/continueBuy")
    @ResponseBody
    public String continueBuy(HttpServletRequest request,Double price,String oid) {

        reset();
        oid4continue =oid;
        this.price=price;

        return "ok";
    }



    /**
     * @param request:
     * @param price:
     * @return String
     * @author lov3YJ
     * @description  获取购买订单参数
     * @date 2021/11/9 15:36
     */
    @RequestMapping("/getOrderInfo")
    @ResponseBody
        public String getOrderInfo(HttpServletRequest request,Double price){

        reset();
         if(request.getParameterValues("checked[]")!=null){
            id =request.getParameterValues("checked[]");
         }

         this.price = price;
        return "ok";
    }

    /**
     * @param request:
     * @param finalPrice:
     * @param couponID:
     * @return String
     * @author lov3YJ
     * @description 添加订单
     * @date 2021/11/9 15:37
     */
    @PostMapping("/insertOrder")
    @ResponseBody
    public String insertOrder(HttpServletRequest request,String finalPrice,Integer couponID){
       if(couponID!=null){
           couponId=couponID;
       }
        System.out.println(couponID);
      gameName  = request.getParameterValues("gameName[]");
        id = request.getParameterValues("Gid[]");
         productImg = request.getParameterValues("productImg[]");
    String[] productPrice =  request.getParameterValues("productPrice[]");

        this.finalPrice = finalPrice;
        oid4update = new Integer[gameName.length];
        if (oid4continue!=null){


            for (int i = 0; i < gameName.length; i++) {

                oid4update[i]= Integer.valueOf(oid4continue);

            }

        }else {

            for (int i = 0; i < gameName.length; i++) {

            int shopPoints = (int) (Double.parseDouble(productPrice[i])*0.2);
            orderService.insertOrderNotPay(uid,uName,shopPoints);
            OrderDetail orderDetail = new OrderDetail();
                Order order =   orderService.getOrderIDByUid(uid);
                oid4update[i]=order.getId();
                oid= String.valueOf(oid4update[i]);
                orderDetail.setOid(Integer.parseInt(oid));
            orderDetail.setGid(Integer.parseInt(id[i]));
            orderDetail.setProductImg(productImg[i]);
            orderDetail.setProductName(gameName[i]);
            orderDetail.setProductPrice(Double.parseDouble(productPrice[i]));
            orderDetailsService.insertUserOrderDetails(orderDetail);


            }
        }

        return "ok";
    }

    /**
     * @param modelAndView:
     * @param response:
     * @return ModelAndView
     * @author lov3YJ
     * @description 支付宝沙盒支付
     * @date 2021/11/9 15:38
     */
    @RequestMapping("/aliPay")
    public ModelAndView aliPay(ModelAndView modelAndView, HttpServletResponse response){
        StringBuffer sb = new StringBuffer();

        for (String s : gameName) {
            sb.append(s);

        }
        String gName = sb.toString();
        try {
            String result = AlipayUtil.pay(response, finalPrice,"游戏",gName, oid);
            modelAndView.addObject("result", result);

        } catch (Exception e) {
            e.printStackTrace();
        }

        modelAndView.setViewName("aliPay");
        return modelAndView;
    }


    /**
     * @param :
     * @return String
     * @author lov3YJ
     * @description 支付宝支付成功后重定向主页
     * @date 2021/11/9 15:38
     */
    @RequestMapping("/finishOrder")
    public String finishOrder() throws ParseException {


        for (int i = 0; i < oid4update.length; i++) {
            UserGames userGames = new UserGames();

            userGames.setGid(Integer.parseInt(id[i]));
            userGames.setgImg(productImg[i]);
            userGames.setgName(gameName[i]);
            userGames.setUid(uid);
            orderService.updateOrderIsPay(oid4update[i]);
            shopCarService.deleteGameInShopCarByUidAndGid(uid, Integer.parseInt(id[i]));
            userGamesService.addUserGame(userGames);
        }

        if (couponId!=0){
            userCouponService.updateCouponToUse(uid,couponId);
        }
        int finalPoints= (int) (Double.valueOf(finalPrice).intValue()*0.2);

        userPointsService.updatePoints4Buy(uid,finalPoints);
        userPointsDetailsService.insertDetails4Buy(uid,finalPoints);

        reset();


        return "redirect:http://www.hygame.store/index";
    }


    private void reset(){

         id=null;


        //游戏id
         String[] id=null;

        //结束金额
          String finalPrice =null;

        //游戏名称
         String[] gameName =null;

        //游戏主图
          String[] productImg=null;

        //用户id
         int uid = 0;

        //订单id
         String oid = null;

        //继续支付订单id
         String oid4continue = null;

        //订单Id
         Integer[] oid4update =null;

        //用户名称
           String uName = null;

        //订单金额
         Double price = null;

        //优惠卷Id
          couponId = 0;
    }
}
