package com.carparkingsystem.welcome;

import com.carparkingsystem.adminlogin.AdminLoginView;
import com.carparkingsystem.userlogin.UserLoginView;
import com.carparkingsystem.userregisteration.RegistrationView;

import java.util.Scanner;

public class WelcomeView {
    public static void main(String[] args) {
        WelcomeView welcomeView = new WelcomeView();
    }

    public WelcomeView() {
        welcomeDisplay();
    }
    private AdminLoginView adminLoginView;
    private UserLoginView userLoginView;
    private RegistrationView registrationView;
    private Scanner sc = new Scanner(System.in);
    public void welcomeDisplay(){
        System.out.println("<---- WELCOME TO ELITE PARKING'S SERVICES ---->");
        System.out.println("\nPress 1 --> Admin Login");
        System.out.println("Press 2 --> User Login");
        System.out.println("Press 3 --> New User Registration");
        System.out.println("Press 0 --> Exit");

        int option = sc.nextInt();

        switch (option){
            case 0 :
                System.out.println("Thank You For Visiting ELITE PARKING'S SERVICES");
                break;
            case 1:
                adminLoginView = new AdminLoginView(this);
                adminLoginView.adminLoginDisplay();
                break;
            case 2:
                userLoginView = new UserLoginView(this);
                userLoginView.userLoginDisplay();
                break;
            case 3:
                registrationView = new RegistrationView(this);
                registrationView.registrationDisplay();
                break;
        }

    }
}

