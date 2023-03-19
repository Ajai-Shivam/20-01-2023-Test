package com.carparkingsystem.adminlogin;

import com.carparkingsystem.managadmin.ManageView;
import com.carparkingsystem.welcome.WelcomeView;

import java.util.Scanner;

public class AdminLoginView implements AdminControllerViewCallBack{
    private WelcomeView welcomeView;
    private AdminViewControllerCallBack adminLoginController;
    private ManageView manageView;
    public AdminLoginView(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        adminLoginController = new AdminLoginController(this);
    }
    private Scanner sc = new Scanner(System.in);
    public void adminLoginDisplay() {
        System.out.println("<---- Admin Login ---->\n");
        System.out.print("Enter Username : ");
        String userName = sc.next();
        System.out.print("\nEnter Password : ");
        String passWord = sc.next();
        System.out.println("Press 1 --> Conform");
        System.out.println("Press 0 --> Back");
        int option = sc.nextInt();
        switch (option){
            case 1 :
                adminLoginController.checkValidAdmin(userName,passWord);
            case 0 :
                welcomeView.welcomeDisplay();
        }
    }

    public void checkValidAdminResult(String s) {
        System.out.println("\n"+s);
        manageView = new ManageView(this);
        manageView.manageDisplay();
    }

    public void invalidAdmin(String s) {
        System.out.println(s);
        System.out.println("Press 1 --> Go Back");
        System.out.println("Press 0 --> Exit");
        int option = sc.nextInt();
        if(option == 1){
            welcomeView.welcomeDisplay();
        }else{
            System.out.println("Thank You For Visiting ELITE PARKING'S SERVICES");
        }
    }
}
