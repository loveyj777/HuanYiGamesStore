package com.loveyj.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loveyj.pojo.Games;
import com.loveyj.pojo.User;
import com.loveyj.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lov3YJ
 * @description 游戏
 * @date 2021/11/10 9:28
 */
@Controller
@RequestMapping("/games")
public class GamesController {


    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    RollImgService rollImgService;

    @Autowired
    UserPointsService userPointsService;

    @Autowired
    UserPointsDetailsService userPointsDetailsService;

    @Autowired
    GamesService gamesService;

    @Autowired
    CouponService couponService;

    //用户id
    private  int uid;

    //游戏类型Id
    private  int typeID;

    //（int)游戏单价
    private  int priceInt;

    private int pageNum=1;

    private int pageSize=13;

    /**
     * @param modelAndView:
     * @param request:
     * @return ModelAndView
     * @author lov3YJ
     * @description 跳转商城初始页
     * @date 2021/11/10 9:30
     */
    @RequestMapping()
    public ModelAndView games(ModelAndView modelAndView, HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            uid = user.getId();
        }

        PageHelper.startPage(1,13);

        List<Games>   hotSale = gamesService.getHotSale(0,0);

        PageInfo pageInfo = new PageInfo(hotSale);


        modelAndView.addObject("hotSale", hotSale);
        modelAndView.addObject("price", priceInt/25);
        modelAndView.addObject("total", pageInfo.getTotal());
        modelAndView.addObject("curr", pageInfo.getPageNum());
        modelAndView.addObject("hotSale", hotSale);

