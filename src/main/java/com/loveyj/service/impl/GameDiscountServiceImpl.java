package com.loveyj.service.impl;

import com.loveyj.mapper.GamesDiscountMapper;
import com.loveyj.service.GameDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gameDiscountServiceImpl")
public class GameDiscountServiceImpl implements GameDiscountService {

    @Autowired
    GamesDiscountMapper gamesDiscountMapper;

    @Override
    public int updateGameDiscount(double discount, int gid) {
        return gamesDiscountMapper.updateGameDiscount(discount,gid);
    }

    @Override
    public int insertNewGamesDiscount(int gid) {
        return gamesDiscountMapper.insertNewGamesDiscount(gid);
    }
}
