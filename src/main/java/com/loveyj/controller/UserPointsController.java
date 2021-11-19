package com.loveyj.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.loveyj.pojo.User;
import com.loveyj.pojo.UserPointsDetails;
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
 * @description 用户积分页
 * @date 2021/11/10 9:49
 */
@Controller
@RequestMapping("/user/points")
public class UserPointsController {


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

    //用户Id
    private int uid;


    /**
     * @param request:
     * @return String
     * @author lov3YJ
     * @description 加载数据
     * @date 2021/11/10 9:50
     */
    @RequestMapping()
    public String userPoints(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            uid = user.getId();
        }
        return "userPoints";
    }

    /**
     * @param :
     * @return String
     * @author lov3YJ
     * @description 用户积分
     * @date 2021/11/10 9:50
     */
    @RequestMapping(value="/returnUserPoints",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String returnUserPoints(){

        if (userPointsService.getUserPointsByUid(uid).getPoints()!=0){
            return JSON.toJSONString(userPointsService.getUserPointsByUid(uid).getPoints());
        }else{
            return "0";
        }


    }

    /**
     * @param :
     * @return String
     * @author lov3YJ
     * @description 用户积分详情
     * @date 2021/11/10 9:50
     */
    @RequestMapping(value="/returnUserPointsDetails",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String returnUserPointsDetails(){

        List<UserPointsDetails> userPointsDetails= userPointsDetailsService.getUserPointsDetailsByUid(uid,99);

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        for (UserPointsDetails u1 : userPointsDetails){

            switch (u1.getType()){
                case 0:u1.setFlag("+");
                    u1.setTypeName("签到获取积分");break;

                case 1:u1.setFlag("+");
                    u1.setTypeName("购买游戏获取积分");
                    break;

                case 2:u1.setFlag("-");
                    u1.setTypeName("积分商城消费积分");
                    break;
            }
            jsonArray.add(u1);
        }
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",userPointsDetails.size());
        jsonObject.put("data",jsonArray);


        return jsonObject.toJSONString();
    }


}
