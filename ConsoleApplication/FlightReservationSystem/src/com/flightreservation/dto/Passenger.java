package com.flightreservation.dto;

import java.util.Date;

public class Passenger {
    private int userId;
    private int bookingId;
    private int flightId;
    private String passengerName;
    private String passPortNumber;
    private String Sex;
    private String flightClass;
    private long ticketPrice;
    private String date;
    private String From;
    private String To;

    public Passenger(int userId, int bookingId, int flightId, String passengerName, String passPortNumber, String sex, String flightClass, long ticketPrice, String date, String from, String to) {
        this.userId = userId;
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.passengerName = passengerName;
        this.passPortNumber = passPortNumber;
        Sex = sex;
        this.flightClass = flightClass;
        this.ticketPrice = ticketPrice;
        this.date = date;
        From = from;
        To = to;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassPortNumber() {
        return passPortNumber;
    }

    public void setPassPortNumber(String passPortNumber) {
        this.passPortNumber = passPortNumber;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public long getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }
}
