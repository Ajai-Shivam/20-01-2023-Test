package com.flightreservation.login.adminlogin;

import com.flightreservation.dto.Flight;
import com.flightreservation.dto.Passenger;
import com.flightreservation.dto.TicketBook;
import com.flightreservation.repository.AirlinesRepository;

import java.util.ArrayList;

public class AdminLoginModel implements AdminLoginControllerModelCallBack {
    private AdminLoginModelControllerCallBack adminLoginController;
    private AirlinesRepository airlinesRepository;
    public AdminLoginModel(AdminLoginController adminLoginController) {
        this.adminLoginController = adminLoginController;
    }

    public void getFlightsDetails() {
        airlinesRepository = AirlinesRepository.getInstance();
        ArrayList<Flight> flightsDetails = airlinesRepository.getFlightsDetails();
        adminLoginController.showFlightsDetails(flightsDetails);
    }

    public void getPassengersDetails() {
        airlinesRepository = AirlinesRepository.getInstance();
        ArrayList<Passenger> passengersDetails = airlinesRepository.getPassengersDetails();
        adminLoginController.showPassengersDetails(passengersDetails);
    }

    public void getTicketBookings() {
        airlinesRepository = AirlinesRepository.getInstance();
        ArrayList<TicketBook> ticketBookingDetails = airlinesRepository.getTicketBookingsDetails();
        adminLoginController.showTicketBookings(ticketBookingDetails);

    }
    public void addFlight(String flightName, int ecoTicket, int busiTicket, int tatkalTicket, String fromLocation, String toLocation, String pilotName, int ecoTicketPrice, int busiTicketPrice, int tatTicketPrice) {
        airlinesRepository = AirlinesRepository.getInstance();
        boolean addedSuceesFully = airlinesRepository.addFlight(flightName, ecoTicket, busiTicket, tatkalTicket, fromLocation, toLocation, pilotName, ecoTicketPrice, busiTicketPrice, tatTicketPrice);
        if(addedSuceesFully){
            adminLoginController.flightAddedSuccessfully();
        }
    }

    public void deleteFlight(int flightID) {
        airlinesRepository = AirlinesRepository.getInstance();
        boolean DeletedSuccessfully = airlinesRepository.deleteFlight(flightID);
        if(DeletedSuccessfully){
            adminLoginController.deletedSuccessfully(flightID);
        }else{
            adminLoginController.deletedFailed(flightID);
        }
    }
}
