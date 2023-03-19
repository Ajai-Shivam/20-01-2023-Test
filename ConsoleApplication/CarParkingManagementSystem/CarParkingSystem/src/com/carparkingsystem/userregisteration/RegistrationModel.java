package com.carparkingsystem.userregisteration;

import com.carparkingsystem.repository.Repository;

public class RegistrationModel implements RegModelControllerCallBack{
    private Repository instance;
    private RegModelControllerCallBack registrationController;

    public RegistrationModel(RegistrationController registrationController) {
        this.registrationController  =registrationController;
        instance = Repository.getInstance();
    }

    public String userRegistration(String name, String mail, long phoneNumber, String password, String carNumebr, String carModel) {
        return instance.userRegistration(name, mail, phoneNumber, password, carNumebr, carModel);
    }
}
