package com.loveyj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lov3YJ
 * @date 2021/11/9 15:33
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping()
    public  String admin(){

        return "houtai/layadmin";
    }
}
