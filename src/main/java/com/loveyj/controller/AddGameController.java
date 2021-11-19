package com.loveyj.controller;

import com.alibaba.fastjson.JSONObject;
import com.loveyj.pojo.Games;
import com.loveyj.pojo.GamesImg;
import com.loveyj.service.GameDiscountService;
import com.loveyj.service.GamesImgService;
import com.loveyj.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @author lov3YJ
 * @date 2021/11/9 15:30
 *
 */
@Controller
@RequestMapping("/admin/addGame")
public class AddGameController {

    @Autowired
    GamesService gamesService;

    @Autowired
    GamesImgService gamesImgService;

    @Autowired
    GameDiscountService gameDiscountService;

    private MultipartFile mst;

    /**
     * @return String
     * @author lov3YJ
     * @description 跳转游戏添加页面
     * @date 2021/11/9 15:30
     */
    @RequestMapping()
    public  String addGame(){

        return "houtai/addGame";
    }


    /**
     * @param gameName:
     * @param engGameName:
     * @param price:
     * @param publishTime:
     * @param type:
     * @param gameInfo:
     * @return String
     * @author lov3YJ
     * @description 添加游戏基本信息
     * @date 2021/11/9 15:30
     */
    @RequestMapping("/insertGame")
    @ResponseBody
    public  String insertGame(String gameName, String engGameName, String price, String publishTime, String type, String gameInfo) throws IOException {


        Games games = new Games();
        games.setDescript(gameInfo);
        games.setEngGameName(engGameName);
        games.setGameName(gameName);
        games.setType(Integer.parseInt(type));
        games.setPublishTime(publishTime);
        games.setPrice(Double.parseDouble(price));
        gamesService.insertGame(games);
        Games games1 =gamesService.getNewGameId();
        int id = games1.getId();
        GamesImg gamesImg = new GamesImg();
        gamesImg.setImgUrl(mst.getOriginalFilename());
        gamesImg.setId(id);
        gamesImg.setIsMaster(1);
        gamesImgService.InsertGamesImg(gamesImg);
        gameDiscountService.insertNewGamesDiscount(id);
        mst.transferTo(new File("C:\\HuanYiGamesStore\\src\\main\\webapp\\img\\gamesImg\\"+mst.getOriginalFilename()));


        return String.valueOf(id);

    }

    /**
     * @param masterImg:
     * @return String
     * @author lov3YJ
     * @description 获取MasterImg
     * @date 2021/11/9 15:31
     */
    @RequestMapping("/mstImgFile")
    @ResponseBody
    public String mstImgFile(MultipartFile masterImg) throws IOException {
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject = new JSONObject();

            mst=masterImg;

        jsonObject1.put("src",masterImg.getOriginalFilename());
        jsonObject.put("msg","");
        jsonObject.put("code",0);
        jsonObject.put("data",jsonObject1);


        return jsonObject.toJSONString();

    }



    /**
     * @param detailImg:
     * @param id:
     * @return String
     * @author lov3YJ
     * @description 循环添加游戏详情图片
     * @date 2021/11/9 15:32
     */
    @RequestMapping("/dilImgFile")
    @ResponseBody
    public String dilImgFile(MultipartFile detailImg,int id) throws IOException {
        JSONObject jsonObject1 = new JSONObject();
        JSONObject jsonObject = new JSONObject();



        GamesImg gamesImg = new GamesImg();
        gamesImg.setImgUrl(detailImg.getOriginalFilename());
        gamesImg.setId(id);
        gamesImg.setIsMaster(0);
        gamesImgService.InsertGamesImg(gamesImg);
        detailImg.transferTo(new File("C:\\HuanYiGamesStore\\src\\main\\webapp\\img\\gamesImg\\"+detailImg.getOriginalFilename()));
        jsonObject1.put("src",detailImg.getOriginalFilename());
        jsonObject.put("msg","");
        jsonObject.put("code",0);
        jsonObject.put("data",jsonObject1);
        

        return jsonObject.toJSONString();

    }
}
