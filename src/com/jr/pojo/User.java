package com.jr.pojo;

public class User {
    private String uID;
    private String uName;
    private String uPassword;

    public User() {
    }

    public User(String uID, String uName, String uPassword) {
        this.uID = uID;
        this.uName = uName;
        this.uPassword = uPassword;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "uID=" + uID +
                ", uName='" + uName + '\'' +
                ", uPassword='" + uPassword + '\'' +
                '}';
    }
}
