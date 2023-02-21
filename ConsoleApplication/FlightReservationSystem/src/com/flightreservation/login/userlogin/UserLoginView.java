package com.flightreservation.login.userlogin;

import com.flightreservation.dto.BookingDate;
import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;
import com.flightreservation.welcome.WelcomeView;
import java.util.ArrayList;
import java.util.Scanner;

public class UserLoginView implements UserLoginControllerViewCallBack{
    private int flightID;
    private int userID ;
    private String from;
    private String To;
    private WelcomeView welcomeView;
    private UserLoginViewControllerCallBack userLoginController;
    private Scanner sc = new Scanner(System.in);
    public UserLoginView(WelcomeView welcomeView, int userId) {
         this.userID = userId;
         this.welcomeView = welcomeView;
         userLoginController= new UserLoginController(this);

    }
    public void userLoginDisplay(){
        System.out.println("\n\tLogin");
        System.out.println("----------------------");
        System.out.println("\n1. Book Ticket");
        System.out.println("\n2. Cancel Ticket");
        System.out.println("\n3. Show Tickets");
        System.out.println("\n0. Back");
        System.out.print("\nEnter a Option : ");


        /* Input */
        int option = sc.nextInt();
        switch (option){
            case 0:
                welcomeView.welcomeDisplay();
                break;
            case 1:
                bookTicketsDisplay();
                break;
            case 2:
                cancelTicketsDisplay();
                break;
            case 3:
                userLoginController.GetticketBooked(userID);
                break;
        }
    }

    private void cancelTicketsDisplay() {
        System.out.println("\n\tCancel Tickets");
        userLoginController.cancelTicket(userID);
    }

    private void bookTicketsDisplay() {
        System.out.println("\n\tBook Tickets");
        System.out.println("---------------------------");
        System.out.print("\nEnter From Location :");
        String fromLocation = sc.next();
        this.from =fromLocation;
        System.out.print("\nEnter To Location : ");
        String toLocation = sc.next();
        this.To = toLocation;
        System.out.println("\nPress 1 to Confirm");
        System.out.println("\nPress 0 to back");
        System.out.println("Enter a Option : ");
        int option= sc.nextInt();
        if(option == 0){
            userLoginDisplay();
        }
        else if(option == 1){
            userLoginController.CheckFlightAvailabily(fromLocation,toLocation);
        }

    }

    public void showFLightsAvailablity(ArrayList<Flight> flightsAvailable) {
        if(flightsAvailable.size()==0){
            System.out.println("No Flights Available For Your Request Location");

            System.out.println("Press 0 to Back ");
            System.out.println("Press 9 to Exit ");
            int option = sc.nextInt();
            if (option == 0) {
                userLoginDisplay();
            } else if (option == 1) {
                System.out.println("Thank you For Visiting Kudumbam Airlines");
            }
        }else {
            System.out.println("\n\t Available Flights");
            for (int i = 0; i < flightsAvailable.size(); i++) {
                System.out.println("\nFlight ID : " + flightsAvailable.get(i).getFlightId() + "\tFlight Name : " + flightsAvailable.get(i).getFlightName() + "\tfrom : " + flightsAvailable.get(i).getFrom() + "\tTo : " + flightsAvailable.get(i).getTo() + "\tPilot Name : " + flightsAvailable.get(i).getPilotName() + "\tEconomy Class Ticket Price : " + flightsAvailable.get(i).getEconomyTicketPrice() + "\tBusiness Class Ticket Price : " + flightsAvailable.get(i).getBusinessTicketPrice() + "\tTatkal Class Ticket Price : " + flightsAvailable.get(i).getTatkalTicketPrice());
            }
            System.out.println("\nEnter Flight ID : ");
            int flightID = sc.nextInt();
            this.flightID = flightID;
            System.out.print("\nEnter Date : ");
            int date = sc.nextInt();
            System.out.print("\nEnter Month : ");
            int month = sc.nextInt();
            System.out.print("\nYear : ");
            int year = sc.nextInt();

            System.out.println("Press 1 to Confirm ");
            System.out.println("Press 0 to Back ");
            int option = sc.nextInt();
            if (option == 0) {
                userLoginDisplay();
            } else if (option == 1) {
                userLoginController.checkTatkal(date, month, year);
            }
        }

    }


    public void invalidDate() {
        System.out.println("Invalid Date Try Some Other Date .. ");
        bookTicketsDisplay();
    }

    public void showTatkal(BookingDate bookingDate) {
        System.out.println("\n\tChoose Class");
        System.out.println("\n1. Economy Class");
        System.out.println("\n2. Business Class");
        System.out.println("\n3. Tatkal Class");
        System.out.println("\n0. Back ");
        System.out.print("Enter a Option : ");
        int option = sc.nextInt();
        switch (option){
            case 0:
                userLoginDisplay();
                break;
            case 1:
                System.out.print("\nEnter Number Of Tickets Needed : ");
                int noOfTickets = sc.nextInt();
                userLoginController.addEconomytickets(noOfTickets,userID,flightID,bookingDate);
                System.out.println("\nYour Tickets Were Booked Successfully!");
                System.out.println("\nPress 0 to Back");
                System.out.println("\nPress 9 to Exit");
                int n = sc.nextInt();
                if(n == 0){
                userLoginDisplay();
                }
                else if(n == 9){
                    System.out.println("Thank You For Visiting KUDUBAM Airline");
                }
                break;
            case 2 :
                System.out.print("\nEnter Number Of Tickets Needed : ");
                noOfTickets = sc.nextInt();
                userLoginController.addBusinesstickets(noOfTickets,userID,flightID,bookingDate);
                n = sc.nextInt();
                if(n == 0){
                    userLoginDisplay();
                }
                else if(n == 9){
                    System.out.println("Thank You For Visiting KUDUBAM Airline");
                }
                break;
            case 3:
                System.out.print("\nEnter Number Of Tickets Needed : ");
                noOfTickets = sc.nextInt();
                userLoginController.addTatkaltickets(noOfTickets,userID,flightID,bookingDate);
                n = sc.nextInt();
                if(n == 0){
                    userLoginDisplay();
                }
                else if(n == 9){
                    System.out.println("Thank You For Visiting KUDUBAM Airline");
                }
                break;
            }

        }

