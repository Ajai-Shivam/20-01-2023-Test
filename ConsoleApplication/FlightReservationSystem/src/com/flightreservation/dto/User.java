package com.flightreservation.dto;

public class User {
    private int UserId;
    private String userName;
    private String passWord;

    public User(int userId, String userName, String passWord) {
        UserId = userId;
        this.userName = userName;
        this.passWord = passWord;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
