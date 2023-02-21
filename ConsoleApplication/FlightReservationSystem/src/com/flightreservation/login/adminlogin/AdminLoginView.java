package com.flightreservation.login.adminlogin;

import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;
import com.flightreservation.welcome.WelcomeView;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminLoginView implements AdminLoginControllerViewCallBack{
    private WelcomeView welcomeView;
    private AdminLoginViewControllerCallBack adminLoginController;
    private Scanner sc = new Scanner(System.in);


    public AdminLoginView(WelcomeView welcomeView) {
        this.welcomeView = welcomeView;
        adminLoginController = new AdminLoginController(this);
    }

    public void adminLoginDisplay() {
        System.out.println("\n\tAdmin");
        System.out.println("----------------------");
        System.out.println("\n1. Fights Details");
        System.out.println("\n2. Passengers Details");
        System.out.println("\n3. Booking Details");
        System.out.println("\n4. Manage Flight");
        System.out.println("\n0. Back");
        System.out.print("\nEnter a Option : ");


        /* Input */
        int option = sc.nextInt();
        switch (option) {
            case 0:
                welcomeView.welcomeDisplay();
                break;
            case 1:
                adminLoginController.getFlightsDetails();
                System.out.println("\n Press 0 to Go Back");
                System.out.println("\n Press 9 to Exit ");
                System.out.print("\nEnter a option : ");
                int n = sc.nextInt();
                if(n==0){
                    adminLoginDisplay();
                }
                else{
                    System.out.println("Thank You Visting KUDUBAM Airlines");
                }
                break;
            case 2:
                adminLoginController.getPassengersDetails();
                System.out.println("\n Press 0 to Go Back");
                System.out.println("\n Press 9 to Exit ");
                System.out.print("\nEnter a option : ");
                n = sc.nextInt();
                if(n==0){
                    adminLoginDisplay();
                }
                else{
                    System.out.println("Thank You Visting KUDUBAM Airlines");
                }
                break;
            case 3:
                adminLoginController.getTicketBookings();
                System.out.println("\n Press 0 to Go Back");
                System.out.println("\n Press 9 to Exit ");
                System.out.print("\nEnter a option : ");
                n = sc.nextInt();
                if(n==0){
                    adminLoginDisplay();
                }
                else{
                    System.out.println("Thank You Visting KUDUBAM Airlines");
                }
                break;
            case 4:
                System.out.println("\n\tManage Flights");
                System.out.println("\n1. Add Flight");
                System.out.println("\n2. Delete Flight");
                System.out.println("\n0. Back");
                System.out.print("\nEnter a Option : ");
                /* Input */
                short manageFlightOption =  sc.nextShort();
                if(manageFlightOption == 1){
                   addflightDisplay();
                }else if(manageFlightOption == 2){
                   deleteFlightDisplay();
                } else if (manageFlightOption == 0) {
                    adminLoginDisplay();
                }

                break;
        }
    }


    public void addflightDisplay(){
        System.out.println("\n\tEnter Flight Details");
        System.out.print("\nFlight Name : ");
        String flightName = sc.next();
        System.out.print("\nNo of Economy Class Seats : ");
        int EcoTicket = sc.nextInt();
        System.out.print("\nNo of Business Class Seats : ");
        int busiTicket = sc.nextInt();
        System.out.print("\nNo of Tatkal Class Seats : ");
        int tatkalTicket = sc.nextInt();
        System.out.println("\nFrom : ");
        String fromLocation = sc.next();
        System.out.print("\nTo : ");
        String toLocation = sc.next();
        System.out.print("\nPilot Name : ");
        String pilotName = sc.next();
        System.out.print("\nEconomy Ticket Price : ");
        int EcoTicketPrice = sc.nextInt();
        System.out.print("\nBusiness Ticket Price : ");
        int busiTicketPrice = sc.nextInt();
        System.out.print("\nTatkal Ticket Price : ");
        int tatTicketPrice = sc.nextInt();
        adminLoginController.addFlight(flightName,EcoTicket,busiTicket,tatkalTicket,fromLocation,toLocation,pilotName,EcoTicketPrice,busiTicketPrice,tatTicketPrice);
    }

    private void deleteFlightDisplay() {
        System.out.println("\nEnter The Flight ID To Delete The Existing Flight : ");
        int flightID = sc.nextInt();
        adminLoginController.deleteFlight(flightID);
    }

    public void showFlightsDetails(ArrayList<Flight> flightsDetails) {
        System.out.println("\nFlightID\tFlight Name\t\tNo Of Economy Seat\tNo Of Business Seat\tNo Of Tatkal Seat\tFrom\tTo\tPilot Name\tEconomy Ticket Price\tBussiness Ticket Price\tTatkal Ticket Price");
        for (Flight flight: flightsDetails) {
            System.out.println("\n"+flight.getFlightId()+"\t"+flight.getFlightName()+"\t"+flight.getNoOfSeatEconomy()+"\t"+flight.getNoOfSeatBusiness()+"\t"+flight.getNoOfSeatTatkal()+"\t"+flight.getPilotName()+"\t"+flight.getEconomyTicketPrice()+"\t"+flight.getBusinessTicketPrice()+"\t"+flight.getTatkalTicketPrice());
        }
    }

    public void showPassengersDetails(ArrayList<Passenger> passengersDetails) {
        if(passengersDetails.size()==0){
            System.out.println("No Passenger Are Booked Tickets Till Now !");
        }else{
            System.out.println("\nUser ID\tBookingID\tPassenger Name\tPassport Number\tSex\tFlightId\tFlight Class\tTicket Price\tDate\tFrom\tTo");
            for (Passenger passenger:passengersDetails) {
                System.out.println("\n"+passenger.getUserId()+"\t"+passenger.getBookingId()+"\t"+passenger.getPassengerName()+"\t"+passenger.getPassPortNumber()+"\t"+passenger.getSex()+"\t"+passenger.getFlightId()+"\t"+passenger.getFlightClass()+"\t"+passenger.getTicketPrice()+"\t"+passenger.getDate()+"\t"+passenger.getFrom()+"\t"+passenger.getTo());
            }
        }
    }

    public void showTicketBookingsDetails(ArrayList<TicketBook> ticketBookingDetails) {
        if(ticketBookingDetails.size()==0){
            System.out.println("Tickets Are Not Yet Booked Till Now !");
        }else{
            System.out.println("\nUser ID\tBookingID\tUser Name\tFlight ID\tFlight Name\tFlight Class\tFlight Class\tNo Of Tickets\tTotal Amount Paid");
            for (TicketBook ticketBook: ticketBookingDetails) {
                System.out.println("\n"+ticketBook.getUserId()+"\t"+ticketBook.getBookingId()+"\t"+ticketBook.getUserName()+"\t"+ticketBook.getFlightId()+"\t"+ticketBook.getFlightName()+"\t"+ticketBook.getFlightClass()+"\t"+ticketBook.getTotalTickets()+"\t"+ticketBook.getTotalAmountPaid());
            }
        }
    }

    public void flightAddedSuccesfully() {
        System.out.println("\nFlight Was Added Successfully");
        System.out.println("\nPress 0 to Back ");
        System.out.println("\nPress 9 to Exit");
        int option = sc.nextInt();
        if(option==0){
            adminLoginDisplay();
        }
        else{
            System.out.println("Thank You Visting KUDUBAM Airlines");
        }
    }

    public void DeletedSucessfully(int flightID) {
        System.out.println("\nThe "+flightID+" Was Deleted Successfully");
        System.out.println("\n Press 0 to Go Back");
        System.out.println("\n Press 9 to Exit ");
        int n = sc.nextInt();
        if(n==0){
            adminLoginDisplay();
        }
        else{
            System.out.println("Thank You Visting KUDUBAM Airlines");
        }
    }

    public void deletedFailed(int flightID) {
        System.out.println("The "+flightID+" Was Already Exist . ");
        System.out.println("\n Press 0 to Go Back");
        System.out.println("\n Press 9 to Exit ");
        int n = sc.nextInt();
        if(n==0){
            adminLoginDisplay();
        }
        else{
            System.out.println("Thank You Visting KUDUBAM Airlines");
        }
    }
}
