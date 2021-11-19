package com.loveyj.mapper;


import com.loveyj.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select({ "<script>" +
            " select * from `user`" +
            " where 1=1 " +
            "<if test='userName!=null'> and userName=#{userName} </if>" +
            "<if test='phone!=null'>and `phone`=#{phone} </if>" +
            " and `password`='${password}' " +
            "</script>" })
    User getUserByUserNameOrPhone(User user);


    @Select("select * from `user` where phone ='${phone}'")
    User getUserByPhone(User  user);

    @Select("select * from `user` where id =#{id} ")
    User getUserById(int id);

    @Insert("insert into `user_points`(uid) value(#{id})")
    int insertUserPoints(int id);

    @Select("select * from `user`")
    List<User> getUser();

    @Insert("INSERT INTO `user`(userName,phone) VALUE('${userName}','${phone}')")
    int insertUserByPhone(User user);


    @Select("select * from `user`")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "userName",property = "userName"),
            @Result(column = "password",property = "password"),
            @Result(column = "registerTime",property = "registerTime"),
            @Result(column = "phone",property = "phone"),
            @Result(javaType = List.class,column = "id",property = "orderList",many =@Many(select="com.loveyj.mapper.OrderMapper.getOrderByUid")),
    })
    List<User> getUserOrder();


    @Update("UPDATE `user` SET userName='${userName}' , introduce =#{introduce},headImg = '${headImg}' WHERE id = '${id}'")
    int updateUserById(User user);




    @Update("update `user` set phone='${phone}' where id='${id}' ")
    int updateUserPhoneById(User user);


    @Update("update `user` set password='${password}' where id ='${id}' ")
    int updateUserPasswordById(@Param("password")String password,@Param("id")int id);

    @Select("SELECT * FROM `user` WHERE userName=#{userName} OR phone=#{phone}")
    User findUserByUserNameOrPhone(@Param("userName") String userName,@Param("phone") String phone);

}


