package com.flightreservation.welcome;

public interface WelcomeControllerModelCallBack {
    void signUp(String userName, String passWord);

    void checkAdminLogin(String userName, String passWord);

    void checkUserLogin(String userName, String passWord);
}
