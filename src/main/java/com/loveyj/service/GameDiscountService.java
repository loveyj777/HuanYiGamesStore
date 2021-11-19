package com.loveyj.service;

import org.apache.ibatis.annotations.Param;

public interface GameDiscountService {

    int updateGameDiscount( double discount,  int gid);

    int insertNewGamesDiscount( int gid);

}
