package com.carparkingsystem.adminlogin;

import com.carparkingsystem.repository.Repository;

public class AdminLoginModel implements AdminControllerModelCallBack {
    private AdminModelControllerCallBack adminLoginController;
    private Repository instance;
    public AdminLoginModel(AdminLoginController adminLoginController) {
        this.adminLoginController = adminLoginController;
        this.instance = Repository.getInstance();
    }

    public void checkValidAdmin(String userName, String passWord) {
        boolean isValidAdmin = instance.checkValidAdmin(userName, passWord);
        if(isValidAdmin){
            adminLoginController.checkValidAdminResult("Admin Login Successful");
        }else{
            adminLoginController.invalidAdmin("Invalid Credentials !");
        }
    }

}