    public void dontShowTatkal(BookingDate bookingDate) {
        System.out.println("\n\tChoose Class");
        System.out.println("\n1. Economy Class");
        System.out.println("\n2. Business Class");
        System.out.println("\n0. Back ");
        System.out.print("Enter a Option : ");
        int option = sc.nextInt();
        switch (option){
            case 0:
                userLoginDisplay();
                break;
            case 1:
                System.out.print("\nEnter Number Of Tickets Needed : ");
                int noOfTickets = sc.nextInt();
                userLoginController.addEconomytickets(noOfTickets,userID,flightID, bookingDate);
                System.out.println("\nYour Tickets Were Booked Successfully!");
                System.out.println("\nPress 0 to Back");
                System.out.println("\nPress 9 to Exit");
                int n = sc.nextInt();
                if(n == 0){
                    userLoginDisplay();
                }
                else if(n == 9){
                    System.out.println("Thank You For Visiting KUDUBAM Airline");
                }
                break;
            case 2:
                System.out.print("\nEnter Number Of Tickets Needed : ");
                noOfTickets = sc.nextInt();
                userLoginController.addBusinesstickets(noOfTickets,userID,flightID,bookingDate);
                n = sc.nextInt();
                if(n == 0){
                    userLoginDisplay();
                }
                else if(n == 9){
                    System.out.println("Thank You For Visiting KUDUBAM Airline");
                }
                break;
        }
    }
    public void ticketBookedSuccessfully(int noOfTickets, int userID, int flightID, BookingDate bookingDate, String FLightClass, int ticketprice, int bookinId) {
        System.out.println("Add Passenger Details");
        String date = bookingDate.getDate()+"-"+bookingDate.getMonth()+"-"+bookingDate.getYear();
        for (int i = 0; i < noOfTickets; i++) {
            System.out.print("\nEnter Passengers Name : ");
            String passengersName = sc.next();
            System.out.print("\nEnter Passport Number : ");
            String passPortNumber = sc.next();
            System.out.print("\nSex : ");
            String sex = sc.next();
            userLoginController.addpassengers(userID,bookinId,flightID,passengersName,passPortNumber,sex,FLightClass,ticketprice,date,from,To);
        }
        userLoginController.GetticketBooked(userID);
    }

    public void passengerAddedSuccessfully(String passenger_added_successfully) {
        System.out.println("\n"+passenger_added_successfully);
    }

    public void CancelTicketSuccessful() {
        System.out.println("\nTicket Was Cancelled Successful");
        System.out.println("\nPress 0 to Back");
        System.out.println("\nPress 9 to Exit");
        int n = sc.nextInt();
        if(n == 0){
            userLoginDisplay();
        }
        else if(n == 9){
            System.out.println("Thank You For Visiting KUDUBAM Airline");
        }
    }

    public void CancelTicketFalied() {
        System.out.println("\nYou Have Not Yet Booked Any Tickets || Try to Give A Valid User ID ");
        int n = sc.nextInt();
        if(n == 0){
            cancelTicketsDisplay();
        }
        else if(n == 9){
            System.out.println("Thank You For Visiting KUDUBAM Airline");
        }
    }

    public void showTicketBooked(ArrayList<TicketBook> ticketBooked, ArrayList<Passenger> passengers) {
        if (ticketBooked.size() == 0) {
            System.out.println("You Have Not Booked Any Tickets");

        }else{
        System.out.println("\nKUDUMBAM AIRLINES");
        System.out.println("RECEIPT : ");
        for (TicketBook tt:ticketBooked) {
            System.out.println("\nFLight ID\tFlightName\tBookingID\tFlight Class\tDate\tTotal Tickets\tTotal Amount Paid");
            System.out.println("\n"+tt.getFlightId()+"\t"+tt.getFlightName()+"\t"+tt.getBookingId()+"\t"+tt.getFlightClass()+"\t"+tt.getDate()+"\t"+tt.getTotalTickets()+"\t"+tt.getTotalAmountPaid());
            System.out.println("\nPassengers Details");
            for (int i = 0; i < passengers.size(); i++) {
                if(passengers.get(i).getUserId() == tt.getUserId()) {
                    System.out.println("\nPassenger Name\tSex\tfrom\ttto");
                    System.out.println("\n" + passengers.get(i).getPassengerName() + "\t" +passengers.get(i).getSex()+"\t"+passengers.get(i).getFrom()+"\t"+passengers.get(i).getTo());
                }
            }
        }
    }
        System.out.println("Press 0 to Back ");
        System.out.println("Press 9 to exit ");
        int opiton = sc.nextInt();
        if(opiton == 0){
            userLoginDisplay();
        } else if (opiton == 9) {
            System.out.println("Thank You For Visiting KUDUMBAM Airlines");
        }
    }
}
