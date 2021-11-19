package com.loveyj.mapper;

import com.loveyj.pojo.UserPoints;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserPointMapper {


    @Select("select * from user_points where uid=#{uid}")
      UserPoints getUserPointsByUid(@Param("uid") int uid);


    @Update("UPDATE user_points SET points=points+'20' WHERE uid=#{uid} ")
      int  updatePoints4SignIn(@Param("uid") int uid);


    @Update("UPDATE user_points SET points=points-#{points} WHERE uid=#{uid} ")
    int  updatePoints4pointsShop(@Param("uid") int uid,@Param("points")  int points);

    @Update("UPDATE user_points SET points=points+#{points} WHERE uid=#{uid} ")
    int  updatePoints4Buy(@Param("uid") int uid,@Param("points")  int points);
}
