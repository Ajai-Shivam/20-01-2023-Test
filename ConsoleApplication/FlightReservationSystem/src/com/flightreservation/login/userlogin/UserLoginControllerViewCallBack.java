package com.flightreservation.login.userlogin;

import com.flightreservation.dto.BookingDate;
import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;

import java.util.ArrayList;

public interface UserLoginControllerViewCallBack {
    void showFLightsAvailablity(ArrayList<Flight> flightsAvailable);

    void showTatkal(BookingDate bookingDate);

    void invalidDate();

    void dontShowTatkal(BookingDate bookingDate);

    void ticketBookedSuccessfully(int noOfTickets, int userID, int flightID, BookingDate bookingDate, String economy, int ticketprice, int bookinId);

    void passengerAddedSuccessfully(String passenger_added_successfully);

    void CancelTicketSuccessful();

    void CancelTicketFalied();

    void showTicketBooked(ArrayList<TicketBook> ticketBooked, ArrayList<Passenger> passengers);
}
