package com.loveyj.service;


import com.loveyj.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface UserService {


    User getUserByUserNameOrPhone(User user);


    User getUserByPhone(User  user);

    int insertUserByPhone(User user);

    int insertUserPoints(int id);

    List<User> getUser();

    List<User> getUserOrder();

    User getUserById(int id);


    int updateUserById(User user);

    int updateUserPhoneById(User user);

    int updateUserPasswordById(String password,int id);

    User findUserByUserNameOrPhone(String userName,String phone);
}
