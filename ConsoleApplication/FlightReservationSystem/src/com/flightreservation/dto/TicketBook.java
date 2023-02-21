package com.flightreservation.dto;

public class TicketBook {
    private int userId;
    private int flightId;
    private int bookingId;
    private String userName;
    private String flightName;
    private String flightClass;
    private String date;
    private int totalTickets;
    private long totalAmountPaid;

    public TicketBook(int userId, int flightId, int bookingId, String userName, String flightName, String flightClass, String date, int totalTickets, long totalAmountPaid) {
        this.userId = userId;
        this.flightId = flightId;
        this.bookingId = bookingId;
        this.userName = userName;
        this.flightName = flightName;
        this.flightClass = flightClass;
        this.date = date;
        this.totalTickets = totalTickets;
        this.totalAmountPaid = totalAmountPaid;
    }

    public int getUserId() {
        return userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public long getTotalAmountPaid() {
        return totalAmountPaid;
    }

    public void setTotalAmountPaid(long totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }
}
