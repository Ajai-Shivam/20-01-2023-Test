package com.flightreservation.login.userlogin;

import com.flightreservation.dto.BookingDate;
import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;

import java.util.ArrayList;

public interface UserLoginModelControllerCallBack {
    void showFlightsAvailablity(ArrayList<Flight> flights);

    void showTatkal(BookingDate bookingDate);

    void dontShowTatkal(BookingDate bookingDate);

    void invalidDate();

    void ticketBookedSuccessfully(int noOfTickets, int userID, int flightID, BookingDate bookingDate, String economy, int i, int bookinId);

    void passengerAddedSuccessfully();

    void CancelTicketSuccessful();

    void CancelTicketFailed();

    void showticketBooked(ArrayList<TicketBook> ticketBooked, ArrayList<Passenger> passengers);
}
