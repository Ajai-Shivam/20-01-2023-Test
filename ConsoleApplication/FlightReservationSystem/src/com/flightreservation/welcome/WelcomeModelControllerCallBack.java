package com.flightreservation.welcome;

import com.flightreservation.dto.User;

public interface WelcomeModelControllerCallBack {

    void userAddedSuccessfully(User user);

    void checkAdminLoginSucessful();

    void checkAdminLoginFailed();

    void userLoginSuccesful(User user);

    void userLoginFailed();

    void userAddedFailed();
}
