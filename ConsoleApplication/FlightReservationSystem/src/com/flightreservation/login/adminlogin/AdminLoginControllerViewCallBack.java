package com.flightreservation.login.adminlogin;

import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;

import java.util.ArrayList;

public interface AdminLoginControllerViewCallBack {
    void showFlightsDetails(ArrayList<Flight> flightsDetails);

    void showPassengersDetails(ArrayList<Passenger> passengersDetails);

    void showTicketBookingsDetails(ArrayList<TicketBook> ticketBookingDetails);

    void flightAddedSuccesfully();

    void DeletedSucessfully(int flightID);

    void deletedFailed(int flightID);
}
