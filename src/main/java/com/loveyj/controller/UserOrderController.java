package com.loveyj.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.loveyj.pojo.Order;
import com.loveyj.pojo.User;
import com.loveyj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author：Love YJ❤Ghy
 * 
 * @description:用户订单页
 * */
@Controller
@RequestMapping("/user/order")
public class UserOrderController {


    @Autowired
    UserService userService ;

    @Autowired
    OrderService orderService;

    @Autowired
    CouponService couponService;

    @Autowired
    UserPointsService userPointsService;

    @Autowired
    UserPointsDetailsService userPointsDetailsService;

    private  int uid;


    private  MultipartFile multipartFile;

    /**
     * @param request:  
     * @return String
     * @author lov3YJ
     * @description 加载数据
     * @date 2021/11/10 9:47
     */
    @RequestMapping()
    public  String userInfo(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        uid = user.getId();
            return "user";
    }

    
    /**
     * @param req:  
     * @return String
     * @author lov3YJ
     * @description 用户全部订单
     * @date 2021/11/10 9:48
     */
    @RequestMapping(value = "/allOrder",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String allOrder(HttpSession req){

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        List<Order> order = orderService.getOrderByUid(uid);




        return getOrderString(jsonArray, jsonObject, order);
    }

    
    /**
     * @param :  
     * @return String
     * @author lov3YJ
     * @description 用户已完成订单
     * @date 2021/11/10 9:48
     */
    @RequestMapping(value = "/finishOrder",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String finishOrder() {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        List<Order> order = orderService.getFinishOrderByUid(uid);

        return getOrderString(jsonArray, jsonObject, order);

    }


    /**
     * @param :
     * @return String
     * @author lov3YJ
     * @description 用户未支付订单
     * @date 2021/11/10 9:48
     */
    @RequestMapping(value = "/noPayOrder",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String noPayOrder() {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        List<Order> order = orderService.getNoPayOrderByUid(uid);

           return getOrderString(jsonArray, jsonObject, order);

    }



    /**
     * @param id:
     * @return String
     * @author lov3YJ
     * @description 取消订单
     * @date 2021/11/10 9:48
     */
    @RequestMapping(value = "/cancelOrder",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String cancelOrder(Integer id){

        if( orderService.deleteUserOrderById(id)!=0){
            return "取消成功";
        }else{
            return "false";
        }
    }


    private String getOrderString(JSONArray jsonArray,JSONObject jsonObject, List<Order> order) {
        for (Order order1:order ) {

            if (order1.getStatus()==1){
                order1.setStatusName("已付款");
            }else {
                order1.setStatusName("未付款");
            }
            jsonArray.add(order1);

        }
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",order.size());
        jsonObject.put("data",jsonArray);

        return jsonObject.toJSONString();
    }

}

