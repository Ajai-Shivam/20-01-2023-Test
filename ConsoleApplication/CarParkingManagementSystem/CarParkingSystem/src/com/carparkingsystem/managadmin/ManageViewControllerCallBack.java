package com.carparkingsystem.managadmin;

import com.carparkingsystem.dto.CarParked;

import java.util.ArrayList;

public interface ManageViewControllerCallBack {
    boolean alreadyRegistered();

    ArrayList<CarParked> carParkedDetails();

    String[][] viewParkedPlots();

    boolean registration(String placeName, int noOfParkingSlots, int charges);
}
