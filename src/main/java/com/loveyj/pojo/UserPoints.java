package com.loveyj.pojo;

import org.springframework.stereotype.Component;

public class UserPoints {

  private int id;
  private int uid;
  private int points;


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

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }
}
