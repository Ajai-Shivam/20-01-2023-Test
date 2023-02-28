package com.coursemanagement.login;

import com.coursemanagement.login.enroll.EnrollView;
import com.coursemanagement.welcome.WelcomeView;

import java.util.Scanner;

public class UserLoginView implements UserLoginControllerViewCallBack{
    private WelcomeView welcomeView;
    private UserLoginViewControllerCallBack userLoginController;
    private EnrollView enrollView;
    private Scanner sc = new Scanner(System.in);

    public UserLoginView(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        userLoginController = new UserLoginController(this);
    }

    public void userloginDisplay() {
        System.out.printf("\n\t<---- Student Login ---->");
        System.out.print("Enter Username : ");
        String userName = sc.next();
        System.out.print("\nEnter Password : ");
        String passWord = sc.next();
        System.out.println("Press 1 --> Conform");
        System.out.println("Press 0 --> Back");
        int option = sc.nextInt();
        switch (option){
            case 1 :
                userLoginController.checkValidUser(userName,passWord);
            case 0 :
                welcomeView.welcomeDisplay();
        }
    }
    public void validUser() {
        System.out.printf("Student Login Successful !");
        enrollView = new EnrollView(this);
        enrollView.enrollDisplay();
    }

    public void invalidUser() {
        System.out.println("Invalid Credentials ! Try Different ");
        userloginDisplay();
    }
}
