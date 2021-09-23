package com.loveyj.doMain;


import org.springframework.stereotype.Component;

@Component("games")
public class games {

    private int id;

    private  String gameImg;

    private  int gamesType;

    private  double price;

    private  double discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameImg() {
        return gameImg;
    }

    public void setGameImg(String gameImg) {
        this.gameImg = gameImg;
    }

    public int getGamesType() {
        return gamesType;
    }

    public void setGamesType(int gamesType) {
        this.gamesType = gamesType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public games() {
    }

    public games(int id, String gameImg, int gamesType, double price, double discount) {
        this.id = id;
        this.gameImg = gameImg;
        this.gamesType = gamesType;
        this.price = price;
        this.discount = discount;
    }
}
