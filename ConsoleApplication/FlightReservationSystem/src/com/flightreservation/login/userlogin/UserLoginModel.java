package com.flightreservation.login.userlogin;
import com.flightreservation.dto.BookingDate;
import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;
import com.flightreservation.repository.AirlinesRepository;

import java.util.ArrayList;


public class UserLoginModel implements UserLoginControllerModelCallBack{
    private UserLoginModelControllerCallBack userLoginController;
    private AirlinesRepository airlinesRepository ;
    public UserLoginModel(UserLoginController userLoginController) {
        this.userLoginController = userLoginController;
        airlinesRepository = AirlinesRepository.getInstance();
    }
    public void CheckFlightAvailabily(String fromLocation, String toLocation) {
        ArrayList<Flight> flights = airlinesRepository.checkFlightAvailablity(fromLocation, toLocation);
        userLoginController.showFlightsAvailablity(flights);
    }

    public void checkTatkal(int date, int month, int year) {
        BookingDate bookingDate = airlinesRepository.checkValidDate(date, month, year);
        if(bookingDate!=null){
            boolean tatkal = airlinesRepository.checkTatkal(date);
            if(tatkal){
                userLoginController.showTatkal(bookingDate);
            }
            else{
                userLoginController.dontShowTatkal(bookingDate);
            }
        }else{
            userLoginController.invalidDate();
        }
    }
    public void addEconomytickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate) {
        int bookinId = airlinesRepository.addeconomyTIcket(noOfTickets,userID,flightID,bookingDate);
        userLoginController.ticketBookedSuccessfully(noOfTickets,userID,flightID,bookingDate,"Economy",7000,bookinId);
    }
    public void addpassengers(int userID, int bookinId, int flightID, String passengersName, String passPortNumber, String sex, String fLightClass, int ticketprice, String date, String from, String to) {
        boolean added = airlinesRepository.addPassenger(userID, bookinId, flightID, passengersName, passPortNumber, sex, fLightClass, ticketprice, date, from, to);
        if(added){
            userLoginController.passengerAddedSuccessfully();
        }
    }

    public void addBusinesstickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate) {
        int bookinID = airlinesRepository.addBusinesstickets(noOfTickets,userID,flightID,bookingDate);
        userLoginController.ticketBookedSuccessfully(noOfTickets,userID,flightID,bookingDate,"Business",14000,bookinID);
    }

    public void addTatkaltickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate) {
        int bookinID = airlinesRepository.addTatkaltickets(noOfTickets,userID,flightID,bookingDate);
        userLoginController.ticketBookedSuccessfully(noOfTickets,userID,flightID,bookingDate,"Tatkal",8500,bookinID);
    }

    public void cancelTicket(int userID) {
        if(airlinesRepository.cancelTicket(userID)){
            userLoginController.CancelTicketSuccessful();
        }else{
            userLoginController.CancelTicketFailed();
        }
    }

    public void getTicketBooked(int userID) {
        ArrayList<TicketBook> ticketBooked = airlinesRepository.getTicketBooked(userID);
        ArrayList<Passenger> passengers =airlinesRepository.getPassengerBooking(userID);
        userLoginController.showticketBooked(ticketBooked,passengers);
    }
}
