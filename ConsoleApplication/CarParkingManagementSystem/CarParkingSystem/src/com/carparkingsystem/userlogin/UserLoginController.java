package com.carparkingsystem.userlogin;

public class UserLoginController implements UserLoginViewControllerCallBack,UserLoginModelControllerCallBack{
    private UserLoginControllerViewCallBack userLoginView;
    private UserLoginControllerModel userLoginModel;
    public UserLoginController(UserLoginView userLoginView) {
        this.userLoginView =  userLoginView;
        this.userLoginModel = new UserLoginModel(this);

    }

    public boolean checkValidUser(String userName, String passWord) {
       return userLoginModel.checkValidUser(userName, passWord);
    }
}
