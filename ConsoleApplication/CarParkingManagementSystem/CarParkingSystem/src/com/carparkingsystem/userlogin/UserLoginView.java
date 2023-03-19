package com.carparkingsystem.userlogin;

import com.carparkingsystem.bookplot.BookView;
import com.carparkingsystem.userregisteration.RegistrationController;
import com.carparkingsystem.userregisteration.RegistrationView;
import com.carparkingsystem.welcome.WelcomeView;

import java.util.Scanner;

public class UserLoginView implements UserLoginControllerViewCallBack{
    private WelcomeView welcomeView;
    private UserLoginViewControllerCallBack userLoginController;
    private BookView bookView;
    public UserLoginView(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        userLoginController = new UserLoginController(this);
    }
    private Scanner sc = new Scanner(System.in);
    private RegistrationView registrationView;

    public UserLoginView(RegistrationView registrationView) {
        this.registrationView = registrationView;
        this.userLoginController = new UserLoginController(this);
    }

    public void userLoginDisplay() {
        System.out.println("<---- User Login ---->\n");
        System.out.print("Enter Username : ");
        String userName = sc.next();
        System.out.print("\nEnter Password : ");
        String passWord = sc.next();
        System.out.println("Press 1 --> Conform");
        System.out.println("Press 0 --> Back");
        int option = sc.nextInt();
        switch (option){
            case 1 :
                if(userLoginController.checkValidUser(userName,passWord)){
                    System.out.println("User Login Successful");
                    bookView = new BookView(this);
                    bookView.bookDisplay();
                }else{
                    System.out.println("Give A Valid Credentials");
                    userLoginDisplay();
                }
            case 0 :
                welcomeView.welcomeDisplay();
        }
    }

}
