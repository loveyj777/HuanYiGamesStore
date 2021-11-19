package com.loveyj.pojo;

import org.springframework.stereotype.Component;


public class UserPointsDetails {

  private int id;
  private int uid;
  private int type;
  private int changePoints;
  private String flag;
  private String typeName;
  private String time;

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

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

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getChangePoints() {
    return changePoints;
  }

  public void setChangePoints(int changePoints) {
    this.changePoints = changePoints;
  }

  public String getFlag() {
    return flag;
  }

  public void setFlag(String flag) {
    this.flag = flag;
  }
}
