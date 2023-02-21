package com.flightreservation.repository;

import com.flightreservation.dto.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class AirlinesRepository {
   private Admin SingleAdmin ;
   private static AirlinesRepository Instance;
   private ArrayList<User> usersDetails= new ArrayList<>();
   private ArrayList<Flight> flightsDetails = new ArrayList<>();
   private ArrayList<Passenger> passengersDetails = new ArrayList<>();
   private ArrayList<TicketBook> ticketBookingsDetails = new ArrayList<>();

   private AirlinesRepository() {
      defaultInitialisation();
   }

   private void defaultInitialisation() {
      SingleAdmin = new Admin("Admin","Admin");
      usersDetails.add(new User(1,"Ajai","Ajai"));
      flightsDetails.add(new Flight(1000,"chen2coim-airline",20,20,10,"chennai","coimbatore","Ajai",7000,14000,8500));
      flightsDetails.add(new Flight(1001,"coim2chen-airline",20,20,10,"coimbatore","chennai","Vijay",7000,14000,8500));
      flightsDetails.add(new Flight(1002,"Chen2trichy-airline",20,20,10,"chennai","Trichy","Preethi",7000,14000,8500));
      flightsDetails.add(new Flight(1003,"trichy2chen-airline",20,20,10,"Trichy","chennai","Badri",7000,14000,8500));
   }
   public static AirlinesRepository getInstance(){
      if(Instance!=null){
         return Instance;
      }
      Instance= new AirlinesRepository();
      return Instance;
   }

   /* Admin Page */


   public boolean checkAdminLogin(String userName, String passWord) {
      if(userName.equals("Admin") && passWord.equals("Admin"))return true;
      return false;
   }

   public User addUser(String userName, String passWord){
      boolean userNameExist = false;
      for (int i = 0; i < usersDetails.size(); i++) {
         if(usersDetails.get(i).getUserName().equals(userName)){
            userNameExist = true;
            break;
         }
      }
      if(userNameExist){
         return null;
      }
      int userId = usersDetails.get(usersDetails.size()-1).getUserId()+1;
      User newUser = new User(userId,userName,passWord);
      usersDetails.add(newUser);
      return newUser;
   }

   public ArrayList<Flight> getFlightsDetails() {
      return flightsDetails;
   }

   public ArrayList<Passenger> getPassengersDetails() {
      return passengersDetails;
   }

   public ArrayList<TicketBook> getTicketBookingsDetails() {
      return ticketBookingsDetails;
   }

   public boolean addFlight(String flightName, int ecoTicket, int busiTicket, int tatkalTicket, String fromLocation, String toLocation, String pilotName, int ecoTicketPrice, int busiTicketPrice, int tatTicketPrice){
      flightsDetails.add(new Flight(flightsDetails.get(flightsDetails.size()-1).getFlightId()+1,flightName,ecoTicket,busiTicket,tatkalTicket,fromLocation,toLocation,pilotName,ecoTicketPrice,busiTicketPrice,tatTicketPrice));
      return true;
   }

   public boolean deleteFlight(int flightId) {
      for (int i = 0; i < flightsDetails.size(); i++) {
         if(flightsDetails.get(i).getFlightId() == flightId){
            flightsDetails.remove(i);
            return true;
         }
      }
      return false;
   }






   /*-------------------------------------------------------------------*/


   /* Login Page */
   public BookingDate checkValidDate(int date, int month, int year) {
      LocalDate today = LocalDate.now();
      int currentYear = today.getYear();
      int currentMonth = today.getMonth().getValue();
      int currentDate = today.getDayOfMonth();
      BookingDate bookingDate = new BookingDate(date,month,year);
      if(year==currentYear){
         if(month == currentMonth || month == currentMonth+1){
            if(date>currentDate && date<=31){
               return bookingDate;
            }
         }else{
            return null;
         }
      }else{
         return null;
      }
      return null;
   }

   public ArrayList<Flight> checkFlightAvailablity(String fromLocation, String toLocation) {
      ArrayList<Flight> availableFlights = new ArrayList<>();
      for (Flight flights: flightsDetails) {
         if(flights.getFrom().equals(fromLocation) && flights.getTo().equals(toLocation)){
            availableFlights.add(flights);
         }
      }
      return availableFlights;
   }

   public boolean checkTatkal(int date) {
      LocalDate curDate = LocalDate.now();
      if(curDate.getDayOfMonth()+1 == date){
         return true;
      }
      return false;
   }

   public User checkUserLogin(String userName, String passWord) {
      for (int i = 0; i < usersDetails.size(); i++) {
         if(usersDetails.get(i).getUserName().equals(userName) && usersDetails.get(i).getPassWord().equals(passWord)){
            return usersDetails.get(i);
         }
      }
      return null;
   }



   /*------------------------------------------------------------------------------------------------------------*/
   /* TIcket Booking*/
   public int addeconomyTIcket(int noOfTickets, int userID, int flightID, BookingDate bookingDate) {
      int bookingID = 20000;
      if(ticketBookingsDetails.size()!=0){
         bookingID = ticketBookingsDetails.get(ticketBookingsDetails.size()-1).getBookingId()+1;
      }
      User user = null;
      Flight flight = null;
      for (int i = 0; i < usersDetails.size(); i++) {
         if(usersDetails.get(i).getUserId() == userID){
            user  = usersDetails.get(i);
            break;
         }
      }
      for (int i = 0; i < flightsDetails.size(); i++) {
         if(flightsDetails.get(i).getFlightId() == flightID){
            flight = flightsDetails.get(i);
            break;
         }
      }
      String date = bookingDate.getDate()+"-"+bookingDate.getMonth()+"-"+bookingDate.getYear();
              ticketBookingsDetails.add(new TicketBook(userID,flightID,bookingID,user.getUserName(),flight.getFlightName(),"Economy",date,noOfTickets,noOfTickets*7000));
     flight.setNoOfSeatEconomy(flight.getNoOfSeatEconomy()-noOfTickets);
     return bookingID;
   }

   public boolean addPassenger(int userID, int bookinId, int flightID, String passengersName, String passPortNumber, String sex, String fLightClass, int ticketprice, String date, String from, String to) {
      passengersDetails.add(new Passenger(userID, bookinId, flightID, passengersName, passPortNumber, sex, fLightClass, ticketprice, date, from, to));
      return true;
   }

   public int addBusinesstickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate) {
      int bookingID = 20000;
      if(ticketBookingsDetails.size()!=0){
         bookingID = ticketBookingsDetails.get(ticketBookingsDetails.size()-1).getBookingId()+1;
      }
      User user = null;
      Flight flight = null;
      for (int i = 0; i < usersDetails.size(); i++) {
         if(usersDetails.get(i).getUserId() == userID){
            user  = usersDetails.get(i);
            break;
         }
      }
      for (int i = 0; i < flightsDetails.size(); i++) {
         if(flightsDetails.get(i).getFlightId() == flightID){
            flight = flightsDetails.get(i);
            break;
         }
      }
      String date = bookingDate.getDate()+"-"+bookingDate.getMonth()+"-"+bookingDate.getYear();
      ticketBookingsDetails.add(new TicketBook(userID,flightID,bookingID,user.getUserName(),flight.getFlightName(),"Business",date,noOfTickets,noOfTickets*14000));
      flight.setNoOfSeatBusiness(flight.getNoOfSeatBusiness()-noOfTickets);
      return bookingID;
   }

   public int addTatkaltickets(int noOfTickets, int userID, int flightID, BookingDate bookingDate) {
      int bookingID = 20000;
      if(ticketBookingsDetails.size()!=0){
         bookingID = ticketBookingsDetails.get(ticketBookingsDetails.size()-1).getBookingId()+1;
      }
      User user = null;
      Flight flight = null;
      for (int i = 0; i < usersDetails.size(); i++) {
         if(usersDetails.get(i).getUserId() == userID){
            user  = usersDetails.get(i);
            break;
         }
      }
      for (int i = 0; i < flightsDetails.size(); i++) {
         if(flightsDetails.get(i).getFlightId() == flightID){
            flight = flightsDetails.get(i);
            break;
         }
      }
      String date = bookingDate.getDate()+"-"+bookingDate.getMonth()+"-"+bookingDate.getYear();
      ticketBookingsDetails.add(new TicketBook(userID,flightID,bookingID,user.getUserName(),flight.getFlightName(),"Business",date,noOfTickets,noOfTickets*14000));
      flight.setNoOfSeatTatkal(flight.getNoOfSeatTatkal()-noOfTickets);
      return bookingID;
   }

   public boolean cancelTicket(int userID) {
      boolean cancelTicket = false;
      int flightid = 0;
      int noOFTicket =0;
      String Flightclass = "";
      for (int i = 0; i < ticketBookingsDetails.size(); i++) {
         if(ticketBookingsDetails.get(i).getUserId()==userID) {
            noOFTicket = ticketBookingsDetails.get(i).getTotalTickets();
            Flightclass = ticketBookingsDetails.get(i).getFlightClass();
            flightid = ticketBookingsDetails.get(i).getFlightId();
            ticketBookingsDetails.remove(i);
            cancelTicket = true;
            break;
         }
      }
      if(cancelTicket){
         for (int i = 0; i < passengersDetails.size(); i++) {
            if(passengersDetails.get(i).getUserId() == userID){
               passengersDetails.remove(i);
            }
         }
         Flight flight =null;
         for (int i = 0; i < flightsDetails.size(); i++) {
            if(flightid == flightsDetails.get(i).getFlightId()){
               flight = flightsDetails.get(i);
               break;
            }
         }
         if(Flightclass.equals("Economy")){
            flight.setNoOfSeatEconomy( flight.getNoOfSeatEconomy()+noOFTicket);
         } else if (Flightclass.equals("Business")) {
            flight.setNoOfSeatBusiness(flight.getNoOfSeatBusiness()+noOFTicket);
         } else if (Flightclass.equals("Tatkal")) {
            flight.setNoOfSeatTatkal(flight.getNoOfSeatTatkal()+noOFTicket);
         }
      }

      return cancelTicket;
   }

   public ArrayList<TicketBook> getTicketBooked(int userID) {
      ArrayList<TicketBook> ticketBooks =new ArrayList<>();
      for (int i = 0; i < ticketBookingsDetails.size(); i++) {
         if(ticketBookingsDetails.get(i).getUserId() == userID){
            ticketBooks.add(ticketBookingsDetails.get(i));
         }
      }
      return ticketBooks;
   }

   public ArrayList<Passenger> getPassengerBooking(int userID) {
      ArrayList<Passenger> passengers = new ArrayList<>();
      for (int i = 0; i < passengersDetails.size(); i++) {
         if(passengersDetails.get(i).getUserId()==userID){
            passengers.add(passengersDetails.get(i));
         }
      }
      return passengers;
   }
   /*------------------------------------------------------------------------------------------------------------*/
}
