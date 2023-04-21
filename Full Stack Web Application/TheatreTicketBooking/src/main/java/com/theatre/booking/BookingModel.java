package com.theatre.booking;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.theatre.repository.TheatreRepository;

public class BookingModel {
	private TheatreRepository instance;
	private GetCinimaHall cinimaHall;
	private paymentdone paymentdone;
	public BookingModel(GetCinimaHall getCinimaHall) {
		this.cinimaHall = getCinimaHall;
		instance = TheatreRepository.getInstance();
	}
	public BookingModel(paymentdone paymentdone) {
		this.paymentdone = paymentdone;
		instance = TheatreRepository.getInstance();
	}
	public JSONArray getcinimaHall(String movieID, String date, String showtiming) {
		ResultSet seats = instance.getcinimaHall(movieID,date,showtiming);
		JSONArray cinihall = new JSONArray();
		try {
			while(seats.next()) {
				JSONObject obj = new JSONObject();
				JSONArray col = new JSONArray();
				obj.put("seatID", seats.getInt("seats_ID"));
				obj.put("row", seats.getString("row_id"));
				col.add(seats.getBoolean("col_1"));
				col.add(seats.getBoolean("col_2"));
				col.add(seats.getBoolean("col_3"));
				col.add(seats.getBoolean("col_4"));
				col.add(seats.getBoolean("col_5"));
				col.add(seats.getBoolean("col_6"));
				col.add(seats.getBoolean("col_7"));
				col.add(seats.getBoolean("col_8"));
				col.add(seats.getBoolean("col_9"));
				col.add(seats.getBoolean("col_10"));
				obj.put("seat", col);
				cinihall.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cinihall;
	}
	public void fillseats(String movieID, String showtiming, String date, String[] seats, String seatnumbers, String userName) {
		boolean yes  = instance.fillseats(movieID,showtiming,date,seatnumbers,seats,userName);
		
	}
	
	

}
