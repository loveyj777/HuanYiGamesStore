package com.loveyj.controller;

import com.loveyj.pojo.ShopCar;
import com.loveyj.pojo.User;
import com.loveyj.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author lov3YJ
 * @description 购物车
 * @date 2021/11/10 9:42
 */
@Controller
@RequestMapping("/shopCar")
public class ShopCarController {


@Autowired
ShopCarService shopCarService;

//用户Id
private  int uid;
/**
 * @param modelAndView: 
 * @param request:  
 * @return ModelAndView
 * @author lov3YJ
 * @description 初始化购物车
 * @date 2021/11/10 9:43
 */
    @RequestMapping()
    public ModelAndView shopCar(ModelAndView modelAndView, HttpServletRequest request){


        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            uid = user.getId();
            List<ShopCar> shopCarList = shopCarService.getUserShopCarByUid(uid);

            modelAndView.addObject("shopCarList", shopCarList);
        }
        else{
            modelAndView.addObject("noUser", null);
        }

            modelAndView.setViewName("shopcar");

        return modelAndView;
    }

    /**
     * @param modelAndView:
     * @param uid:
     * @param gid:
     * @param price:
     * @return String
     * @author lov3YJ
     * @description 添加至购物车
     * @date 2021/11/10 9:43
     */
    @RequestMapping("/addToShopCar")
    @ResponseBody
    public String addToShopCar(ModelAndView modelAndView,Integer uid,Integer gid,double price){


        if(shopCarService.insertShopcar(uid,gid,price)>0){
            return "ok";
        }
        else{
            return "false";
        }

    }

    /**
     * @param modelAndView:
     * @param uid:
     * @param gid:
     * @return String
     * @author lov3YJ
     * @description 判断商品是否存在
     * @date 2021/11/10 9:43
     */
    @RequestMapping("/selectShopCarIfExistByUid")
    @ResponseBody
    public String   selectShopCarIfExistByUid (ModelAndView modelAndView,Integer uid,Integer gid){


        ShopCar shopCar =shopCarService.selectShopCarIfExistByUid(uid,gid);
        if(shopCar!=null){
            return "false";
        }
        else{
            return "ok";
        }

    }


    /**
     * @param gid:  
     * @return String
     * @author lov3YJ
     * @description 删除至购物车
     * @date 2021/11/10 9:44
     */
    @RequestMapping("/deleteGameInShopCar")
    @ResponseBody
    public String   deleteGameInShopCar (Integer gid){



        if(shopCarService.deleteGameInShopCarByUidAndGid(uid,gid)>0){
            return "ok";
        }
        else{
            return "false";
        }

    }
}
