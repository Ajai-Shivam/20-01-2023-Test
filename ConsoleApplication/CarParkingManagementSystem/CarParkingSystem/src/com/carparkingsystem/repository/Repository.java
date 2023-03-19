package com.carparkingsystem.repository;

import com.carparkingsystem.dto.CarParked;
import com.carparkingsystem.dto.ParkingComplex;
import com.carparkingsystem.dto.User;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class Repository {
    private Repository(){
        userDetails.add(new User("Ajai0","Ajai","Ajai",637428867,"Ajai@gmail.com","TN45 BY4317","BALENO"));
        parkingPlace = new ParkingComplex("ForumMall",20,50);
    }
    private static int row = 0;
    private static int col = 0;
    private static Repository instance;
    private static int userIDGenrator = 1;
    private User userNow;
    private ParkingComplex parkingPlace;
    private ArrayList<CarParked> carParkedDetails = new ArrayList<>();
    private ArrayList<User> userDetails = new ArrayList<>();
    public static Repository getInstance() {
        if(instance!= null){
            return instance;
        }
        instance = new Repository();
        return instance;
    }
    public boolean checkValidAdmin(String userName, String passWord) {
        if(userName.equals("Admin")&& passWord.equals("Admin")){
            return true;
        }
        return false;
    }



    public boolean placeRegistration(String placeName, int noOfParkingSlots, int charges) {
        if(parkingPlace== null){
            parkingPlace = new ParkingComplex(placeName,noOfParkingSlots,charges);
            return true;
        }
        return false;
    }
    public boolean alreadyRegistered() {
        if(parkingPlace != null) {
            return true;
        }
        return false;
    }

    public ArrayList<CarParked> carPrkedDetails() {
        return carParkedDetails;
    }

    public String[][] getParkedPlots() {
       return ParkingComplex.getSlots();
    }

    public boolean checkValidUser(String userName, String passWord) {
        for (int i = 0; i < userDetails.size(); i++) {
            if(userDetails.get(i).getUserName().equals(userName) && userDetails.get(i).getPassword().equals(passWord)){
                this.userNow = userDetails.get(i);
                return true;
            }
        }
        return false;
    }

    public String bookASlot() {
        for (;row<ParkingComplex.getSlots().length;row++){
            for (; col < ParkingComplex.getSlots()[row].length; col++) {
                if(ParkingComplex.getSlots()[row][col]==null){
                    ParkingComplex.getSlots()[row][col] = userNow.getUserName()+userNow.getCarNumber();
                    carParkedDetails.add(new CarParked(userNow,"slot"+row+""+col,row,col));
                    return "slot"+row+""+col;
                }
            }
        }
        return "No Slots Available ! Sorry For Inconvenience";
    }

    public int checkCurrentTimePrice() {
        int hrCharge =  0;
        for (int i = 0; i < carParkedDetails.size(); i++) {
            if(carParkedDetails.get(i).getUserID().equals(userNow.getUserID())){
                Instant currentTime = Instant.now();
                Instant parkedTime = carParkedDetails.get(i).getParkedTime();
                Duration timeElapsed = Duration.between(parkedTime,currentTime);
                long timeDuration = timeElapsed.getSeconds();
                if(timeDuration>=5) {
                    timeDuration/=5;
                   hrCharge= (int)timeDuration * parkingPlace.getChargeForHr();
                   break;
                }else{
                    break;
                }
                }
        }
        return hrCharge;
    }

    public CarParked dropSlot() {
        int hrCharge =  0;
        for (int i = 0; i < carParkedDetails.size(); i++) {
            if(carParkedDetails.get(i).getUserID().equals(userNow.getUserID())){
                CarParked carParked = carParkedDetails.get(i);
                Instant currentTime = Instant.now();
                Instant parkedTime = carParked.getParkedTime();
                Duration timeElapsed = Duration.between(parkedTime,currentTime);
                long timeDuration = timeElapsed.getSeconds();
                if(timeDuration>=5) {
                    timeDuration/=5;
                    hrCharge= (int)timeDuration * parkingPlace.getChargeForHr();
                    carParked.setTotalAmountTopay(hrCharge);
                    carParkedDetails.remove(i);
                    ParkingComplex.getSlots()[carParked.getRow()][carParked.getCol()] = null;
                    return carParked;
                }
                else{
                    carParked.setTotalAmountTopay(hrCharge);
                    carParkedDetails.remove(i);
                    ParkingComplex.getSlots()[carParked.getRow()][carParked.getCol()] = null;
                    return carParked;
                }
            }
        }
        return null;
    }
    public String userRegistration(String name, String mail, long phoneNumber, String password, String carNumebr, String carModel) {
        for (int i = 0; i < userDetails.size(); i++) {
            if(userDetails.get(i).getUserName().equals(name)){
                return "userName Exists Try Different Name";
            }
        }
        userDetails.add(new User(name.substring(0,3)+userIDGenrator,name,password,phoneNumber,mail,carNumebr,carModel));
        userIDGenrator++;
        return "registration is Successfull";
    }


}
