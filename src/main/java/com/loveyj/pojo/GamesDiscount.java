package com.loveyj.pojo;


public class GamesDiscount {

  private int id;
  private int gid;
  private String discount;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getGid() {
    return gid;
  }

  public void setGid(int gid) {
    this.gid = gid;
  }

  public String getDiscount() {
    return discount;
  }

  public void setDiscount(String discount) {
    this.discount = discount;
  }


  @Override
  public String toString() {
    return "GamesDiscount{" +
            "id=" + id +
            ", gid=" + gid +
            ", discount=" + discount +
            '}';
  }
}