        modelAndView.setViewName("games/games");
        return modelAndView;
    }


    /**
     * @param modelAndView:
     * @param type:
     * @param price:
     * @param pageNum:
     * @param pageSize:
     * @return ModelAndView
     * @author lov3YJ
     * @description 热销
     * @date 2021/11/10 9:35
     */
    @RequestMapping("/hotSale")
    public ModelAndView hotSale(ModelAndView modelAndView,String type,String price,Integer pageNum,Integer pageSize){

        gValue(type, price, pageNum, pageSize);

        List<Games>   hotSale = gamesService.getHotSale(typeID,priceInt);

        PageInfo pageInfo = new PageInfo(hotSale);

        modelAndView.addObject("hotSale", hotSale);
        modelAndView.addObject("price", priceInt/25);
        modelAndView.addObject("type", type);
        modelAndView.addObject("total", pageInfo.getTotal());
        modelAndView.addObject("curr", pageInfo.getPageNum());
        modelAndView.setViewName("games/hotSale");

        return modelAndView;


    }



    /**
     * @param modelAndView:
     * @param type:
     * @param price:
     * @param pageNum:
     * @param pageSize:
     * @return ModelAndView
     * @author lov3YJ
     * @description 折扣
     * @date 2021/11/10 9:35
     */
    @RequestMapping("/discount")
    public ModelAndView discount(ModelAndView modelAndView,String type,String price,Integer pageNum,Integer pageSize){


        gValue(type, price, pageNum, pageSize);

        List<Games>   gamesDiscountList = gamesService.getGamesDiscountList(typeID,priceInt);

        PageInfo pageInfo = new PageInfo(gamesDiscountList);

        modelAndView.addObject("discount", gamesDiscountList);
        modelAndView.addObject("price", priceInt/25);
        modelAndView.addObject("type", type);
        modelAndView.addObject("total", pageInfo.getTotal());
        modelAndView.addObject("curr", pageInfo.getPageNum());
        modelAndView.setViewName("games/discount");

        return modelAndView;
    }



    /**
     * @param modelAndView:
     * @param type:
     * @param price:
     * @param pageNum:
     * @param pageSize:
     * @return ModelAndView
     * @author lov3YJ
     * @description 新品
     * @date 2021/11/10 9:35
     */
    @RequestMapping("/new")
    public ModelAndView newGames (ModelAndView modelAndView,String type,String price,Integer pageNum,Integer pageSize){


        gValue(type, price, pageNum, pageSize);

        List<Games>   newGame = gamesService.getNewGame(typeID,priceInt);

        PageInfo pageInfo = new PageInfo(newGame);

        modelAndView.addObject("newG", newGame);
        modelAndView.addObject("price", priceInt/25);
        modelAndView.addObject("type", type);
        modelAndView.addObject("total", pageInfo.getTotal());
        modelAndView.addObject("curr", pageInfo.getPageNum());
        modelAndView.setViewName("games/new");

        return modelAndView;
    }


    /**
     * @param modelAndView:
     * @param type:
     * @param price:
     * @param pageNum:
     * @param pageSize:
     * @return ModelAndView
     * @author lov3YJ
     * @description 价格升序
     * @date 2021/11/10 9:35
     */
    @RequestMapping("/priceUp")
    public ModelAndView priceUp (ModelAndView modelAndView,String type,String price,Integer pageNum,Integer pageSize){


        gValue(type, price, pageNum, pageSize);

        List<Games>   priceup = gamesService.getGamePriceASC(typeID,priceInt);

        PageInfo pageInfo = new PageInfo(priceup);

        modelAndView.addObject("priceup", priceup);
        modelAndView.addObject("price", priceInt/25);
        modelAndView.addObject("type", type);
        modelAndView.addObject("total", pageInfo.getTotal());
        modelAndView.addObject("curr", pageInfo.getPageNum());
        modelAndView.setViewName("games/priceup");

        return modelAndView;
    }


    /**
     * @param modelAndView:
     * @param type:
     * @param price:
     * @param pageNum:
     * @param pageSize:
     * @return ModelAndView
     * @author lov3YJ
     * @description 价格降序
     * @date 2021/11/10 9:36
     */
    @RequestMapping("/priceDown")
    public ModelAndView priceDown (ModelAndView modelAndView,String type,String price,Integer pageNum,Integer pageSize){

        gValue(type, price, pageNum, pageSize);

        List<Games>  pricedown = gamesService.getGamePriceDESC(typeID,priceInt);

        PageInfo pageInfo = new PageInfo(pricedown);

        modelAndView.addObject("pricedown", pricedown);
        modelAndView.addObject("price", priceInt/25);
        modelAndView.addObject("type", type);
        modelAndView.addObject("total", pageInfo.getTotal());
        modelAndView.addObject("curr", pageInfo.getPageNum());
        modelAndView.setViewName("games/pricedown");

        return modelAndView;
    }


    /**
     * @param modelAndView: 
     * @param name: 
     * @param engName: 
     * @param pageNum: 
     * @param pageSize:  
     * @return ModelAndView
     * @author lov3YJ
     * @description 搜索
     * @date 2021/11/10 9:36
     */
    @RequestMapping("/search")
    public ModelAndView search (ModelAndView modelAndView,String name,String engName, Integer pageNum,Integer pageSize){



        PageHelper.startPage(pageNum,pageSize);

        List<Games>   searchGame = gamesService.getSearchGame(name,engName);

        PageInfo pageInfo = new PageInfo(searchGame);

        modelAndView.addObject("name", name);
        modelAndView.addObject("engName", engName);
        modelAndView.addObject("search", searchGame);
        modelAndView.addObject("price", priceInt/25);
        modelAndView.addObject("total", pageInfo.getTotal());
        modelAndView.addObject("curr", pageInfo.getPageNum());
        modelAndView.setViewName("search");

        return  modelAndView;
    }




    private void gValue(String type, String price, Integer pageNum, Integer pageSize) {
        typeID=0;
        priceInt=0;

        if (price!=null&&!price.equals("任意数值")){


                priceInt=Integer.parseInt(price);


        }

        if (type!=null&&!type.equals("")){


                typeID=Integer.parseInt(type);


        }

        if (pageNum!=null&&pageSize!=null){
            this.pageNum=pageNum;
            this.pageSize=pageSize;
        }

        PageHelper.startPage(this.pageNum,this.pageSize);
    }
}



