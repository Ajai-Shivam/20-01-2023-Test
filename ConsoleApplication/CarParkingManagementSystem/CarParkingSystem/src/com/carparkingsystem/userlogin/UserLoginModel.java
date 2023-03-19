package com.carparkingsystem.userlogin;

import com.carparkingsystem.repository.Repository;

public class UserLoginModel implements UserLoginControllerModel{
    private UserLoginModelControllerCallBack userLoginController;
    private Repository instance;
    public UserLoginModel(UserLoginController userLoginController) {
        this.userLoginController = userLoginController;
        this.instance = Repository.getInstance();
    }

    public boolean checkValidUser(String userName, String passWord) {
        return instance.checkValidUser(userName,passWord);
    }
}
