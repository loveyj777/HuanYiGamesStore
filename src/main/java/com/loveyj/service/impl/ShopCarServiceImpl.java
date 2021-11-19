package com.loveyj.service.impl;

import com.loveyj.mapper.ShopCarMapper;
import com.loveyj.pojo.ShopCar;
import com.loveyj.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopCarServiceImpl")
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    ShopCarMapper shopCarMapper;

    @Override
    public int insertShopcar(int uid, int gid, double price) {
        return  shopCarMapper.insertShopcar(uid,gid,price);
    }


    @Override
    public ShopCar selectShopCarIfExistByUid(int uid, int gid) {
        return shopCarMapper.selectShopCarIfExistByUid(uid,gid);
    }

    @Override
    public List<ShopCar> getUserShopCarByUid(int uid) {
        return shopCarMapper.getUserShopCarByUid(uid);
    }


    @Override
    public int deleteGameInShopCarByUidAndGid(int uid, int gid) {
        return shopCarMapper.deleteGameInShopCarByUidAndGid(uid,gid);
    }
}
