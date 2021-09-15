package com.loveyj.doMain;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component("user")
public class user {

    private  int id;

    private  String userName;

    private  String password;

    private  double points;

    private  double money;

    private Timestamp registerTime;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    public user() {

    }

    public user(int id, String userName, String password, double points, double money, Timestamp registerTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.points = points;
        this.money = money;
        this.registerTime = registerTime;
    }
}
