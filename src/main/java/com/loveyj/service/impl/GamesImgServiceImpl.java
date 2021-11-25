package com.loveyj.service.impl;

import com.loveyj.mapper.GamesImgMapper;
import com.loveyj.pojo.GamesImg;
import com.loveyj.service.GamesImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gamesImgService")
public class GamesImgServiceImpl implements GamesImgService {

    @Autowired
    GamesImgMapper gamesImgMapper;


    @Override
    public int InsertGamesImg(GamesImg gamesImg) {
        return gamesImgMapper.InsertGamesImg(gamesImg);
    }
}
