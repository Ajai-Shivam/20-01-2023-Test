package com.carparkingsystem.bookplot;

import com.carparkingsystem.dto.CarParked;

public interface BookControllerModelCallBack {
    String bookASlot();

    int checkCurrentTimePrice();

    CarParked dropSlot();
}
