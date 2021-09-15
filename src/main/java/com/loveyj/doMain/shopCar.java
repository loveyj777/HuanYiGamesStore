package com.loveyj.doMain;

import org.springframework.stereotype.Component;

@Component("shopCar")
public class shopCar {

    private  int id;

    private  int uid;

    private  int gid;

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

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public shopCar() {
    }

    public shopCar(int id, int uid, int gid) {
        this.id = id;
        this.uid = uid;
        this.gid = gid;
    }
}
