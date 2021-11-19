package com.loveyj.service;

import com.loveyj.pojo.UserGames;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserGamesService {

    List<UserGames> getUerGamesByUid(int id);

    int addUserGame(UserGames userGames);

    UserGames getUerGamesByGid(int gid, int uid);
}
