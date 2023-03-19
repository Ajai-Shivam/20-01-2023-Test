package com.carparkingsystem.managadmin;

import com.carparkingsystem.adminlogin.AdminLoginView;
import com.carparkingsystem.dto.CarParked;
import com.carparkingsystem.welcome.WelcomeView;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageView implements ManageControllerViewCallBack{
    private AdminLoginView adminLoginView;
    private ManageViewControllerCallBack manageController;
    private Scanner sc = new Scanner(System.in);
    public ManageView(AdminLoginView adminLoginView) {
        this.adminLoginView = adminLoginView;
        manageController = new ManageController(this);
    }

    public void manageDisplay() {
        System.out.println("\n\tManage Parkings");
        System.out.println("Press 1 --> Registration Place");
        System.out.println("Press 2 --> Car Parked Details");
        System.out.println("Press 3 --> View Parking Plot");
        System.out.println("Press 0 --> Go Back");

        int option = sc.nextInt();
        switch (option){
            case 0:
                WelcomeView welcomeView = new WelcomeView();
                welcomeView.welcomeDisplay();
                break;
            case 1:
                if(manageController.alreadyRegistered()) {
                    System.out.println("You Have Registered Already");
                    manageDisplay();
                }else {
                    registration();
                }
                break;
            case 2:
                ArrayList<CarParked> details = manageController.carParkedDetails();
                if(details.size()!=0){
                    System.out.println("Username\tPhone Number\tEmail\tCar Number\tCar Model\tParked Time\tParked Slot");
                    for (int i = 0; i < details.size(); i++) {
                        System.out.println(details.get(i).getUserName()+"\t"+details.get(i).getPhoneNumber()+"\t"+details.get(i).getEmail()+"\t"+details.get(i).getCarNumber()+"\t"+details.get(i).getCarModel()+"\t"+details.get(i).getParkedTime()+"\t"+details.get(i).getParkedSlot());
                    }
                }else{
                    System.out.println("No Cars Was Parked Yet !");
                }
                manageDisplay();
                break;
            case 3:
                String [][] slots = manageController.viewParkedPlots();
                for (int i = 0; i < slots.length; i++) {
                    for (int j = 0; j < slots[i].length; j++) {
                        if(slots[i][j] == null){
                            System.out.print("Slot\t");
                        }
                        else{
                            System.out.print(slots[i][j]+"\t");
                        }
                    }
                    System.out.println();
                }
                manageDisplay();
                break;
        }
    }

    private void registration() {
        System.out.println("<---- Place Registration ---->");
        System.out.print("Enter Place Name : ");
        String placeName = sc.next();
        System.out.print("Enter Number Of Car Parking Slots : ");
        int noOfParkingSlots = sc.nextInt();
        System.out.print("Enter Charges For One Hour : ");
        int charges = sc.nextInt();
        System.out.println("Press 1 --> Conform");
        System.out.println("Press 0 --> Back");
        int option = sc.nextInt();
        if (option == 1){
            if(manageController.registration(placeName,noOfParkingSlots,charges)){
                System.out.println("Registration Successful");
                manageDisplay();
            }
        }else{
            manageDisplay();
        }
    }
}
