package com.loveyj.doMain;


import org.springframework.stereotype.Component;

@Component("point")
public class point {

    private  int id;

    private  double point;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public point(int id, double point) {
        this.id = id;
        this.point = point;
    }

    public point() {
    }
}
