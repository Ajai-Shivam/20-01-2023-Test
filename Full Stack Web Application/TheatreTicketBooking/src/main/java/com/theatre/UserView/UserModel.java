package com.theatre.UserView;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.*;

import com.theatre.repository.TheatreRepository;

public class UserModel {
	private UserController userController;
	private GetDate getDate;
	private GetShows getShows;
	private TheatreRepository instance;
	public UserModel(UserController userController) {
		this.userController = userController;
		System.out.println("model");
		instance = TheatreRepository.getInstance();
	}
	public UserModel(GetDate getDate) {
		this.getDate = getDate;
		instance = TheatreRepository.getInstance();

	}
	public UserModel(GetShows getShows) {
		this.getShows = getShows;
		instance = TheatreRepository.getInstance();
	}
	public JSONArray getAvailableMovies() {
		ResultSet movie = instance.getAvailableMovies();
		JSONArray jsonArray = new JSONArray();
		if(movie != null) {

        try {
			while(movie.next()) {
			    JSONObject jsonObject1 = new JSONObject();
			    jsonObject1.put("movie_ID", movie.getInt("movie_ID"));
			    jsonObject1.put("movie_name", movie.getString("movie_name"));
			    jsonObject1.put("movie_duration", movie.getString("movie_duration"));
			    jsonObject1.put("trailer", movie.getString("description"));
			    jsonObject1.put("image", movie.getString("img"));
			    jsonArray.add(jsonObject1);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
        return jsonArray;
	}
	public JSONArray getDates(int movieID) {
		ResultSet Dates = instance.getDates(movieID);
		JSONArray jsonArray = new JSONArray();
		try {
			while(Dates.next()) {
				  try {
					JSONObject jsonObject1 = new JSONObject();
					jsonObject1.put("date", Dates.getString("date_ID"));
					jsonArray.add(jsonObject1);
				  } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	public JSONArray getShows(String date, String movieID) {
		ResultSet shows = instance.getShows(date,movieID);
		JSONArray jsonArray = new JSONArray();
		try {
			while(shows.next()) {
				  try {
					JSONObject jsonObject1 = new JSONObject();
					jsonObject1.put("showtiming", shows.getString("show_timing"));
					jsonArray.add(jsonObject1);
				  } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jsonArray;
	}

	


}
