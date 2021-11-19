package com.loveyj.pojo;

import java.util.List;


public class Games {

  private int id;
  private String gameName;
  private int status;
  private double price;
  private String descript;
  private int type;
  private double discountPrice;
  private String publishTime;
  private String engGameName;
  private GamesDiscount gamesDiscount;
  private GamesImg gamesImg;
  private GamesType gamesType;
  private OrderDetail orderDetail;
  private List<GamesImg> gamesImgs;
  private String statusName;


  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

  public List<GamesImg> getGamesImgs() {
    return gamesImgs;
  }

  public void setGamesImgs(List<GamesImg> gamesImgs) {
    this.gamesImgs = gamesImgs;
  }

  public OrderDetail getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(OrderDetail orderDetail) {
    this.orderDetail = orderDetail;
  }

  public GamesType getGamesType() {
    return gamesType;
  }

  public void setGamesType(GamesType gamesType) {
    this.gamesType = gamesType;
  }

  public String getEngGameName() {
    return engGameName;
  }

  public void setEngGameName(String engGameName) {
    this.engGameName = engGameName;
  }

  public double getDiscountPrice() {
    return discountPrice;
  }

  public void setDiscountPrice(double discountPrice) {
    this.discountPrice = discountPrice;
  }

  public String getPublishTime() {
    return publishTime;
  }

  public void setPublishTime(String publishTime) {
    this.publishTime = publishTime;
  }

  public GamesImg getGamesImg() {
    return gamesImg;
  }

  public void setGamesImg(GamesImg gamesImg) {
    this.gamesImg = gamesImg;
  }

  public GamesDiscount getGamesDiscount() {
    return gamesDiscount;
  }

  public void setGamesDiscount(GamesDiscount gamesDiscount) {
    this.gamesDiscount = gamesDiscount;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGameName() {
    return gameName;
  }

  public void setGameName(String gameName) {
    this.gameName = gameName;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getDescript() {
    return descript;
  }

  public void setDescript(String descript) {
    this.descript = descript;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }


  @Override
  public String toString() {
    return "Games{" +
            "id=" + id +
            ", gameName='" + gameName + '\'' +
            ", status=" + status +
            ", price=" + price +
            ", descript='" + descript + '\'' +
            ", type=" + type +
            ", discountPrice=" + discountPrice +
            ", publishTime='" + publishTime + '\'' +
            ", engGameName='" + engGameName + '\'' +
            ", gamesDiscount=" + gamesDiscount +
            ", gamesImg=" + gamesImg +
            ", gamesType=" + gamesType +
            ", orderDetail=" + orderDetail +
            ", gamesImgs=" + gamesImgs +
            '}';
  }
}
