package com.carparkingsystem.adminlogin;

public class AdminLoginController implements AdminModelControllerCallBack,AdminViewControllerCallBack{
    private AdminControllerViewCallBack adminLoginView;
    private AdminLoginModel adminLoginModel;
    public AdminLoginController(AdminLoginView adminLoginView) {
        this.adminLoginView = adminLoginView;
        adminLoginModel = new AdminLoginModel(this);
    }

    public void checkValidAdmin(String userName, String passWord) {
        adminLoginModel.checkValidAdmin(userName, passWord);
    }

    public void checkValidAdminResult(String s) {
        adminLoginView.checkValidAdminResult(s);
    }

    public void invalidAdmin(String s) {
        adminLoginView.invalidAdmin(s);
    }
}