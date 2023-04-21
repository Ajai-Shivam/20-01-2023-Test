package com.theatre.AdminView;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.theatre.repository.TheatreRepository;

public class AdminViewModel {
	private AdminViewServlet adminViewServlet;
	private TheatreRepository instance;
	private GetRevenue getRevenue;
	private GetTicketSold getTicketSold;
	private AddShow addShow;
	public AdminViewModel(AdminViewServlet adminViewServlet) {
		this.adminViewServlet = adminViewServlet;
		instance = TheatreRepository.getInstance();
		
	}

	public AdminViewModel(GetRevenue getRevenue) {
		this.getRevenue = getRevenue;
		instance = TheatreRepository.getInstance();
		
	}

	public AdminViewModel(GetTicketSold getTicketSold) {
			this.getTicketSold = getTicketSold;
			instance = TheatreRepository.getInstance();
	}

	public AdminViewModel(AddShow addShow) {
		this.addShow = addShow;
		instance= TheatreRepository.getInstance();
	}
	private AddMovie addMovie;
	private ViewShow viewShow;
	private deleteMovie deleteMovie;
	private GetAvailableShows getAvailableShows;
	private DeleteShow deleteShow;
	private GetShowsActive getShowsActive;
	public AdminViewModel(AddMovie addMovie) {
		this.addMovie = addMovie;
		instance = TheatreRepository.getInstance();
		
	}

	public AdminViewModel(ViewShow viewShow) {
		this.viewShow = viewShow;
		instance = TheatreRepository.getInstance();
	}

	public AdminViewModel(deleteMovie deleteMovie) {
		this.deleteMovie = deleteMovie;
		instance = TheatreRepository.getInstance();
	
		}

	public AdminViewModel(GetAvailableShows getAvailableShows) {
		this.getAvailableShows = getAvailableShows;
		instance = TheatreRepository.getInstance();
	}

	public AdminViewModel(DeleteShow deleteShow) {
		this.deleteShow = deleteShow;
		instance = TheatreRepository.getInstance();
	}

	public AdminViewModel(GetShowsActive getShowsActive) {
		this.getShowsActive = getShowsActive;
		instance = TheatreRepository.getInstance();
	}

	public JSONObject getOnloadData() {
		ResultSet totalRevenueNTotalTicketSold = instance.getTotalRevenue();
		ResultSet moviesDetails = instance.getAvailableMovies();
		ResultSet totalMovies = instance.getTotalMovies();
		ResultSet users = instance.getUsers();
		JSONObject data = new JSONObject();
		try {
			totalRevenueNTotalTicketSold.next();
			totalMovies.next();
			users.next();
			data.put("totalBooking", totalRevenueNTotalTicketSold.getInt("totalbookings"));
			data.put("totalAmount", totalRevenueNTotalTicketSold.getInt("totalAmount"));
			data.put("totalMovies", totalMovies.getInt("totalMovies"));
			data.put("users_count",users.getInt("users_count"));
						
			JSONArray movieArray = new JSONArray();
			while(moviesDetails.next()) {
				JSONObject jsonObject1 = new JSONObject();
			    jsonObject1.put("movie_ID", moviesDetails.getInt("movie_ID"));
			    jsonObject1.put("movie_name", moviesDetails.getString("movie_name"));
			    jsonObject1.put("movie_duration", moviesDetails.getString("movie_duration"));
			    jsonObject1.put("certificate",moviesDetails.getString("certificate"));
			    jsonObject1.put("trailer", moviesDetails.getString("description"));
			    jsonObject1.put("image", moviesDetails.getString("img"));
			    movieArray.add(jsonObject1);
			    
			}
			data.put("moviesdetails", movieArray);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		return data;
		
	}

	public JSONArray getRevenue(String date) {
		ResultSet RevenueDisplay = instance.getRevenueDisplay(date);
		JSONArray renvenueArray = new JSONArray();
		try {
			while(RevenueDisplay.next()) {
				JSONObject temp = new JSONObject();
				temp.put("totalamount", RevenueDisplay.getInt("total_amount"));
				temp.put("movie_name", RevenueDisplay.getString("movie_name"));
				temp.put("show_time", RevenueDisplay.getString("show_time"));
				renvenueArray.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return renvenueArray;
	}
	public JSONArray getTicketSold(String date) {
		ResultSet ticketSoldDisplay = instance.getticketSoldDisplay(date);

		JSONArray Ticketsold = new JSONArray();
		try {
			while(ticketSoldDisplay.next()) {
				JSONObject temp = new JSONObject();
				temp.put("bookingID", ticketSoldDisplay.getInt("bookingID"));
				temp.put("user_name", ticketSoldDisplay.getString("user_name"));
				temp.put("screen_name", ticketSoldDisplay.getString("screen_name"));
				temp.put("show_time", ticketSoldDisplay.getString("show_time"));
				temp.put("date_D", ticketSoldDisplay.getString("date_D"));
				temp.put("movie_name", ticketSoldDisplay.getString("movie_name"));
				temp.put("payment_method", ticketSoldDisplay.getString("payment_method"));
				temp.put("total_amount", ticketSoldDisplay.getInt("total_amount"));
				
				Ticketsold.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return Ticketsold;
	}

	public boolean addShow(String showtiming, String date, String screenNo,String movie) {
		boolean ans =instance.checkValidAddShow(showtiming, date, screenNo, movie);
		return ans;
	}

	public boolean addMovie(String movieName, String duration, String certification, String trailer, String banner) {
		boolean added =   instance.addMovie(movieName,duration,certification,trailer,banner);
		return added;
	}
	public JSONArray viewShowtiming(String date, String screen) {
		ResultSet showTimings = instance.viewShowtiming(date ,screen);
		JSONArray show = new JSONArray();
		if(showTimings!=null) {
			try {
				while (showTimings.next()) {
					JSONObject obj = new JSONObject();
					obj.put("show_Timing", showTimings.getString("show_timing"));
					show .add(obj);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return show;
	}

	public boolean deleteMovie(String movie_id) {
		return instance.deleteMovie(movie_id);
	}

	public JSONArray getAvailableShows() {
		ResultSet res =   instance.getAvailableShows();
		
		JSONArray shows = new JSONArray();
		 try {
			while(res.next()) {
				 JSONObject obj = new JSONObject();
				 obj.put("show_ID", res.getInt("show_ID"));
				 obj.put("show_timing", res.getString("show_timing"));
				 obj.put("date", res.getString("date_ID"));
				 obj.put("movie_name", res.getString("movie_name"));
				 obj.put("seat_ID", res.getInt("seat_ID"));
				 shows.add(obj);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return shows;
	}

	public boolean deleteShow(String seat_ID) {
	 boolean ans = 	instance.deleteShow(seat_ID);
	 return ans;
	}
	
	public JSONArray getActiveShows() {
		ResultSet res = instance.getActiveShows();
		JSONArray shows = new JSONArray();
		 try {
			while(res.next()) {
				 JSONObject obj = new JSONObject();
				 obj.put("show_ID", res.getInt("show_ID"));
				 obj.put("show_timing", res.getString("show_timing"));
				 obj.put("date", res.getString("date_ID"));
				 obj.put("movie_name", res.getString("movie_name"));
				 obj.put("active", res.getBoolean("active"));
				 obj.put("seat_ID", res.getInt("seat_ID"));

				 shows.add(obj);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return shows;
		
		
	}

	public boolean deactivate(int seat) {
		return instance.deactive(seat);
	}
	

	
}

