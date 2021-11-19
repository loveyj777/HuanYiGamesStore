package com.loveyj.controller;


import com.loveyj.pojo.User;
import com.loveyj.service.UserService;


import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;

import java.util.Map;
import java.util.Random;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author：Love YJ❤Ghy
 * @description: 登录
 * */
@Controller
public class LoginController {

    @Autowired
    UserService userService ;


    @RequestMapping("/login")
    public String login(){

        return "login";
    }


    /**
     * @param username:
     * @param password:
     * @param req:
     * @param resp:
     * @return String
     * @author lov3YJ
     * @description 账号&手机号 密码登录
     * @date 2021/11/10 9:41
     */
    @RequestMapping(value = "/userLogin",method =RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String userLogin(String username, String password, HttpServletRequest req, HttpServletResponse resp){

        String regex ="1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(username);
        HttpSession session = req.getSession();
        User user = new User();
        User resultUser;
        String returnVal = null;
        if(m.find()) {

            user.setPhone(username);

        }
        else{
            user.setUserName(username);

        }
        user.setPassword(password);
        resultUser = userService.getUserByUserNameOrPhone(user);
        if (resultUser != null) {
            session.setAttribute("user",resultUser);
            returnVal = "/index";
        } else {
            returnVal = "error";
        }

        return returnVal;
    }


        /**
         * @param phone:
         * @param req:
         * @return String
         * @author lov3YJ
         * @description 发送验证码
         * @date 2021/11/10 9:41
         */
    @RequestMapping(value = "/sendIdentifyingCode")
    @ResponseBody
    public  String sendIdentifyingCode(String phone,HttpServletRequest req){


        ZhenziSmsClient client = new ZhenziSmsClient("https://sms_developer.zhenzikj.com", "106804", "0620211d-b069-432d-ac97-3685b752e33f");
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("number",phone);
                params.put("templateId", "1761");
                int random= (int) (Math.random()*10000);
                String random2String = String.valueOf(random);
                String[] templateParams = new String[2];
                templateParams[0] =  random2String;
                templateParams[1] = "1分钟";
                params.put("templateParams", templateParams);
                String result = null;
                try {
                    result = client. send(params);
                } catch (Exception e) {
                    e.printStackTrace();
                }
        System.out.println(result);
        System.out.println(phone);
        System.out.println(random2String);
        return random2String;
    }


    /**
     * @param phone:
     * @param req:
     * @return String
     * @author lov3YJ
     * @description 手机号登录
     * @date 2021/11/10 9:41
     */
    @RequestMapping("/phoneLogin")
    @ResponseBody
    public  String phoneLogin(String phone,HttpServletRequest req){


        User user = new User();

        HttpSession session= req.getSession();

        user.setPhone(phone);

        User resultUser =  userService.getUserByPhone(user);



        if(resultUser==null)
        {
            String nameSuf;
            Random random = new Random();
            nameSuf=String.valueOf(random.nextInt(10000));
            String randomUserName="HYGM"+nameSuf;
            if (userService.findUserByUserNameOrPhone(randomUserName,"")==null)
            {
                user.setUserName(randomUserName);
                userService.insertUserByPhone(user);
                User  newResult =  userService.getUserByPhone(user);
                userService.insertUserPoints(newResult.getId());
                session.setAttribute("user",newResult);
            }else {
                nameSuf=String.valueOf(random.nextInt(10000));
            }

        }
        else{
            session.setAttribute("user",resultUser);
        }


        return "/index";
    }


}
