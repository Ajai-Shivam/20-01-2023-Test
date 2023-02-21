package com.flightreservation.welcome;

import com.flightreservation.dto.User;
import com.flightreservation.login.adminlogin.AdminLoginView;
import com.flightreservation.login.userlogin.UserLoginView;

import java.util.Scanner;

public class WelcomeView implements WelcomeControllerViewCallBack {
    private  WelcomeViewControllerCallBack welcomeController;
    private AdminLoginView adminLoginView;
    private UserLoginView userLoginView;
    private int userId;
    public WelcomeView() {
        welcomeController = new WelcomeController(this);
        welcomeDisplay();
    }
    public static void main(String[] args) {
        WelcomeView welcome = new WelcomeView();
    }
    private Scanner sc = new Scanner(System.in);

    public void welcomeDisplay(){
        System.out.println("\tWelcome To KUDUMBAM Airlines");
        System.out.println("-------------------------------------");
        System.out.println("\n1. Admin Login");
        System.out.println("\n2. User Login");
        System.out.println("\n3. Sign Up");
        System.out.println("\n0. Exit ");
        System.out.print("\nEnter a option : ");

        /* Input */
        int option = sc.nextInt();
        switch (option){

            case 0 :
                System.out.println("Thank You for Visting KUDUMBAM Airlines");
                break;
                case 1 :
                    adminLoginDisplay();
                    break;
            case 2 :
                userLoginDisplay();
                break;
            case 3 :
                signUpDisplay();
                break;
        }

    }
    /* Admin Login */

    private void adminLoginDisplay(){
        System.out.println("\n\tAdmin Login");
        System.out.println("-----------------------");
        System.out.print("\nEnter UserName : ");
        String userName = sc.next();
        System.out.print("\nEnter PassWord : ");
        String passWord = sc.next();
        System.out.println("\nPress 1 To Confirm");
        System.out.println("\npress 0 to Back");

        /* Input */
        int option = sc.nextInt();
        switch (option){
            case 0:
                welcomeDisplay();
                break;
            case 1:
               welcomeController.checkAdminLogin(userName,passWord);
               break;
        }
    }
    /*------------------------------------------------------------------*/

    /* User Login */


    private void userLoginDisplay(){
        System.out.println("\n\tUser Login");
        System.out.println("-----------------------");
        System.out.print("\nEnter UserName : ");
        String userName = sc.next();
        System.out.print("\nEnter PassWord : ");
        String passWord = sc.next();
        System.out.println("\nPress 1 To Confirm");
        System.out.println("\npress 0 to Back");

        /* Input */
        int option = sc.nextInt();
        switch (option) {
            case 0:
                welcomeDisplay();
                break;
            case 1:
                welcomeController.checkUserLogin(userName,passWord);
        }
    }
    /*--------------------------------------------------------------------------------------------------*/


    /* Sign Up */


    private void signUpDisplay(){
        System.out.println("\n\tSign Up");
        System.out.println("-----------------------");
        System.out.print("\nSet User Name : ");
        String userName = sc.next();
        System.out.print("\nSet Password : ");
        String passWord = sc.next();
        welcomeController.signUp(userName,passWord);

    }

    public void userAddedSuccessfully(User user) {
        System.out.println("\n The User : "+user.getUserName()+" Added Successfully");
        this.userId = user.getUserId();
        userLoginDisplay();
    }

    public void userAddedFailed(String s) {
        System.out.println("\n"+s);
        signUpDisplay();
    }

    public void checkAdminSuccessful() {
        System.out.println("\nAdmin Login Is Successful");
        adminLoginView = new AdminLoginView(this);
        adminLoginView.adminLoginDisplay();
    }

    public void checkAdminFailed() {
        System.out.println("\nYour Admin Login Is Failed ");
        System.out.println("\nPress 0 To Back");
        System.out.println("\nPress 9 To Exit");
        int option = sc.nextInt();
        if(option == 0){
            welcomeDisplay();
        }else if(option == 9) {
            System.out.println("Thank You For Visting KUDUMBAM Airlines");
        }

    }

    public void userLoginFailed(String s) {
        System.out.println("\n"+s);
        System.out.println("\nPress 0 to Back");
        System.out.println("\nPress 9 to Exit");
        System.out.print("Enter a Option : ");
        int option = sc.nextInt();
        if(option == 0){
            welcomeDisplay();
        }
        else{
            System.out.println("Thank You For Visting KUDUBAM Airlines");
        }
    }

    public void userLoginSuccessful(User user) {
        this.userId = user.getUserId();
        System.out.println("\nUser ID : "+user.getUserId()+"\tLogin Successful");
        userLoginView = new UserLoginView(this,userId);
        userLoginView.userLoginDisplay();
    }
}

