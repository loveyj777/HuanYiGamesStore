package com.loveyj.controller;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.loveyj.pojo.Games;
import com.loveyj.service.GameDiscountService;
import com.loveyj.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lov3YJ
 * @description 游戏管理
 * @date 2021/11/10 9:19
 */
@Controller
@RequestMapping("/admin/controlGame")
public class ControlGameController {

    @Autowired
    GamesService gamesService;

    @Autowired
    GameDiscountService gameDiscountService;

    @RequestMapping()
    public  String controlGame(){


        return "houtai/controGame";
    }


    /**
     * @param gameName:
     * @param engGameName:
     * @return String
     * @author lov3YJ
     * @description 获取所有游戏返回给lay.table
     * @date 2021/11/10 9:20
     */
    @RequestMapping(value = "/getAllGames",produces = "json/html;charset=utf-8")
    @ResponseBody
    public String getAllGames(String gameName,String engGameName){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();

        String cn= "[\u4e00-\u9fa50-9]+";

        String en="[a-zA-Z0-9]+";

        Pattern patternCn = Pattern.compile(cn);
        Pattern patternEn = Pattern.compile(en);

        List<Games> gamesList;
         if (gameName!=null){
            Matcher matcherCn =patternCn.matcher(gameName);
            Matcher matcherEn =patternEn.matcher(gameName);
         if (matcherCn.find())
         {
             gamesList = gamesService.selectAllGames(gameName,null);
         }else  if (matcherEn.find())
         {
             gamesList = gamesService.selectAllGames(null,gameName);
             System.out.println("en");
         }else {
            gamesList = gamesService.selectAllGames(gameName,null);
         }

    }else {
            gamesList = gamesService.selectAllGames(null,null);
        }


        for (Games games : gamesList)
        {
            if (games.getStatus()==1){
                games.setStatusName("上架中");
            }else {
                games.setStatusName("已下架");
            }
            jsonArray.add(games);
        }


        jsonObject.put("code",0);
        jsonObject.put("msg","");
        jsonObject.put("count",gamesList.size());
        jsonObject.put("data",jsonArray);

        return jsonObject.toJSONString();
    }


    /**
     * @param id:
     * @param status:
     * @return String
     * @author lov3YJ
     * @description 改变游戏上下架状态
     * @date 2021/11/10 9:22
     */
    @RequestMapping(value = "/changeGameStatus",produces = "json/html;charset=utf-8")
    @ResponseBody
    public String downTheGame(Integer id, Integer status) {


        if (gamesService.updateStatus(id,status) > 0) {
            return "ok";
        } else {
            return "false";
        }

    }

    /**
     * @param id:
     * @param discount:
     * @return String
     * @author lov3YJ
     * @description 改变游戏折扣
     * @date 2021/11/10 9:23
     */
    @RequestMapping(value = "/changeGameDiscount",produces = "json/html;charset=utf-8")
    @ResponseBody
    public String changeGameDiscount(Integer id, double discount) {


        if (gameDiscountService.updateGameDiscount(discount,id) > 0) {

            gamesService.updateDiscountPrice(id,discount);
            return "ok";
        } else {
            return "false";
        }

    }

}
