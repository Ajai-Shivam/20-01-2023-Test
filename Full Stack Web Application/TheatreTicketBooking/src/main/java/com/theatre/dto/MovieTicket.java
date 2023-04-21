package com.theatre.dto;
public class MovieTicket {
    private String username;
    private String screenName;
    private String movieName;
    private String showTiming;
    private String date;
    private int noOfTickets;
    private int ticketNumber;
    private double amount;
    
    
    public MovieTicket(String username, String screenName, String showTiming, String date, int noOfTickets, int ticketNumber, double amount) {
        this.username = username;
        this.screenName = screenName;
        this.showTiming = showTiming;
        this.date = date;
        this.noOfTickets = noOfTickets;
        this.ticketNumber = ticketNumber;
        this.amount = amount;
    }
    
    // Getter methods
    public String getUsername() {
        return username;
    }
    
    public String getScreenName() {
        return screenName;
    }
    
    public String getShowTiming() {
        return showTiming;
    }
    
    public String getDate() {
        return date;
    }
    
    public int getNoOfTickets() {
        return noOfTickets;
    }
    
    public int getTicketNumber() {
        return ticketNumber;
    }
    
    public double getAmount() {
        return amount;
    }
    
    // Setter methods
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
    
    public void setShowTiming(String showTiming) {
        this.showTiming = showTiming;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }
    
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
}
