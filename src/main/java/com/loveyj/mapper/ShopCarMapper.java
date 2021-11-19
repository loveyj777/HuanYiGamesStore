package com.loveyj.mapper;

import com.loveyj.pojo.ShopCar;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShopCarMapper {


    @Insert("INSERT INTO `shop_car`(uid,gid,price) VALUES(#{uid},#{gid},#{price})")
    int insertShopcar(@Param("uid") int uid,@Param("gid") int gid, @Param("price") double price);



    @Select("SELECT * FROM shop_car WHERE uid=#{uid} AND gid =#{gid} ")
    ShopCar selectShopCarIfExistByUid(@Param("uid") int uid,@Param("gid") int gid);

    @Select("\n" +
            "SELECT *,`games`.id as gid,`games_img`.id as imgid FROM `shop_car`,`games`,`games_img` WHERE `shop_car`.`gid`=`games`.`id` AND `shop_car`.`gid` =`games_img`.`id` AND `games`.`id`=`games_img`.`id`\n" +
            "\n" +
            "AND `shop_car`.`uid`=#{uid}\n" +
            " AND `games_img`.`isMaster`='1'")
    @Results({
            @Result(property ="games.id" ,column = "gid" ,id = true),
            @Result(property ="games.gameName" ,column = "gameName" ),
            @Result(property ="games.status" ,column = "status" ),
            @Result(property ="games.price" ,column = "price" ),
            @Result(property ="games.descript" ,column = "descript" ),
            @Result(property ="games.type" ,column = "type" ),
            @Result(property ="games.discountPrice" ,column = "discountPrice" ),
            @Result(property ="games.publishTime" ,column = "publishTime" ),
            @Result(property ="games.engGameName" ,column = "engGameName" ),
            @Result(property ="games.gamesImg.id" ,column = "imgid" ),
            @Result(property ="games.gamesImg.imgUrl" ,column = "imgUrl" ),
            @Result(property ="games.gamesImg.isMaster" ,column = "isMaster" ),
    })
    List<ShopCar> getUserShopCarByUid(@Param("uid") int uid);


    @Delete("DELETE from `shop_car` WHERE `shop_car`.`uid`=#{uid}  AND `shop_car`.`gid` =#{gid} ")
    int deleteGameInShopCarByUidAndGid(@Param("uid") int uid,@Param("gid") int gid);
}
