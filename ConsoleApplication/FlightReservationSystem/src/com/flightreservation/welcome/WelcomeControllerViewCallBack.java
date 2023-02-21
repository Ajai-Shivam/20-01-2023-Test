package com.flightreservation.welcome;

import com.flightreservation.dto.User;

public interface WelcomeControllerViewCallBack {
    void userAddedSuccessfully(User user);

    void userAddedFailed(String s);

    void checkAdminSuccessful();

    void checkAdminFailed();

    void userLoginSuccessful(User user);

    void userLoginFailed(String s);
}
