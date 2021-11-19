package com.loveyj.mapper;

import com.loveyj.pojo.GamesImg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface GamesImgMapper {


    @Select("select * from games_img where `id`=#{gid} and `isMaster` ='1'")
    GamesImg getGamesImgByGidAndIsMaster(int gid);


    @Select("select * from games_img where `id`=#{gid} and `isMaster` ='0'")
    List<GamesImg> getGamesImgByGid(int gid);

    @Insert("INSERT INTO `games_img`(`id`,`imgUrl`,`isMaster`) VALUES (#{id},#{imgUrl},#{isMaster})")
    int InsertGamesImg(GamesImg gamesImg);
}
