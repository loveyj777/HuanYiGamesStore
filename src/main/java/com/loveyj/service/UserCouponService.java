package com.loveyj.service;

import org.apache.ibatis.annotations.Param;

public interface UserCouponService {

    int updateCouponToUse( int uid, int cid);
}
