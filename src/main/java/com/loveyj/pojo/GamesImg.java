package com.loveyj.pojo;

import org.springframework.stereotype.Component;


public class GamesImg {

  private int id;
  private String imgUrl;
  private int isMaster;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public int getIsMaster() {
    return isMaster;
  }

  public void setIsMaster(int isMaster) {
    this.isMaster = isMaster;
  }


  @Override
  public String toString() {
    return "GamesImg{" +
            "id=" + id +
            ", imgUrl='" + imgUrl + '\'' +
            ", isMaster=" + isMaster +
            '}';
  }
}
