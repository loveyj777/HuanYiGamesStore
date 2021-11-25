package com.loveyj.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.loveyj.pojo.User;
import com.loveyj.pojo.UserGames;
import com.loveyj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @return null
 * @author lov3YJ
 * @description 用户游戏页
 * @date 2021/11/10 9:46
 */
@Controller
@RequestMapping("/user/games")
public class UserGamesController {

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

    @Autowired
    UserGamesService userGamesService;

    //用户ID
    private int uid;


    /**
     * @param request:  
     * @return String
     * @author lov3YJ
     * @description 加载数据
     * @date 2021/11/10 9:46
     */
    @RequestMapping()
    public String userGames(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
            uid = user.getId();
        return "userGame";
    }

    /**
     * @param :
     * @return String
     * @author lov3YJ
     * @description 用户拥有的游戏
     * @date 2021/11/10 9:47
     */
    @RequestMapping(value = "/uGames",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String uGames() {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        List<UserGames> userGames = userGamesService.getUerGamesByUid(uid);

        for (UserGames userGames1:userGames ) {

            jsonArray.add(userGames1);

        }
        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",userGames.size());
        jsonObject.put("data",jsonArray);
        return jsonObject.toJSONString();

    }


}
