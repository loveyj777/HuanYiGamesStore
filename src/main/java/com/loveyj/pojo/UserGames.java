package com.loveyj.pojo;

import org.springframework.stereotype.Component;


public class UserGames {

  private int id;
  private int gid;
  private  int uid;
  private String gName;

  private String gImg;


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

  public String getgName() {
    return gName;
  }

  public void setgName(String gName) {
    this.gName = gName;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public String getgImg() {
    return gImg;
  }

  public void setgImg(String gImg) {
    this.gImg = gImg;
  }
}
