package com.flightreservation.login.adminlogin;

public interface AdminLoginControllerModelCallBack {
    void getFlightsDetails();

    void getPassengersDetails();

    void getTicketBookings();

    void addFlight(String flightName, int ecoTicket, int busiTicket, int tatkalTicket, String fromLocation, String toLocation, String pilotName, int ecoTicketPrice, int busiTicketPrice, int tatTicketPrice);

    void deleteFlight(int flightID);
}
