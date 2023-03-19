package com.carparkingsystem.managadmin;

import com.carparkingsystem.dto.CarParked;
import com.carparkingsystem.repository.Repository;

import java.util.ArrayList;

public class ManageModel implements ManageControllerModelCallBack{
    private ManageModelControllerCallBack manageController;
    private Repository instance;
    public ManageModel(ManageController manageController) {
        this.manageController = manageController;
        instance = Repository.getInstance();
    }

    public boolean registration(String placeName, int noOfParkingSlots, int charges) {
        boolean registeredOrNot = instance.placeRegistration(placeName,noOfParkingSlots,charges);
        return registeredOrNot;
    }

    public boolean alreadyRegistered() {
        if(instance.alreadyRegistered()) {
            return true;
        }
        return false;
    }

    public ArrayList<CarParked> carParkedDetails() {
        ArrayList<CarParked> details = instance.carPrkedDetails();
        return details;
    }

    public String[][] viewParkedPlots() {
        return instance.getParkedPlots();
    }
}
