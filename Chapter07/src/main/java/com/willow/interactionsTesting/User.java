package com.willow.interactionsTesting;

public class User {
    private String name;
    private String password;

    User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
