package com.loveyj.pojo;

import org.springframework.stereotype.Component;


public class GamesType {

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


  @Override
  public String toString() {
    return "GamesType{" +
            "id=" + id +
            ", typeName='" + typeName + '\'' +
            '}';
  }
}
