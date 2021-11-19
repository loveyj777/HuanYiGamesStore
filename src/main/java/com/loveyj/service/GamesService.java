package com.loveyj.service;

import com.loveyj.pojo.Games;

import java.util.List;

public interface GamesService {

    List<Games> getGamesDiscountList(int type,int discountPrice);

    List<Games> getNewGame(int type,int discountPrice);

    List<Games> getHotSaleByOrder();

    List<Games> getHotSale(int type,int discountPrice);

    int insertGame(Games games);

    List< Games> getGamesDetailByIdLittle(int id);

    List<Games> getGamePriceDESC(int type,int discountPrice);

    List<Games> getGamePriceASC(int type,int discountPrice);

    List<Games> getSearchGame( String gameName,String engGameName);

    Games  getGamesDetailById(int id);

    List<Games> getGamesDetailsImgs(int id);

    List< Games> getGamesDetailById4Buy(String[] id);

    List<Games> selectAllGames(String gameName,String engGameName);

    int updateStatus(int id, int status);


    int updateDiscountPrice(int id, double discount);

    Games getNewGameId();
}
