package com.loveyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lov3YJ
 * @description 管理员登录
 * @date 2021/11/10 9:19
 */
@Controller
@RequestMapping("/admin/login")
public class AdminLoginController {



    @RequestMapping()
    public  String adminLogin(){

        return "houtai/adminLogin";
    }
}
