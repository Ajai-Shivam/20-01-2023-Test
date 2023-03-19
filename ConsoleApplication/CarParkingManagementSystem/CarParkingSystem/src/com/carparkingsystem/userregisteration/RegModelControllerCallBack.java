package com.carparkingsystem.userregisteration;

public interface RegModelControllerCallBack {
    String userRegistration(String name, String mail, long phoneNumber, String password, String carNumebr, String carModel);
}
