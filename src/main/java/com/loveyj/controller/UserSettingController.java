package com.loveyj.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.loveyj.pojo.User;
import com.loveyj.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;


/**
 * @author lov3YJ
 * @description 用户信息设置页
 * @date 2021/11/10 9:52
 */
@Controller
@RequestMapping("/user/setting")
public class UserSettingController {


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

    //用户id
    private int uid;

    //用户图片上传接口
    private  MultipartFile multipartFile;

    @RequestMapping()
    public String userSetting(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
            uid = user.getId();
        return "userSetting";
    }



    /**
     * @param :  
     * @return String
     * @author lov3YJ
     * @description 读取用户信息
     * @date 2021/11/10 9:53
     */
    @RequestMapping(value="/userInfoById",produces = "application/json;charset=utf-8")
    @ResponseBody
    public  String getUserInfoById(){
        User user=  userService.getUserById(uid);


        return JSON.toJSONString(userService.getUserById(uid));
    }


    /**
     * @param introduce: 
     * @param username: 
     * @param request:  
     * @return String
     * @author lov3YJ
     * @description 更新用户信息
     * @date 2021/11/10 9:53
     */
    @RequestMapping(value="/updateUserInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public  String updateUserInfo(String introduce,String username,HttpServletRequest request) throws IOException {
        JSONObject jsonObject = new JSONObject();
        User user = new User();
        String fileName = null;
        HttpSession session = request.getSession();
     User user1 = (User) session.getAttribute("user");
        MultipartFile file =  multipartFile;
        if (file==null){
            user.setHeadImg(user1.getHeadImg());
            user.setIntroduce(introduce);
            user.setUserName(username);
            user.setId(uid);
        }else{
            fileName= file.getOriginalFilename();
            user.setHeadImg(fileName);
            user.setIntroduce(introduce);
            user.setUserName(username);
            user.setId(uid);


                file.transferTo(new File("/usr/local/tomcat/apache-tomcat-8.5.73/webapps/HuanYiGamesStore/img/userHeadImg/"+ fileName));


        }

        if ( userService.updateUserById(user)!=0)
        {
            session.removeAttribute("user");

            User user2 =  userService.getUserById(uid);
            session.setAttribute("user",user2);

            return "/userInfo/"+uid;
        }else
        {
            return  "false";
        }
    }


    
    /**
     * @param fileUp:  
     * @return String
     * @author lov3YJ
     * @description 获取用户头像流
     * @date 2021/11/10 9:54
     */
    @RequestMapping(value="/getHeadImgFile",method = RequestMethod.POST)
    @ResponseBody
    public  String getImg(@RequestParam("fileUp") MultipartFile fileUp) throws IOException {

        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();
        multipartFile=fileUp;
        fileUp.getInputStream();

        jsonObject1.put("src",fileUp.getOriginalFilename());
        jsonObject.put("msg","");
        jsonObject.put("code",0);
        jsonObject.put("data",jsonObject1);


        return jsonObject.toJSONString();
    }

    
    /**
     * @param uPhone:  
     * @return String
     * @author lov3YJ
     * @description 更新用户电话号
     * @date 2021/11/10 9:54
     */
    @RequestMapping(value = "/updatePhone",method = RequestMethod.POST)
    @ResponseBody
    public  String updatePhone(@RequestParam("phone") String uPhone){

        User user = new User();

        user.setPhone(uPhone);
        user.setId(uid);
        if (userService.updateUserPhoneById(user)!=0){
            return "ok";
        }else {
            return "false";
        }
    }


    /**
     * @param userName:
     * @param phone:
     * @return String
     * @author lov3YJ
     * @description 检查用户名称or电话号是否存在
     * @date 2021/11/10 9:55
     */
    @RequestMapping(value = "/checkUserNameAndPhone",method = RequestMethod.POST,produces = "application/json;charset=utf-8" )
    @ResponseBody
    public String checkUserNameAndPhone(@RequestParam("userName") String userName,@RequestParam("phone") String phone){

        User user = userService.findUserByUserNameOrPhone(userName,phone);

        if (user==null){
            return "ok";
        }
        else {
            return "false";
        }
    }

    
    /**
     * @param pwd:
     * @param req:
     * @return String
     * @author lov3YJ
     * @description 更改密码
     * @date 2021/11/10 9:55
     */
    @RequestMapping(value = "/updatePwd",method = RequestMethod.POST,produces = "application/json;charset=utf-8" )
    @ResponseBody
    public String updatePwd(String pwd,HttpServletRequest req){

        if (userService.updateUserPasswordById(pwd,uid)!=0){
            HttpSession session = req.getSession();
            session.removeAttribute("user");
            return "ok";
        }else {
            return "false";
        }
    }


    /**
     * @param request:  
     * @return String
     * @author lov3YJ
     * @description 更换头像后更新用户session
     * @date 2021/11/10 9:55
     */
    @RequestMapping(value = "/returnSession",method = RequestMethod.POST,produces = "application/json;charset=utf-8" )
    @ResponseBody
    public String returnSession(HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        return JSON.toJSONString(user.getHeadImg());

    }


}
