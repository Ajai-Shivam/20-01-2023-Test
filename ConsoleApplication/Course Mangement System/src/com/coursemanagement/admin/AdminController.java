package com.coursemanagement.admin;

public class AdminController implements AdminViewControllerCallBack,AdminModelControllerCallBack{
    private AdminControllerViewCallBack adminView;
    private AdminControllerModelCallBack adminModel;
    public AdminController(AdminView adminView) {
        this.adminView = adminView;
        adminModel = new AdminModel(this);
    }

    public void checkValidAdmin(String userName, String passWord) {
        adminModel.checkValidAdmin(userName, passWord);
    }

    public void ValidAdmin() {
        adminView.ValidAdmin();
    }

    public void invalidAdmin() {
        adminView.invalidAdmin();
    }
}
