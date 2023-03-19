package com.carparkingsystem.bookplot;

import com.carparkingsystem.dto.CarParked;

public interface BookViewControllerCallBack {
    String bookASlot();

    int checkCurrentTimePrice();

    CarParked dropSlot();
}
