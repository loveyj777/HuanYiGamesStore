package com.loveyj.service.impl;

import com.loveyj.mapper.UserMapper;
import com.loveyj.mapper.UserPointMapper;
import com.loveyj.pojo.UserPoints;
import com.loveyj.service.UserPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userPointsService")
public class UserPointsServiceImpl implements UserPointsService {

    @Autowired
    UserPointMapper userPointMapper;

    @Override
    public UserPoints getUserPointsByUid(int uid) {

        return userPointMapper.getUserPointsByUid(uid);
    }


    @Override
    public int updatePoints4SignIn(int uid) {
        return userPointMapper.updatePoints4SignIn(uid);
    }


    @Override
    public int updatePoints4pointsShop(int uid, int points) {

        return userPointMapper.updatePoints4pointsShop(uid,points);
    }

    @Override
    public int updatePoints4Buy(int uid, int points) {
        return userPointMapper.updatePoints4Buy(uid,points);
    }


}
