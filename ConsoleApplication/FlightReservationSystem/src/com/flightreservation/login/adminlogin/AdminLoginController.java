package com.flightreservation.login.adminlogin;

import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;

import java.util.ArrayList;

public class AdminLoginController implements AdminLoginViewControllerCallBack,AdminLoginModelControllerCallBack{
    private AdminLoginControllerViewCallBack adminLoginView;
    private AdminLoginControllerModelCallBack adminLoginModel;
    public AdminLoginController(AdminLoginView adminLoginView) {
        this.adminLoginView = adminLoginView;
        adminLoginModel = new AdminLoginModel(this);

    }

    public void getFlightsDetails() {
        adminLoginModel.getFlightsDetails();
    }

    public void showFlightsDetails(ArrayList<Flight> flightsDetails) {
        adminLoginView.showFlightsDetails(flightsDetails);
    }

    public void getPassengersDetails() {
        adminLoginModel.getPassengersDetails();
    }

    public void showPassengersDetails(ArrayList<Passenger> passengersDetails) {
        adminLoginView.showPassengersDetails(passengersDetails);
    }

    public void getTicketBookings() {
        adminLoginModel.getTicketBookings();
    }

    public void showTicketBookings(ArrayList<TicketBook> ticketBookingDetails) {
        adminLoginView.showTicketBookingsDetails(ticketBookingDetails);
    }

    public void addFlight(String flightName, int ecoTicket, int busiTicket, int tatkalTicket, String fromLocation, String toLocation, String pilotName, int ecoTicketPrice, int busiTicketPrice, int tatTicketPrice) {
        adminLoginModel.addFlight(flightName, ecoTicket, busiTicket, tatkalTicket, fromLocation, toLocation, pilotName, ecoTicketPrice, busiTicketPrice, tatTicketPrice);
    }

    public void flightAddedSuccessfully() {
        adminLoginView.flightAddedSuccesfully();
    }

    public void deleteFlight(int flightID) {
        adminLoginModel.deleteFlight(flightID);
    }

    public void deletedSuccessfully(int flightID) {
        adminLoginView.DeletedSucessfully(flightID);
    }

    public void deletedFailed(int flightID) {
        adminLoginView.deletedFailed(flightID);
    }
}
