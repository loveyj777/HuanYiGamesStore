package com.loveyj.mapper;

import com.loveyj.pojo.GamesType;
import org.apache.ibatis.annotations.Select;

public interface GameTypeMapper {

    @Select("select * from `games_type` where `id` = #{id}")
    GamesType getGameTypeByTypeID();
}
