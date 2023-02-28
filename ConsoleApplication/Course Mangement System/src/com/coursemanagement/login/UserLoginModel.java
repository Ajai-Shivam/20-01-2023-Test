package com.coursemanagement.login;

import com.coursemanagement.repository.Repository;

public class UserLoginModel implements UserLoginControllerModelCallBack{
    private UserLoginModelControllerCallBack userLoginController;
    private Repository instance;
    public UserLoginModel(UserLoginController userLoginController) {
        this.userLoginController = userLoginController;
        instance = Repository.getInstance();
    }
    public void checkValidUser(String userName, String passWord) {
        if(instance.checkValidUser(userName,passWord)){
            userLoginController.validUser();
        }else{
            userLoginController.invalidUser();
        }
    }
}
