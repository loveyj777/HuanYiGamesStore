package com.loveyj.mapper;

import com.loveyj.pojo.Games;
import com.loveyj.pojo.GamesDiscount;
import com.loveyj.pojo.GamesImg;
import com.loveyj.pojo.GamesType;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface GamesMapper {


    @Select("" +
            "<script>" +
            "SELECT games.`id`,`gameName`,`price`,`discount`,`publishTime`,`discountPrice`,`engGameName`,`type` FROM games,games_discount WHERE STATUS='1' AND games.`id`=games_discount.`gid` AND `games_discount`.`discount` != 'null'" +
            "" +
            "<if test='type!=0'>and `games`.`type` = #{type}</if>" +
            "<if test='discountPrice!=0'>and `games`.`discountPrice` BETWEEN '0' AND #{discountPrice} </if>" +
            "" +
            " order by discount " +

            "</script>")
    @Results({
            @Result(id = true ,property = "id",column = "id"),
            @Result(property = "gameName",column = "gameName"),
            @Result(property = "price",column = "price"),
            @Result(property = "engGameName",column = "engGameName"),
            @Result(property = "publishTime",column = "publishTime"),
            @Result(property = "type",column = "type"),
            @Result(property = "discountPrice",column = "discountPrice"),
            @Result(property = "gamesDiscount.discount",column = "discount"),
            @Result(property = "gamesImg", column ="id",javaType = GamesImg.class, one =@One(select = "com.loveyj.mapper.GamesImgMapper.getGamesImgByGidAndIsMaster") ),
            @Result(property = "gamesType",column = "type",javaType = GamesType.class,
                    one = @One(select = "com.loveyj.mapper.GameTypeMapper.getGameTypeByTypeID")
            ),
            @Result(property = "gamesImgs",column = "id",javaType = List.class,
                    many = @Many(select = "com.loveyj.mapper.GamesImgMapper.getGamesImgByGid")),
    })
    List<Games> getGamesDiscountList(@Param("type") int type,@Param("discountPrice") int discountPrice);


    @Select("<script>" +
            "" +
            "SELECT games.`id`,`gameName`,`price`,`discount`,`publishTime`,`discountPrice`,`engGameName`,`type` FROM games,games_discount WHERE STATUS='1' AND games.`id`=games_discount.`gid` " +
            "" +
            "<if test='type!=0'>and `games`.`type` = #{type}</if>" +
            "<if test='discountPrice!=0'>and `games`.`discountPrice` BETWEEN '0' AND #{discountPrice} </if>" +
            "" +
            "order by publishTime desc " +

            "</script> ")
    @Results({
            @Result(id = true ,property = "id",column = "id"),
            @Result(property = "gameName",column = "gameName"),
            @Result(property = "price",column = "price"),
            @Result(property = "engGameName",column = "engGameName"),
            @Result(property = "publishTime",column = "publishTime"),
            @Result(property = "type",column = "type"),
            @Result(property = "discountPrice",column = "discountPrice"),
            @Result(property = "gamesDiscount.discount",column = "discount"),
            @Result(property = "gamesImg", column ="id",javaType = GamesImg.class, one =@One(select = "com.loveyj.mapper.GamesImgMapper.getGamesImgByGidAndIsMaster") ),
            @Result(property = "gamesType",column = "type",javaType = GamesType.class,
                    one = @One(select = "com.loveyj.mapper.GameTypeMapper.getGameTypeByTypeID")
            ),
            @Result(property = "gamesImgs",column = "id",javaType = List.class,
            many = @Many(select = "com.loveyj.mapper.GamesImgMapper.getGamesImgByGid")
    ),
    })
    List<Games> getNewGame(@Param("type") int type,@Param("discountPrice") int discountPrice);

    @Select("SELECT *,COUNT(gid) AS a,`games`.id  AS gamesid,`order_detail`.`id` AS orderdetailId FROM `games`,`order_detail` WHERE STATUS='1' and  `games`.`id` = `order_detail`.`gid` GROUP BY gid ORDER BY a DESC ")
    @Results({
            @Result(id = true ,property = "id",column = "gamesid"),
            @Result(property = "gameName",column = "gameName"),
            @Result(property = "descript",column = "descript"),
            @Result(property = "price",column = "price"),
            @Result(property = "type",column = "type"),
            @Result(property = "engGameName",column = "engGameName"),
            @Result(property = "publishTime",column = "publishTime"),
            @Result(property = "discountPrice",column = "discountPrice"),
            @Result(property = "orderDetail.id",column = "orderdetailId",id = true),
            @Result(property = "orderDetail.oid",column = "oid"),
            @Result(property = "orderDetail.gid",column = "gid"),
            @Result(property = "orderDetail.productName",column = "productName"),
            @Result(property = "orderDetail.productPrice",column = "productPrice"),
            @Result(property = "orderDetail.productImg",column = "productImg"),
    })
    List<Games> getHotSaleByOrder();

    @Select("<script>" +
            "SELECT `gameName`,`status`,`price`,`descript`,`type`,`discountPrice`,`publishTime`,`engGameName`,`productName`,`productImg`, COUNT(gid) AS a, `games`.id AS gamesid, `order_detail`.`id` AS orderdetailId FROM `games`, `order_detail` WHERE STATUS='1' and `games`.`id` = `order_detail`.`gid` " +
            "" +
            "<if test='type!=0'>and `games`.`type` = #{type}</if>" +
            "<if test='discountPrice!=0'>and `games`.`discountPrice` BETWEEN '0' AND #{discountPrice} </if>" +
            "GROUP BY gid " +
            "ORDER BY a DESC " +
            "</script>")
    @Results({
            @Result(id = true ,property = "id",column = "gamesid"),
            @Result(property = "gameName",column = "gameName"),
            @Result(property = "descript",column = "descript"),
            @Result(property = "price",column = "price"),
            @Result(property = "type",column = "type"),
            @Result(property = "engGameName",column = "engGameName"),
            @Result(property = "publishTime",column = "publishTime"),
            @Result(property = "discountPrice",column = "discountPrice"),
            @Result(property = "orderDetail.id",column = "orderdetailId",id = true),
            @Result(property = "orderDetail.oid",column = "oid"),
            @Result(property = "orderDetail.gid",column = "gid"),
            @Result(property = "orderDetail.productName",column = "productName"),
            @Result(property = "orderDetail.productPrice",column = "productPrice"),
            @Result(property = "orderDetail.productImg",column = "productImg"),
            @Result(property = "gamesType",column = "type",javaType = GamesType.class,
            one = @One(select = "com.loveyj.mapper.GameTypeMapper.getGameTypeByTypeID")
            ),
            @Result(property = "gamesDiscount",column = "gamesid",javaType = GamesDiscount.class,
                    one = @One(select = "com.loveyj.mapper.GamesDiscountMapper.getGameDiscount")
            ),
            @Result(property = "gamesImgs",column = "gamesid",javaType = List.class,
                    many = @Many(select = "com.loveyj.mapper.GamesImgMapper.getGamesImgByGid")
            ),
    })
    List<Games> getHotSale(@Param("type") int type,@Param("discountPrice") int discountPrice);



    @Insert("INSERT INTO `games`(`gameName`,`price`,`descript`,`type`,`publishTime`,`engGameName`) VALUES (#{gameName},#{price},#{descript},#{type},#{publishTime},#{engGameName} )" )
    int insertGame(Games games);

    @Select("SELECT *,`games`.id AS gid,`games_img`.id AS imgid FROM `games`,`games_img` WHERE `games_img`.`id` =`games`.`id` AND `games_img`.`id`=#{id} AND isMaster='0'")
    @Results({
            @Result(property ="id" ,column = "gid" ,id = true),
            @Result(property ="gameName" ,column = "gameName" ),
            @Result(property ="status" ,column = "status" ),
            @Result(property ="price" ,column = "price" ),
            @Result(property ="descript" ,column = "descript" ),
            @Result(property ="type" ,column = "type" ),
            @Result(property ="discountPrice" ,column = "discountPrice" ),
            @Result(property ="publishTime" ,column = "publishTime" ),
            @Result(property ="engGameName" ,column = "engGameName" ),
            @Result(property ="gamesImg.id" ,column = "imgid" ),
            @Result(property ="gamesImg.imgUrl" ,column = "imgUrl" ),
            @Result(property ="gamesImg.isMaster" ,column = "isMaster" ),
    })
    List< Games> getGamesDetailByIdLittle(@Param("id") int id);



    @Select("" +
            "<script>" +
            "SELECT games.`id`,`gameName`,`price`,`discount`,`publishTime`,`discountPrice`,`engGameName`,`type` FROM games,games_discount WHERE STATUS='1' AND games.`id`=games_discount.`gid` " +
            "" +
            "<if test='type!=0'>and `games`.`type` = #{type}</if>" +
            "<if test='discountPrice!=0'>and `games`.`discountPrice` BETWEEN '0' AND #{discountPrice} </if>" +
            "" +
            "ORDER BY discountPrice    " +

            "</script>")
    @Results({
            @Result(id = true ,property = "id",column = "id"),
            @Result(property = "gameName",column = "gameName"),
            @Result(property = "price",column = "price"),
            @Result(property = "engGameName",column = "engGameName"),
            @Result(property = "publishTime",column = "publishTime"),
            @Result(property = "type",column = "type"),
            @Result(property = "discountPrice",column = "discountPrice"),
            @Result(property = "gamesDiscount.discount",column = "discount"),
            @Result(property = "gamesImg", column ="id",javaType = GamesImg.class, one =@One(select = "com.loveyj.mapper.GamesImgMapper.getGamesImgByGidAndIsMaster") ),
            @Result(property = "gamesType",column = "type",javaType = GamesType.class,
                    one = @One(select = "com.loveyj.mapper.GameTypeMapper.getGameTypeByTypeID")
            ),
    })
    List<Games> getGamePriceASC(@Param("type") int type,@Param("discountPrice") int discountPrice);




    @Select("" +
            "<script>" +
            "SELECT games.`id`,`gameName`,`price`,`discount`,`publishTime`,`discountPrice`,`engGameName`,`type` FROM games,games_discount WHERE STATUS='1' AND games.`id`=games_discount.`gid` " +
            "" +
            "<if test='type!=0'>and `games`.`type` = #{type}</if>" +
            "<if test='discountPrice!=0'>and `games`.`discountPrice` BETWEEN '0' AND #{discountPrice} </if>" +
            "" +
            "ORDER BY discountPrice DESC  " +

            "</script>")
    @Results({
            @Result(id = true ,property = "id",column = "id"),
            @Result(property = "gameName",column = "gameName"),
            @Result(property = "price",column = "price"),
            @Result(property = "engGameName",column = "engGameName"),
            @Result(property = "publishTime",column = "publishTime"),
            @Result(property = "type",column = "type"),
            @Result(property = "discountPrice",column = "discountPrice"),
            @Result(property = "gamesDiscount.discount",column = "discount"),
            @Result(property = "gamesImg", column ="id",javaType = GamesImg.class, one =@One(select = "com.loveyj.mapper.GamesImgMapper.getGamesImgByGidAndIsMaster") ),
            @Result(property = "gamesType",column = "type",javaType = GamesType.class,
                    one = @One(select = "com.loveyj.mapper.GameTypeMapper.getGameTypeByTypeID")
            ),
    })
    List<Games> getGamePriceDESC(@Param("type") int type,@Param("discountPrice") int discountPrice);


    @Select("" +
            "<script>" +
            "SELECT games.`id`,`gameName`,`price`,`discount`,`publishTime`,`discountPrice`,`engGameName`,`type` FROM games,games_discount WHERE STATUS='1' AND games.`id`=games_discount.`gid` " +
            "" +
            "<if test='gameName!=null'>and `games`.`gameName` like '%${gameName}%'</if>" +
            "<if test='engGameName!=null'>and `games`.`engGameName` like '%${engGameName}%' </if>" +
            "" +
            "</script>")
    @Results({
            @Result(id = true ,property = "id",column = "id"),
            @Result(property = "gameName",column = "gameName"),
            @Result(property = "price",column = "price"),
            @Result(property = "engGameName",column = "engGameName"),
            @Result(property = "publishTime",column = "publishTime"),
            @Result(property = "type",column = "type"),
            @Result(property = "discountPrice",column = "discountPrice"),
            @Result(property = "gamesDiscount.discount",column = "discount"),
            @Result(property = "gamesImg", column ="id",javaType = GamesImg.class, one =@One(select = "com.loveyj.mapper.GamesImgMapper.getGamesImgByGidAndIsMaster") ),
            @Result(property = "gamesType",column = "type",javaType = GamesType.class,
                    one = @One(select = "com.loveyj.mapper.GameTypeMapper.getGameTypeByTypeID")
            ),
    })
    List<Games> getSearchGame(@Param("gameName") String gameName,@Param("engGameName") String engGameName);



    @Select("SELECT *,`games`.id AS gid,`games_img`.id AS imgid FROM `games`,`games_img` WHERE `games_img`.`id` =`games`.`id` AND `games_img`.`id`=#{id} and `games_img`.isMaster='1' ")
    @Results({
            @Result(property ="id" ,column = "gid" ,id = true),
            @Result(property ="gameName" ,column = "gameName" ),
            @Result(property ="status" ,column = "status" ),
            @Result(property ="price" ,column = "price" ),
            @Result(property ="descript" ,column = "descript" ),
            @Result(property ="type" ,column = "type" ),
            @Result(property ="discountPrice" ,column = "discountPrice" ),
            @Result(property ="publishTime" ,column = "publishTime" ),
            @Result(property ="engGameName" ,column = "engGameName" ),
            @Result(property ="gamesImg.id" ,column = "imgid" ),
            @Result(property ="gamesImg.imgUrl" ,column = "imgUrl" ),
            @Result(property ="gamesImg.isMaster" ,column = "isMaster" ),
            @Result(property = "gamesType",column = "type",javaType = GamesType.class,
                    one = @One(select = "com.loveyj.mapper.GameTypeMapper.getGameTypeByTypeID")
            ),
            @Result(property = "gamesDiscount",column = "gid",javaType = GamesDiscount.class,
                    one = @One(select = "com.loveyj.mapper.GamesDiscountMapper.getGameDiscount")
            )
    })
        Games  getGamesDetailById(@Param("id") int id);


    @Select("SELECT * FROM `games`,`games_img` WHERE `games`.`id` = `games_img`.`id` AND `games`.`id` =#{id} AND `games_img`.`isMaster` ='0'")
    @Results({
            @Result(property ="gamesImg.id" ,column = "imgid" ),
            @Result(property ="gamesImg.imgUrl" ,column = "imgUrl" ),
            @Result(property ="gamesImg.isMaster" ,column = "isMaster" )
    })
    List<Games> getGamesDetailsImgs(@Param("id") int id);



    @Select("<script>" +
            "" +
            "SELECT *,`games`.id AS gid,`games_img`.id AS imgid FROM `games`,`games_img` WHERE `games_img`.`id` =`games`.`id` AND " +
            "" +
            " `games`.`id`in " +
            "" +
            "<foreach item='item' collection='id' separator=',' open='(' close=')' index='' >" +
            "#{item} " +
            "</foreach>" +
            "AND isMaster='1'" +
            "</script>")
    @Results({
            @Result(property ="id" ,column = "gid" ,id = true),
            @Result(property ="gameName" ,column = "gameName" ),
            @Result(property ="status" ,column = "status" ),
            @Result(property ="price" ,column = "price" ),
            @Result(property ="descript" ,column = "descript" ),
            @Result(property ="type" ,column = "type" ),
            @Result(property ="discountPrice" ,column = "discountPrice" ),
            @Result(property ="publishTime" ,column = "publishTime" ),
            @Result(property ="engGameName" ,column = "engGameName" ),
            @Result(property ="gamesImg.id" ,column = "imgid" ),
            @Result(property ="gamesImg.imgUrl" ,column = "imgUrl" ),
            @Result(property ="gamesImg.isMaster" ,column = "isMaster" ),
    })
    List< Games> getGamesDetailById4Buy(@Param("id") String[] id);


    @Select("<script>" +
            "select *,`games`.`id` as a from games " +
            "where 1=1" +
            "<if test='gameName!=null'>and `games`.`gameName` like '%${gameName}%'</if>" +
            "<if test='engGameName!=null'>and `games`.`engGameName` like '%${engGameName}%' </if>" +
            "</script>")
    @Results({
            @Result(property = "id",column = "a"),

            @Result(property = "gamesDiscount",column = "id",javaType = GamesDiscount.class,
                    one = @One(select = "com.loveyj.mapper.GamesDiscountMapper.getGameDiscount")
            ),
            @Result(property = "gamesType",column = "type",javaType = GamesType.class,
                    one = @One(select = "com.loveyj.mapper.GameTypeMapper.getGameTypeByTypeID")
            ), @Result(property = "gamesImg", column ="id",javaType = GamesImg.class, one =@One(select = "com.loveyj.mapper.GamesImgMapper.getGamesImgByGidAndIsMaster") )
    })
    List<Games> selectAllGames(@Param("gameName") String gameName,@Param("engGameName") String engGameName);


    @Update("UPDATE `games` SET `status` =#{status} WHERE `id` = #{id}")
    int updateStatus(@Param("id") int id,@Param("status") int status);


    @Update("<script>" +
            "UPDATE `games` " +
            "" +
            "<if test='discount!=1'>SET  `discountPrice` =`discountPrice`*#{discount}   </if>" +
            "<if test='discount==1'>SET  `discountPrice` =`price`  </if>" +
            " WHERE `id` = #{id}" +
            "" +
            "</script>")
    int updateDiscountPrice(@Param("id") int id,@Param("discount") double discount);


    @Select("select * from `games` order by id desc limit 0,1")
    Games getNewGameId();
}
