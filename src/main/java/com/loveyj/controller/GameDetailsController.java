package com.loveyj.controller;


import com.loveyj.pojo.Games;
import com.loveyj.pojo.User;
import com.loveyj.pojo.UserGames;
import com.loveyj.service.GamesService;
import com.loveyj.service.UserGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author lov3YJ
 * @description 游戏详情
 * @date 2021/11/10 9:26
 */
@Controller
@RequestMapping("/gameDetails")
public class GameDetailsController {


    @Autowired
    GamesService gamesService;

    @Autowired
    UserGamesService userGamesService;

    //用户id
    private int uid;

    @RequestMapping("/{id}")
    public ModelAndView gameDetails(ModelAndView modelAndView, HttpServletRequest request, @PathVariable("id") Integer id){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            uid = user.getId();
        UserGames userGames= userGamesService.getUerGamesByGid(id,uid);
            modelAndView.addObject("userGames",userGames);
        }


        Games gamesList = gamesService.getGamesDetailById(id);


        List<Games> imgs = gamesService.getGamesDetailsImgs(id);

        modelAndView.addObject("game",gamesList);
        modelAndView.addObject("imgs",imgs);
        System.out.println(imgs);
        modelAndView.setViewName("gameDetails");
        return  modelAndView;
    }
}
