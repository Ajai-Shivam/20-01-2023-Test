package com.carparkingsystem.bookplot;

import com.carparkingsystem.dto.CarParked;
import com.carparkingsystem.userlogin.UserLoginView;

import java.util.Scanner;
import java.util.SortedMap;

public class BookView implements BookControllerViewCallBack{
    private UserLoginView userLoginView;
    private BookViewControllerCallBack bookController;
    private Scanner sc = new Scanner(System.in);
    public BookView(UserLoginView userLoginView) {
        this.bookController = new BookController(this);
        this.userLoginView = userLoginView;
    }
    public void bookDisplay(){
        System.out.println("<---- Booking Display ---->");
        System.out.println("Press 1 --> Book Slot");
        System.out.println("Press 2 --> Check Current Time Price");
        System.out.println("Press 3 --> Drop Slot ");
        System.out.println("Press 0 --> Back");

        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.println("Press 1 --> Book A Slot");
                System.out.println("Press 0 --> Back");
                int book = sc .nextInt();
                if(book == 1){
                    String slotnum =bookController.bookASlot();
                    if(slotnum.equals("No Slots Available ! Sorry For Inconvenience")){
                        System.out.println(slotnum);
                        System.out.println("Thank You Visiting !");
                    }else{
                        System.out.println(slotnum+ " Is Your Slot ");
                    }
                }else{
                    bookDisplay();
                }
                break;
            case 2:
                int amount = bookController.checkCurrentTimePrice();
                System.out.println(amount + "Rs Is The Amount You Have To Pay !");
                System.out.println("Press 1 --> Go Back");
                System.out.println("Press 0 --> Exit");
                int n = sc.nextInt();
                if(n == 1){
                    bookDisplay();
                }else if(n==0){
                    System.out.println("Thank You Visiting !");
                }
                break;
            case 3:
                System.out.println("Are You Sure ? Press 1 To Conform");
                System.out.println("Press 0 --> Go Back");
                int yes = sc.nextInt();
                if(yes == 1){
                    CarParked Bill = bookController.dropSlot();
                    if(Bill == null){
                        System.out.println("U Have Not Parked The Car Yet");
                    }else{
                        System.out.println("You Have Pay Rs."+Bill.getTotalAmountTopay());
                        System.out.println("Pay It in Exit Point ! Thank You For Visiting ELITE PARKING'S SERVICES");
                    }
                } else if (yes == 0) {
                    bookDisplay();
                }
                break;
            case 0:
                userLoginView.userLoginDisplay();
                break;
        }
    }
}
