package com.carparkingsystem.bookplot;

import com.carparkingsystem.dto.CarParked;
import com.carparkingsystem.repository.Repository;

public class BookModel implements BookControllerModelCallBack{
    private BookModelControllerCallBack bookController;
    private Repository instance;
    public BookModel(BookController bookController) {
        this.bookController = bookController;
        instance = Repository.getInstance();
    }

    public String bookASlot() {
       return instance.bookASlot();
    }
    public int checkCurrentTimePrice() {
        return instance.checkCurrentTimePrice();
    }

    public CarParked dropSlot() {
       return instance.dropSlot();
    }
}
