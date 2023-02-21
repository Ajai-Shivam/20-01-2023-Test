package com.flightreservation.login.userlogin;

import com.flightreservation.dto.BookingDate;

public interface UserLoginControllerModelCallBack {
    void CheckFlightAvailabily(String fromLocation, String toLocation);

    void checkTatkal(int date, int month, int year);

    void addEconomytickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate);

    void addpassengers(int userID, int bookinId, int flightID, String passengersName, String passPortNumber, String sex, String fLightClass, int ticketprice, String date, String from, String to);

    void addTatkaltickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate);

    void addBusinesstickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate);

    void cancelTicket(int userID);

    void getTicketBooked(int userID);
}
