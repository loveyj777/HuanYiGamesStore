package com.loveyj.mapper;

import com.loveyj.pojo.UserPointsDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserPointsDetailsMapper {

    @Select("<script>" +
            "" +
            "" +
            "SELECT * FROM user_pointsDetails " +
            "WHERE 1=1" +
            "" +
            "<if test='type==0'>and type =#{type}</if>" +
            "and uid = #{uid}" +
            "" +
            "" +
            "</script>")
    List<UserPointsDetails> getUserPointsDetailsByUid(@Param("uid") int uid,@Param("type") int type);


    @Insert("INSERT INTO user_pointsdetails(uid,`type`,changePoints) VALUE(#{uid},'0','20')")
    int insertDetails4SignIN(@Param("uid") int uid);


    @Insert("INSERT INTO user_pointsdetails(uid,`type`,changePoints) VALUE(#{uid},'2',#{points})")
    int insertDetails4PointsShop(@Param("uid") int uid,@Param("points") int points);


    @Insert("INSERT INTO user_pointsdetails(uid,`type`,changePoints) VALUE(#{uid},'1',#{points})")
    int insertDetails4Buy(@Param("uid") int uid,@Param("points") int points);


}
