package com.flightreservation.dto;

public class Flight {
    private int flightId;
    private String flightName;
    private int noOfSeatEconomy;
    private int noOfSeatBusiness;
    private int noOfSeatTatkal;
    private String from;
    private String to;
    private String pilotName;
    private int economyTicketPrice;
    private int businessTicketPrice;
    private int tatkalTicketPrice;

    public int getTatkalTicketPrice() {
        return tatkalTicketPrice;
    }

    public void setTatkalTicketPrice(int tatkalTicketPrice) {
        this.tatkalTicketPrice = tatkalTicketPrice;
    }

    public Flight(int flightId, String flightName, int noOfSeatEconomy, int noOfSeatBusiness, int noOfSeatTatkal, String from, String to, String pilotName, int economyTicketPrice, int businessTicketPrice, int tatkalTicketPrice) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.noOfSeatEconomy = noOfSeatEconomy;
        this.noOfSeatBusiness = noOfSeatBusiness;
        this.noOfSeatTatkal = noOfSeatTatkal;
        this.from = from;
        this.to = to;
        this.pilotName = pilotName;
        this.economyTicketPrice = economyTicketPrice;
        this.businessTicketPrice = businessTicketPrice;
        this.tatkalTicketPrice = tatkalTicketPrice;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public int getNoOfSeatEconomy() {
        return noOfSeatEconomy;
    }

    public void setNoOfSeatEconomy(int noOfSeatEconomy) {
        this.noOfSeatEconomy = noOfSeatEconomy;
    }

    public int getNoOfSeatBusiness() {
        return noOfSeatBusiness;
    }

    public void setNoOfSeatBusiness(int noOfSeatBusiness) {
        this.noOfSeatBusiness = noOfSeatBusiness;
    }

    public int getNoOfSeatTatkal() {
        return noOfSeatTatkal;
    }

    public void setNoOfSeatTatkal(int noOfSeatTatkal) {
        this.noOfSeatTatkal = noOfSeatTatkal;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public int getEconomyTicketPrice() {
        return economyTicketPrice;
    }

    public void setEconomyTicketPrice(int economyTicketPrice) {
        this.economyTicketPrice = economyTicketPrice;
    }

    public int getBusinessTicketPrice() {
        return businessTicketPrice;
    }

    public void setBusinessTicketPrice(int businessTicketPrice) {
        this.businessTicketPrice = businessTicketPrice;
    }
}
