package com.flightreservation.welcome;

public interface WelcomeViewControllerCallBack {
    void checkAdminLogin(String userName, String passWord);

    void checkUserLogin(String userName, String passWord);

    void signUp(String userName, String passWord);
}
