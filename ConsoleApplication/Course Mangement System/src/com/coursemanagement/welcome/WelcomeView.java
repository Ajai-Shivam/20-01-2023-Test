package com.coursemanagement.welcome;

import com.coursemanagement.admin.AdminView;
import com.coursemanagement.login.UserLoginView;

import java.util.Scanner;

public class WelcomeView {

    public WelcomeView() {
        welcomeDisplay();
    }
    private Scanner sc = new Scanner(System.in);
    private AdminView adminView;
    private UserLoginView userLoginView;

    public void welcomeDisplay() {
        System.out.println("\n\t<---- Hogward's Course Management  ---->");
        System.out.println();
        System.out.println("Press 1 --> Admin Login");
        System.out.println("Press 2 --> Student Login");
        System.out.println("Press 0 --> Exit");
        int option = sc.nextInt();
        switch (option){
            case 0 :
                System.out.println("Thank You For Visiting Hogward's Course Management");
            case 1:
                adminView = new AdminView(this);
                adminView.adminDisplay();
            case 2:
                userLoginView = new UserLoginView(this);
                userLoginView.userloginDisplay();
            default:
                System.out.println("Give A Valid Option !");
                welcomeDisplay();
        }
    }

    public static void main(String[] args) {
        WelcomeView welcomeView = new WelcomeView();
    }
}
