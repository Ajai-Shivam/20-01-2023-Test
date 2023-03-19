package com.carparkingsystem.userregisteration;

public class RegistrationController implements RegModelControllerCallBack,RegViewControllerCallBack{
    private RegControllerViewCallBack registrationView;
    private RegModelControllerCallBack registrationModel;

    public RegistrationController(RegistrationView registrationView) {
        this.registrationModel = new RegistrationModel(this);
        this.registrationView = registrationView;
    }

    public String userRegistration(String name, String mail, long phoneNumber, String password, String carNumebr, String carModel) {
        return registrationModel.userRegistration(name, mail, phoneNumber, password, carNumebr, carModel);
    }
}
