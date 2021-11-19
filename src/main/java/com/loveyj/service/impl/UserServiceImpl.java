package com.loveyj.service.impl;


import com.loveyj.pojo.User;
import com.loveyj.mapper.UserMapper;
import com.loveyj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
   private UserMapper userMapper;

    @Override
    public User getUserByUserNameOrPhone(User user) {

      return  userMapper.getUserByUserNameOrPhone(user);

    }



    @Override
    public List<User> getUser() {
        return userMapper.getUser();
    }

    @Override
    public User getUserByPhone(User user) {
        return userMapper.getUserByPhone(user);
    }

    @Override
    public int insertUserByPhone(User user) {
        return userMapper.insertUserByPhone(user);
    }


    @Override
    public List<User> getUserOrder() {
        return userMapper.getUserOrder();
    }


    @Override
    public User getUserById(int id) {

        return userMapper.getUserById(id);
    }


    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }


    @Override
    public int updateUserPhoneById(User user) {
        return userMapper.updateUserPhoneById(user);
    }

    @Override
    public int updateUserPasswordById(String password,int id) {
        return userMapper.updateUserPasswordById(password,id);
    }

    @Override
    public User findUserByUserNameOrPhone(String userName,String phone) {
        return userMapper.findUserByUserNameOrPhone(userName,phone);
    }


    @Override
    public int insertUserPoints(int id) {
        return userMapper.insertUserPoints(id);
    }
}
