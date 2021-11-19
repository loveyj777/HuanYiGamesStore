package com.loveyj.service.impl;


import com.loveyj.mapper.UserPointsDetailsMapper;
import com.loveyj.pojo.UserPointsDetails;
import com.loveyj.service.UserPointsDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userPointsDetailsService")
public class UserPointsDetailsServiceImpl implements UserPointsDetailsService {


    @Autowired
    UserPointsDetailsMapper userPointsDetailsMapper;


    @Override
    public List<UserPointsDetails> getUserPointsDetailsByUid(int uid,int type) {

        return  userPointsDetailsMapper.getUserPointsDetailsByUid(uid,type);
    }


    @Override
    public int insertDetails4SignIN(int id) {

        return userPointsDetailsMapper.insertDetails4SignIN(id);
    }

    @Override
    public int insertDetails4PointsShop(int uid, int points) {
        return userPointsDetailsMapper.insertDetails4PointsShop(uid,points);
    }

    @Override
    public int insertDetails4Buy(int uid, int points) {
        return userPointsDetailsMapper.insertDetails4Buy(uid,points);
    }
}
