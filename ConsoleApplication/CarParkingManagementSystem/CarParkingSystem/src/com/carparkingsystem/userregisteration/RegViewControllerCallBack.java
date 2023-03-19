package com.carparkingsystem.userregisteration;

public interface RegViewControllerCallBack {
    String userRegistration(String name, String mail, long phoneNumber, String password, String carNumebr, String carModel);
}
