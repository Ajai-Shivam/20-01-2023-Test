package com.carparkingsystem.dto;

public class User {
    private String userID;
    private String userName;
    private String password;
    private long phoneNumber;
    private String email;
    private String carNumber;
    private String carModel;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public User(String userID, String userName, String password, long phoneNumber, String email, String carNumber, String carModel) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.carNumber = carNumber;
        this.carModel = carModel;
    }
}
