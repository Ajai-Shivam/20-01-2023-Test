package com.carparkingsystem.adminlogin;

public interface AdminModelControllerCallBack {
    void checkValidAdminResult(String admin_login_successful);

    void invalidAdmin(String s);
}
