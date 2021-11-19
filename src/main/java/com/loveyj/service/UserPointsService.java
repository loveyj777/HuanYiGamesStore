package com.loveyj.service;

import com.loveyj.pojo.UserPoints;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface UserPointsService {

     UserPoints getUserPointsByUid(int uid);

    int  updatePoints4SignIn(int uid);


    int  updatePoints4pointsShop(int uid,  int points);


    int  updatePoints4Buy(int uid, int points);

}
