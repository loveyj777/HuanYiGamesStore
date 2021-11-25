package com.loveyj.controller;

import com.loveyj.pojo.Admin;
import com.loveyj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author lov3YJ
 * @date 2021/11/9 15:33
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @RequestMapping()
    public  String admin(){

        return "houtai/layadmin";
    }


    @RequestMapping("/login")
    public  String loginPanel(){

        return "houtai/adminLogin";
    }


    @PostMapping("/alogin")
    @ResponseBody
    public  String adminLogin(Admin admin, HttpServletRequest request){

        HttpSession session = request.getSession();

        Admin admin1 = adminService.findUser(admin);

        if (admin1!=null){

            session.setAttribute("admin",admin1);

            return "ok";
        }

        return "false";

    }
}
