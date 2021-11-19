package com.loveyj.pojo;

import org.springframework.stereotype.Component;



public class ShopCar {

  private int id;
  private int uid;
  private int gid;
  private double price;
  private Games games;



  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public int getGid() {
    return gid;
  }

  public void setGid(int gid) {
    this.gid = gid;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Games getGames() {
    return games;
  }

  public void setGames(Games games) {
    this.games = games;
  }
}
