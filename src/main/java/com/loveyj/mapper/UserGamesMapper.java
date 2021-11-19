package com.loveyj.mapper;

import com.loveyj.pojo.UserGames;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserGamesMapper {

        @Select("select * from user_games where uid =#{id}")
        List<UserGames> getUerGamesByUid(@Param("id") int id);

        @Insert("INSERT INTO `user_games`(`gid`,`gName`,`uid`,`gImg`) VALUES('${gid}','${gName}','${uid}','${gImg}') ")
        int addUserGame(UserGames userGames);


        @Select("select * from user_games where gid =#{gid} and uid=#{uid}")
        UserGames getUerGamesByGid(@Param("gid") int gid,@Param("uid") int uid);
}
