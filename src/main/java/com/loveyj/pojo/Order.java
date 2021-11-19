package com.loveyj.pojo;

import java.sql.Date;
import java.util.List;


public class Order {

  private int id;
  private int uid;
  private String uname;
  private int orderPoints;
  private int status;
  private String createTime;
  private String payTime;
  private OrderDetail orderDetail;
  private User user;
  private List<OrderDetail> orderDetailList;

  public List<OrderDetail> getOrderDetailList() {
    return orderDetailList;
  }

  public void setOrderDetailList(List<OrderDetail> orderDetailList) {
    this.orderDetailList = orderDetailList;
  }

  private String statusName;

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

  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public int getOrderPoints() {
    return orderPoints;
  }

  public void setOrderPoints(int orderPoints) {
    this.orderPoints = orderPoints;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getPayTime() {
    return payTime;
  }

  public void setPayTime(String payTime) {
    this.payTime = payTime;
  }

  public OrderDetail getOrderDetail() {
    return orderDetail;
  }

  public void setOrderDetail(OrderDetail orderDetail) {
    this.orderDetail = orderDetail;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }


  @Override
  public String toString() {
    return "Order{" +
            "id=" + id +
            ", uid=" + uid +
            ", uname='" + uname + '\'' +
            ", orderPoints=" + orderPoints +
            ", status=" + status +
            ", createTime='" + createTime + '\'' +
            ", payTime=" + payTime +
            ", orderDetail=" + orderDetail +
            ", user=" + user +
            ", orderDetailList=" + orderDetailList +
            ", statusName='" + statusName + '\'' +
            '}';
  }
}
