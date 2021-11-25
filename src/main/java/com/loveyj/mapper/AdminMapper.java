package com.loveyj.mapper;

import com.loveyj.pojo.Admin;
import org.apache.ibatis.annotations.Select;


public interface AdminMapper {

    @Select("select * from admin where user='${user}' and password ='${password}' ")
    Admin findAdmin(Admin admin);
}
