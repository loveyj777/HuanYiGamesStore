package com.loveyj.service;

import com.loveyj.pojo.UserPointsDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPointsDetailsService {

    List<UserPointsDetails> getUserPointsDetailsByUid(int uid,int type);

    int insertDetails4SignIN(int uid);


    int insertDetails4PointsShop(int uid, int points);



    int insertDetails4Buy(int uid, int points);
}
