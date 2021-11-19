package com.loveyj.service.impl;

import com.loveyj.mapper.UserCouponMapper;
import com.loveyj.service.UserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userCouponServiceImpl")
public class UserCouponServiceImpl implements UserCouponService {

    @Autowired
    UserCouponMapper userCouponMapper;

    @Override
    public int updateCouponToUse(int uid, int cid) {

        return userCouponMapper.updateCouponToUse(uid,cid);
    }
}
