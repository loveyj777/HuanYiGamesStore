package com.loveyj.service.impl;

import com.loveyj.mapper.GamesMapper;
import com.loveyj.pojo.Games;
import com.loveyj.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("gamesService")
public class GamesServiceImpl implements GamesService {

    @Autowired
    GamesMapper gamesMapper;

    @Override
    public List<Games> getGamesDiscountList(int type,int discountPrice) {
        return gamesMapper.getGamesDiscountList( type, discountPrice);
    }


    @Override
    public List<Games> getNewGame(int type,int discountPrice) {
        return  gamesMapper.getNewGame( type, discountPrice);
    }

    @Override
    public List<Games> getHotSaleByOrder() {
        return gamesMapper.getHotSaleByOrder();
    }


    @Override
    public List<Games> getHotSale(int type,int price) {


        return gamesMapper.getHotSale(type,price);
    }

    @Override
    public int insertGame(Games games) {
        return gamesMapper.insertGame(games);
    }

    @Override
    public List<Games> getGamesDetailByIdLittle(int id) {
        return  gamesMapper.getGamesDetailByIdLittle(id);
    }


    @Override
    public List<Games> getGamePriceDESC(int type, int discountPrice) {
        return gamesMapper.getGamePriceDESC(type,discountPrice);
    }

    @Override
    public List<Games> getGamePriceASC(int type, int discountPrice) {
        return gamesMapper.getGamePriceASC(type,discountPrice);
    }

    @Override
    public List<Games> getSearchGame(String gameName, String engGameName) {
        return gamesMapper.getSearchGame(gameName,engGameName);
    }

    @Override
    public Games getGamesDetailById(int id) {
        return gamesMapper.getGamesDetailById(id);
    }

    @Override
    public List<Games> getGamesDetailsImgs(int id) {
        return  gamesMapper.getGamesDetailsImgs(id);
    }

    @Override
    public List<Games> getGamesDetailById4Buy(String[] id) {
        return  gamesMapper.getGamesDetailById4Buy(id);
    }

    @Override
    public List<Games> selectAllGames(String gameName,String engGameName) {
        return gamesMapper.selectAllGames(gameName,engGameName);
    }

    @Override
    public int updateStatus(int id, int status) {
        return gamesMapper.updateStatus(id, status);
    }

    @Override
    public int updateDiscountPrice(int id, double discount) {
        return gamesMapper.updateDiscountPrice(id,discount);
    }

    @Override
    public Games getNewGameId() {
        return gamesMapper.getNewGameId();
    }
}
