package com.flightreservation.login.adminlogin;

import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;

import java.util.ArrayList;

public interface AdminLoginModelControllerCallBack {
    void showFlightsDetails(ArrayList<Flight> flightsDetails);

    void showPassengersDetails(ArrayList<Passenger> passengersDetails);

    void showTicketBookings(ArrayList<TicketBook> ticketBookingDetails);

    void flightAddedSuccessfully();

    void deletedSuccessfully(int flightID);

    void deletedFailed(int flightID);
}
