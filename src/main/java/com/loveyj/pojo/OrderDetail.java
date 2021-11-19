package com.loveyj.pojo;

import org.springframework.stereotype.Component;



public class OrderDetail {

  private int id;
  private int oid;
  private String productName;
  private double productPrice;
  private String productImg;
  private int gid;

  public int getGid() {
    return gid;
  }

  public void setGid(int gid) {
    this.gid = gid;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(double productPrice) {
    this.productPrice = productPrice;
  }

  public String getProductImg() {
    return productImg;
  }

  public void setProductImg(String productImg) {
    this.productImg = productImg;
  }

  @Override
  public String toString() {
    return "OrderDetail{" +
            "id=" + id +
            ", oid=" + oid +
            ", productName='" + productName + '\'' +
            ", productPrice=" + productPrice +
            ", productImg='" + productImg + '\'' +
            ", gid=" + gid +
            '}';
  }
}
