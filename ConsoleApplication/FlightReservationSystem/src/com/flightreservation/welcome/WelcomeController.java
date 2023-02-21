package com.flightreservation.welcome;

import com.flightreservation.dto.User;

public class WelcomeController implements WelcomeViewControllerCallBack,WelcomeModelControllerCallBack {
    private WelcomeControllerViewCallBack welcomeView;
    private WelcomeControllerModelCallBack welcomeModel;
    public WelcomeController(WelcomeView welcomeView) {
        this.welcomeView =welcomeView;
        welcomeModel = new WelcomeModel(this);
    }

    public void signUp(String userName, String passWord) {
        welcomeModel.signUp(userName,passWord);
    }

    public void userAddedSuccessfully(User user) {
        welcomeView.userAddedSuccessfully(user);
    }

    public void userAddedFailed() {
        welcomeView.userAddedFailed("The UserName Was Already Taken By Some Body Try Some Other");
    }

    public void checkAdminLogin(String userName, String passWord) {
        welcomeModel.checkAdminLogin(userName,passWord);
    }

    public void checkAdminLoginSucessful() {
        welcomeView.checkAdminSuccessful();
    }

    public void checkAdminLoginFailed() {
        welcomeView.checkAdminFailed();
    }

    public void checkUserLogin(String userName, String passWord) {
        welcomeModel.checkUserLogin(userName,passWord);
    }

    public void userLoginSuccesful(User user) {
        welcomeView.userLoginSuccessful(user);
    }

    public void userLoginFailed() {
        welcomeView.userLoginFailed("Login With Correct User Name And Password");
    }
}
