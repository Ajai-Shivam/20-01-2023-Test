package com.flightreservation.dto;

public class BookingDate {
    private int Date;
    private int Month;
    private int Year;

    public BookingDate(int date, int month, int year) {
        Date = date;
        Month = month;
        Year = year;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
