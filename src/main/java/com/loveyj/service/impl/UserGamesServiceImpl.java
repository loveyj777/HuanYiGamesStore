package com.loveyj.service.impl;

import com.loveyj.mapper.UserGamesMapper;
import com.loveyj.pojo.UserGames;
import com.loveyj.service.UserGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userGamesService")
public class UserGamesServiceImpl implements UserGamesService {

    @Autowired
    private UserGamesMapper userGamesMapper;

    @Override
    public List<UserGames> getUerGamesByUid(int id) {
        return userGamesMapper.getUerGamesByUid(id);
    }

    @Override
    public int addUserGame(UserGames userGames) {
        return userGamesMapper.addUserGame(userGames);
    }

    @Override
    public UserGames getUerGamesByGid(int gid, int uid) {
        return userGamesMapper.getUerGamesByGid(gid,uid);
    }
}
