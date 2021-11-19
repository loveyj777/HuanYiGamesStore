package com.loveyj.mapper;

import com.loveyj.pojo.GamesDiscount;
import org.apache.ibatis.annotations.*;

public interface GamesDiscountMapper {



    @Select("select * from games_discount where `gid`=#{gid} ")
    GamesDiscount getGameDiscount(@Param("gid") int gid);


    @Update("UPDATE `games_discount` SET `discount` =#{discount} WHERE `gid` =#{gid} ")
    int updateGameDiscount(@Param("discount") double discount,@Param("gid") int gid);

    @Insert("insert into `games_discount`(`gid`) values(#{gid})")
    int insertNewGamesDiscount(@Param("gid") int gid);

}
