package com.coursemanagement.login;

public class UserLoginController implements UserLoginViewControllerCallBack,UserLoginModelControllerCallBack{
    private UserLoginControllerViewCallBack userLoginView;
    private UserLoginControllerModelCallBack userLoginModel;
    public UserLoginController(UserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        userLoginModel = new UserLoginModel(this);
    }

    public void checkValidUser(String userName, String passWord) {
        userLoginModel.checkValidUser(userName,passWord);
    }

    public void validUser() {
    }

    public void invalidUser() {
    }
}
