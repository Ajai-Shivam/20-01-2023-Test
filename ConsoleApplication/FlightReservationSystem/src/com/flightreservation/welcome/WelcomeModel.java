package com.flightreservation.welcome;

import com.flightreservation.dto.User;
import com.flightreservation.repository.AirlinesRepository;

public class WelcomeModel implements WelcomeControllerModelCallBack {
    private WelcomeModelControllerCallBack welcomeController;
    private AirlinesRepository Instance;

    public WelcomeModel(WelcomeController welcomeController) {
        this.welcomeController = welcomeController;
        Instance = AirlinesRepository.getInstance();
    }

    public void signUp(String userName, String passWord) {
        User user = Instance.addUser(userName,passWord);
        if(user!=null){
            welcomeController.userAddedSuccessfully(user);
        }else{
            welcomeController.userAddedFailed();
        }
    }

    public void checkAdminLogin(String userName, String passWord) {
        boolean adminCheck = Instance.checkAdminLogin(userName,passWord);
        if(adminCheck){
            welcomeController.checkAdminLoginSucessful();
        }else{
            welcomeController.checkAdminLoginFailed();
        }
    }

    public void checkUserLogin(String userName, String passWord) {
        User user= Instance.checkUserLogin(userName,passWord);
        if(user!=null){
            welcomeController.userLoginSuccesful(user);
        }else{
            welcomeController.userLoginFailed();
        }

    }
}
