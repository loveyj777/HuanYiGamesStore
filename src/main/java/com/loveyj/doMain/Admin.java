package com.loveyj.doMain;

import org.springframework.stereotype.Component;

@Component("admin")
public class admin {

    private  String user;

    private  String password;


    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
