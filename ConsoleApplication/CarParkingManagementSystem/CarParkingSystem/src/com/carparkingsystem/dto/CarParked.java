package com.carparkingsystem.dto;

import java.time.Instant;

public class CarParked {
    private String userID;
    private String userName;
    private long phoneNumber;
    private String email;
    private String carNumber;
    private String carModel;
    private Instant parkedTime;
    private String parkedSlot;
    private Instant carDropTime;
    private  int totalAmountTopay;
    private int row;
    private int col;

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getTotalAmountTopay() {
        return totalAmountTopay;
    }

    public void setTotalAmountTopay(int totalAmountTopay) {
        this.totalAmountTopay = totalAmountTopay;
    }

    public CarParked(User user, String parkedSlot,int row,int col) {
        this.userID = user.getUserID();
        this.userName = user.getUserName();
        this.phoneNumber = user.getPhoneNumber();
        this.email = user.getEmail();
        this.carNumber = user.getCarNumber();
        this.carModel = user.getCarModel();
        this.parkedSlot = parkedSlot;
        parkedTime = Instant.now();
        this.row= row;
        this.col = col;
    }


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

    public Instant getParkedTime() {
        return parkedTime;
    }

    public void setParkedTime(Instant parkedTime) {
        this.parkedTime = parkedTime;
    }

    public String getParkedSlot() {
        return parkedSlot;
    }

    public void setParkedSlot(String parkedSlot) {
        this.parkedSlot = parkedSlot;
    }

    public Instant getCarDropTime() {
        return carDropTime;
    }

    public void setCarDropTime(Instant carDropTime) {
        this.carDropTime = carDropTime;
    }
}

