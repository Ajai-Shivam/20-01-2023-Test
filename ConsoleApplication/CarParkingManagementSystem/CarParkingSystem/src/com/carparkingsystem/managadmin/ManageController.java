package com.carparkingsystem.managadmin;

import com.carparkingsystem.dto.CarParked;

import java.util.ArrayList;
import java.util.Calendar;

public class ManageController implements ManageModelControllerCallBack,ManageViewControllerCallBack{
    private  ManageControllerViewCallBack manageView;
    private ManageControllerModelCallBack manageModel;
    public ManageController(ManageView manageView) {
        this.manageView = manageView;
        manageModel = new ManageModel(this);
    }

    public ArrayList<CarParked> carParkedDetails() {
        return manageModel.carParkedDetails();
    }

    public boolean registration(String placeName, int noOfParkingSlots, int charges) {
       boolean registered =  manageModel.registration(placeName,noOfParkingSlots,charges);
       return registered;
    }


    public boolean alreadyRegistered() {
        if (manageModel.alreadyRegistered()) {
            return true;
        }
        return false;
    }

    public String[][] viewParkedPlots() {
        return manageModel.viewParkedPlots();
    }
}

