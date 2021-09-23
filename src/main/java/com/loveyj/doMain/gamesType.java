package com.loveyj.doMain;

import org.springframework.stereotype.Component;

@Component("gamesType")
public class gamesType {

    private int id;

    private String typeName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public gamesType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public gamesType() {
    }
}
