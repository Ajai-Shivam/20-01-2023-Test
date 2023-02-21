package com.flightreservation.login.userlogin;

import com.flightreservation.dto.BookingDate;
import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;

import java.util.ArrayList;

public class UserLoginController implements UserLoginViewControllerCallBack,UserLoginModelControllerCallBack{
    private UserLoginControllerViewCallBack userLoginView;
    private UserLoginControllerModelCallBack userLoginModel;
    public UserLoginController(UserLoginView userLoginView) {
        this.userLoginView =userLoginView;
        userLoginModel = new UserLoginModel(this);
    }

    public void showFlightsAvailablity(ArrayList<Flight> flightsAvailable) {
        userLoginView.showFLightsAvailablity(flightsAvailable);
    }

    public void CheckFlightAvailabily(String fromLocation, String toLocation) {
        userLoginModel.CheckFlightAvailabily(fromLocation,toLocation);
    }

    public void checkTatkal(int date, int month, int year) {
        userLoginModel.checkTatkal(date,month,year);
    }

    public void showTatkal(BookingDate bookingDate) {
        userLoginView.showTatkal(bookingDate);
    }

    public void invalidDate() {
        userLoginView.invalidDate();
    }

    public void addEconomytickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate) {
        userLoginModel.addEconomytickets(noOfTickets, userID, flightID,bookingDate);
    }

    public void dontShowTatkal(BookingDate bookingDate) {
        userLoginView.dontShowTatkal(bookingDate);
    }

    public void ticketBookedSuccessfully(int noOfTickets, int userID, int flightID, BookingDate bookingDate, String economy, int ticketprice, int bookinId) {
        userLoginView.ticketBookedSuccessfully(noOfTickets, userID, flightID, bookingDate,economy,ticketprice,bookinId);
    }

    public void addpassengers(int userID, int bookinId, int flightID, String passengersName, String passPortNumber, String sex, String fLightClass, int ticketprice, String date, String from, String to) {
        userLoginModel.addpassengers(userID, bookinId, flightID, passengersName, passPortNumber, sex, fLightClass, ticketprice, date, from, to);
    }

    public void passengerAddedSuccessfully() {
        userLoginView.passengerAddedSuccessfully("Passenger Added Successfully");
    }

    public void addBusinesstickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate) {
        userLoginModel.addBusinesstickets(noOfTickets, userID, flightID, bookingDate);
    }

    public void addTatkaltickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate) {
        userLoginModel.addTatkaltickets(noOfTickets, userID, flightID, bookingDate);
    }

    public void cancelTicket(int userID) {
        userLoginModel.cancelTicket(userID);
    }

    public void CancelTicketSuccessful() {
        userLoginView.CancelTicketSuccessful();
    }

    public void CancelTicketFailed() {
        userLoginView.CancelTicketFalied();
    }

    public void GetticketBooked(int userID) {
        userLoginModel.getTicketBooked(userID);
    }

    public void showticketBooked(ArrayList<TicketBook> ticketBooked, ArrayList<Passenger> passengers) {
        userLoginView.showTicketBooked(ticketBooked,passengers);
    }
}
