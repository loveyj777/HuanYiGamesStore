package com.loveyj.pojo;

import org.springframework.stereotype.Component;


public class UserCoupon {

  private int id;
  private int uid;
  private int cid;
  private int status;
  private  String getTime;
  private  String useTime;
  private int isOverdue;

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

  public int getCid() {
    return cid;
  }

  public void setCid(int cid) {
    this.cid = cid;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getGetTime() {
    return getTime;
  }

  public void setGetTime(String getTime) {
    this.getTime = getTime;
  }

  public String getUseTime() {
    return useTime;
  }

  public void setUseTime(String useTime) {
    this.useTime = useTime;
  }

  public int getIsOverdue() {
    return isOverdue;
  }

  public void setIsOverdue(int isOverdue) {
    this.isOverdue = isOverdue;
  }

  @Override
  public String toString() {
    return "UserCoupon{" +
            "id=" + id +
            ", uid=" + uid +
            ", cid=" + cid +
            ", status=" + status +
            ", getTime='" + getTime + '\'' +
            ", useTime='" + useTime + '\'' +
            '}';
  }
}
