package com.carparkingsystem.managadmin;

import com.carparkingsystem.dto.CarParked;

import java.util.ArrayList;

public interface ManageControllerModelCallBack {
    ArrayList<CarParked> carParkedDetails();

    boolean registration(String placeName, int noOfParkingSlots, int charges);

    boolean alreadyRegistered();

    String[][] viewParkedPlots();
}
