package com.carparkingsystem.userregisteration;

import com.carparkingsystem.userlogin.UserLoginView;
import com.carparkingsystem.welcome.WelcomeView;

import java.util.Scanner;

public class RegistrationView implements RegControllerViewCallBack{
    private RegViewControllerCallBack registrationController;
    private WelcomeView welcomeView;
    private Scanner sc = new Scanner(System.in);
    public RegistrationView(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        registrationController = new RegistrationController(this);
    }

    public void registrationDisplay() {
        System.out.println("\t<---- Registration Menu --->");
        System.out.print("\nEnter Unique Username : ");
        String name  = sc.next();
        System.out.print("\nEnter Email : ");
        String mail = sc.next();
        System.out.print("\nEnter Phone Number : ");
        long phoneNumber = sc.nextLong();
        System.out.print("\nEnter Your Password : ");
        String Password = sc.next();
        System.out.print("\nEnter Your Car Number :");
        String carNumebr = sc.next();
        System.out.print("\nEnter Your Car Model :");
        String carModel = sc.next();
        System.out.println("Press 1--> conform");
        System.out.println("Press 0--> Back");
        int option = sc.nextInt();
        if(option ==0){
            welcomeView.welcomeDisplay();
        } else if (option == 1) {
            String result = registrationController.userRegistration(name,mail,phoneNumber,Password,carNumebr,carModel);
            if(result.equals("userName Exists Try Different Name")){
                System.out.println(result);
                System.out.println("Press 1 --> Go For Registration");
                System.out.println("Press 0 --> Exit");
                int op = sc.nextInt();

                if(op == 1){
                    registrationDisplay();
                }else{
                    System.out.println("ThankYou For Visiting ELITE PARKING SERVICES");
                }
            }
            else {
                System.out.println(result);
                System.out.println("Redirecting Too User Login Page ...");
                UserLoginView userLoginView = new UserLoginView(this);
                userLoginView.userLoginDisplay();

            }
        }
    }
}
