package com.loveyj.service;

import com.loveyj.pojo.ShopCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCarService {

    int insertShopcar( int uid,  int gid,  double price);

    ShopCar selectShopCarIfExistByUid( int uid, int gid);

    List<ShopCar> getUserShopCarByUid(int uid);


    int deleteGameInShopCarByUidAndGid( int uid,int gid);
}
