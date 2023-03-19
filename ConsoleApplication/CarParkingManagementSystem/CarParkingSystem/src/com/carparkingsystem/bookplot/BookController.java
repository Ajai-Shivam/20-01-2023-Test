package com.carparkingsystem.bookplot;

import com.carparkingsystem.dto.CarParked;

public class BookController implements BookViewControllerCallBack,BookModelControllerCallBack{
    private BookControllerModelCallBack bookModel ;

    private BookControllerViewCallBack bookView;
    public BookController(BookView bookView) {
        this.bookView = bookView;
        this.bookModel = new BookModel(this);
    }

    public String bookASlot() {
        return bookModel.bookASlot();
    }

    public int checkCurrentTimePrice() {
        return bookModel.checkCurrentTimePrice();
    }

    public CarParked dropSlot() {
        return bookModel.dropSlot();
    }
}
