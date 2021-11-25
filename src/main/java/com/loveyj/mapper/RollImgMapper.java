package com.loveyj.mapper;

import com.loveyj.pojo.RollImg;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RollImgMapper {


    @Select("select * from rollimg")
    List<RollImg> getAllRollImg();
}
