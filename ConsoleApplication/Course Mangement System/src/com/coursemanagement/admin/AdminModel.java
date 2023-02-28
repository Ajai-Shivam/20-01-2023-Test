package com.coursemanagement.admin;

import com.coursemanagement.repository.Repository;

public class AdminModel implements AdminControllerModelCallBack{
    private AdminModelControllerCallBack adminController;
    private Repository instance;
    public AdminModel(AdminController adminController) {
        this.adminController = adminController;
        instance = Repository.getInstance();
    }
    public void checkValidAdmin(String userName, String passWord) {
        boolean validAdmin = instance.checkValidAdmin(userName,passWord);
        if (validAdmin){
            adminController.ValidAdmin();
        }else{
            adminController.invalidAdmin();
        }
    }
}
