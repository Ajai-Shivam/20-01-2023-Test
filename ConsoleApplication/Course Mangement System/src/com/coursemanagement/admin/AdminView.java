package com.coursemanagement.admin;

import com.coursemanagement.admin.manage.ManageView;
import com.coursemanagement.welcome.WelcomeView;

import java.util.Scanner;

public class AdminView implements AdminControllerViewCallBack{
    private WelcomeView welcomeView;
    private Scanner sc = new Scanner(System.in);
    private AdminViewControllerCallBack adminController;
    private ManageView manageView;
    public AdminView(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        adminController = new AdminController(this);
    }

    public void adminDisplay() {
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
                adminController.checkValidAdmin(userName,passWord);
            case 0 :
                welcomeView.welcomeDisplay();
        }
    }
    public void ValidAdmin() {
        System.out.println("Admin Login Successful !");
        manageView = new ManageView(this);
        manageView.manageDisplay();
    }

    public void invalidAdmin() {
        System.out.println("Invalid Credentials ! Try Valid One");
        adminDisplay();
    }
}
