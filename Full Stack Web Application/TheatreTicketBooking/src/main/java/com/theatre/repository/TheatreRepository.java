package com.theatre.repository;


import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONObject;

import com.theatre.dto.CinimaHall;
import com.theatre.dto.User;



public class TheatreRepository {
	
	private static TheatreRepository instance;
	
	private static String url = "jdbc:mysql://localhost:3306/theatreticketbooking";
	private static String pass = "Ajai@9578";
	private static String uName = "root";
	private static Connection con;
	private TheatreRepository() {
		
	}
	private static ArrayList<String> shows = new ArrayList<>();
	static{
		shows.add("09:00");
		shows.add("12:00");
		shows.add("15:00");
		shows.add("10:00");
		shows.add("14:00");
		shows.add("18:00");
		shows.add("11:00");
		shows.add("14:30");
		shows.add("18:30");
	}
	public static TheatreRepository getInstance() {
		if(instance == null) {
			instance = new TheatreRepository();
			 try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url,uName,pass);
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return instance;
	}
	
	public User checkValidUser(String userName, String encryptedPassword) {
		String query =  "select * from users where username= '"+userName+"' and password= '"+encryptedPassword+"' and isadmin = 0";
		System.out.println(query); 
		
		try {
			 Statement stmt = con.createStatement();
			ResultSet data = stmt.executeQuery(query);
			if(data.next()) {
				return new User(data.getInt("user_ID"), data.getString("username"), data.getString("password"), data.getString("email"), data.getBoolean("isadmin"));
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getAvailableMovies() {
		String query =  "select * from movies";
		ResultSet movies =null;
		try {
			Statement stmt = con.createStatement();
		
			movies = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;

	}
	public void weeklyMaintance() {
		ResultSet result= null;
		try {
			
			Statement stmt = con.createStatement();
			String query = "select count(*) as total_movies from movies";
			String totalseats = "select count(*) as total_seats from shows ";
			ResultSet res = stmt.executeQuery(query);
			res.next();
			int totalMovies = res.getInt("total_movies");
			totalMovies+=1;
			
			int seat = 1;
			PreparedStatement pst = con.prepareStatement("insert into shows(show_ID,show_timing,date_ID,seat_ID,movie_ID) values (?,?,?,?,?)");
			result = stmt.executeQuery(query);
			for (int i = 0; i < shows.size() ; i++) {
				for(int j=1;j<=5;j++) {
			        int randonMovie = (int)(Math.random() * (totalMovies-1)+1);
					pst.setInt(1, i+1);
					pst.setString(2,shows.get(i)+":00");
					pst.setString(3, LocalDate.now().plusDays(j).toString());
					pst.setInt(4, seat);
					pst.setInt(5, randonMovie);
					seat++;
					int recordsInserted = pst.executeUpdate();
					System.out.println(recordsInserted);
				}
			}
			res= stmt.executeQuery(totalseats);
			res.next();
			int totseat = res.getInt("total_seats");
			System.out.println(totseat);
			pst = con.prepareStatement("insert into seats(seats_ID,row_id) values (?,?)");
			System.out.println("seats:");
			for(int i = 1;i<=totseat;i++) {
				for(int j=1;j<=10;j++) {
					pst.setInt(1, i);
					char a = (char) (64+j);
					String ad ="";
					ad+=a;
					 pst.setString(2, ad);
					 int recordsInserted = pst .executeUpdate();
					
			
					System.out.println(recordsInserted);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {
		instance = getInstance();
		instance.weeklyMaintance();
	}

	public ResultSet getDates(int movieID) {
		ResultSet Dates = null;
		try {
			 
			Statement stmt = con.createStatement();
			String dateQuery = "select distinct date_ID from shows where movie_ID= "+movieID + " order by date_ID";
			Dates = stmt.executeQuery(dateQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Dates;
	}

	public ResultSet getShows(String date, String movieID) {
		ResultSet shows = null;
		try {
			Statement stmt = con.createStatement();
			String showQuery = "select show_timing from shows where movie_ID= "+movieID + " and date_ID = '"+date+"'";
			System.out.println(showQuery);
			shows = stmt.executeQuery(showQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shows;
	}

	public ResultSet getcinimaHall(String movieID, String date, String showtiming) {
		ResultSet seats = null;
		ResultSet ciniHall = null;
		try {
			Statement stmt = con.createStatement();
			String seatQuery = "select seat_ID from shows where movie_ID = "+movieID +" and show_timing = '"+showtiming+"' and date_ID = '"+date+"'";
			System.out.println(seatQuery);
			seats = stmt.executeQuery(seatQuery);
			seats.next();
			int seatId = seats.getInt("seat_ID");
			String ciniQuery = "select * from seats where seats_ID = "+seatId;
			ciniHall = stmt.executeQuery(ciniQuery);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ciniHall;
	}

	public boolean fillseats(String movieID, String showtiming, String date, String seatnumbers, String[] seatnum, String userName) {
		ResultSet seatID = null;
		
		String seatQuery = "select show_ID,seat_ID from shows where movie_ID = "+movieID +" and show_timing = '"+showtiming+"' and date_ID = '"+date+"'";

		try {
			Statement stmt = con.createStatement();
			seatID = stmt.executeQuery(seatQuery);
			seatID.next();
			int seatId = seatID.getInt("seat_ID");
			int showID = seatID.getInt("show_ID");
			String screen_Name = updateseats(seatnum,seatId,showID);
			String query =  "select movie_name from movies where movieID = "+movieID;
			int amt = seatnum.length * 120;
			String ticketno = seatnum.toString();
			insertticketBooking(userName,screen_Name,showtiming,date,seatnum.length,amt,movieID,ticketno);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}	
	public String updateseats(String[] seatnum,int seatId, int showID) {
		ResultSet screen = null;
		String col = "";
			int recordsInserted = 0;
		String screen_Name = null;
		try {
			Statement stmt = con.createStatement();
			String scrQu = "select screen_name from screens where show_ID = "+showID;
			screen = stmt.executeQuery(scrQu);
			screen.next();
			 screen_Name = screen.getString("screen_name");

			for(int i =0;i<seatnum.length;i++) {


				col = seatnum[i].substring(1);
				String insertq = "Update seats set col_"+col+" = 1 where row_id = '"+seatnum[i].substring(0,1)+"'	 and seats_ID = "+  seatId;
				System.out.println(insertq);
				PreparedStatement pre = con.prepareStatement(insertq);
				int a = pre.executeUpdate();
				System.out.println(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screen_Name;
	}
	public void insertticketBooking(String userName, String screen_Name, String showtiming, String date, int length, int amt,  String movieID, String ticketNo){
		
		try {
			Statement stmt = con.createStatement();
			ResultSet movies =null;
			String moviequery = "select movie_name from movies where movie_ID = "+movieID;
			movies = stmt.executeQuery(moviequery);
			movies.next();
			String movieName = movies.getString("movie_name");
			PreparedStatement prv =  con.prepareStatement("insert into ticketbookingdetails (user_name,screen_name,show_time,date_D,ticket_No,ticket_count,movie_name,total_amount) values(?,?,?,?,?,?,?,?)" );
			prv.setString(1 , userName );
			prv.setString(2 , screen_Name);
			prv.setString(3 , showtiming);
			prv.setString(4 , date);
			prv.setString(5 , ticketNo);
			prv.setInt(6 ,length );
			prv.setString(7 , movieName);
			prv.setInt(8 , amt);

			
			int record = prv.executeUpdate();
			System.out.println("insert TicketBooking Details");
			System.out.println(record);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean register(String username, String email, String password) {
		int count = 0;
		int inserted = 0;
	
		 String checkQuery = "Select * from users where username = '"+username+"' or email= '"+email+"'";
		 
		
		try {
			Statement stmt = con.createStatement();
			ResultSet check = stmt.executeQuery(checkQuery);
			while(check.next()) {
				count++;
			}
			
			if(count == 0) {
				PreparedStatement pre = con.prepareStatement("insert into users(username,password,email,isadmin) values(?,?,?,?)");
				pre.setString(1, username);
				pre.setString(2, password);
				pre.setString(3, email);
				pre.setInt(4, 0);
				inserted  = pre.executeUpdate();
				
				System.out.println(inserted);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(inserted == 1) {
			return true;
		}
		return false;
		
	}

	public User checkValidAdmin(String username, String encryptedPassword) {
		String query =  "select * from users where username= '"+username+"' and password= '"+encryptedPassword+"' and isadmin = 1";
		System.out.println(query); 
		try {
			 Statement stmt = con.createStatement();
			ResultSet data = stmt.executeQuery(query);
			if(data.next()) {
				return new User(data.getInt("user_ID"), data.getString("username"), data.getString("password"), data.getString("email"), data.getBoolean("isadmin"));
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getTotalRevenue() {
		 LocalDate l = LocalDate.now();
	        
		String query =  "select sum(ticket_count) as totalbookings ,sum(total_amount) as totalamount from ticketbookingdetails where date_D = '"+l+"'";
		
		 ResultSet RevennueandTicketsBooked = null;
			try {
			Statement stmt = con.createStatement();
			RevennueandTicketsBooked =  stmt.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return RevennueandTicketsBooked;
	}

	public ResultSet getTotalMovies() {
		String query =  "select count(movie_id) as totalMovies from movies";
		 ResultSet totalMovies = null;
		try {
			Statement stmt = con.createStatement();
			totalMovies =  stmt.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalMovies;
	}

	public ResultSet getRevenueDisplay(String date) {
		String query =  "SELECT show_time, movie_name,SUM(total_amount) AS total_amount FROM ticketbookingdetails where date_D = '"+date+"' GROUP BY show_time , movie_name;";
		System.out.println(query);
		 ResultSet revenue = null;
		try {
			Statement stmt = con.createStatement();
			revenue =  stmt.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return revenue;
	}

	public ResultSet getticketSoldDisplay(String date) {
		String query =  "select * from ticketbookingdetails where date_D = "+date;
		 ResultSet ticketsoldDisplay = null;
		try {
			Statement stmt = con.createStatement();
			ticketsoldDisplay =  stmt.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ticketsoldDisplay;
	}

	public ResultSet getUsers() {
		String query =  "select count(user_ID) as users_count from users where isadmin = 0";
		 ResultSet users = null;
		
		try {
			Statement stmt = con.createStatement();
			users =  stmt.executeQuery(query);
			
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}

	
	public boolean addShow(String showtiming, String date, String screenNo ,String movie) {
	
		 ResultSet users = null;
		try {
			
		
			String query = "select max(show_ID) as shwID  from shows";
			
			
			Statement stmt = con.createStatement();
			ResultSet random = stmt.executeQuery(query);
			random.next();
			int showID = random.getInt("shwID");			
			PreparedStatement pst = con.prepareStatement("insert into screens values(?,?,?)");
			int screen = Integer.parseInt(screenNo)
;			pst.setInt(1, screen);
			pst.setString(2,"SCR-"+screenNo);
			pst.setInt(3,showID+1);
			int inserted = pst.executeUpdate();
			System.out.println(inserted);
			ResultSet seat = stmt.executeQuery("select max(seat_ID) as seatID from shows");
			seat.next();
			int seatID = seat.getInt("seatID");
			seatID +=1;
			
			PreparedStatement pre ;
			pre = con.prepareStatement("insert into shows values (?,?,?,?,?)");
			pre.setInt(1, showID+1);
			pre.setString(2, showtiming);
			pre.setString(3, date);
			pre.setString(4, movie);
			pre.setInt(5, seatID);
			
			int rec  = pre.executeUpdate();
			System.out.println(rec);
			
			
			PreparedStatement preS = con.prepareStatement("insert into seats(seats_ID,row_id) values(?,?)");
			for(int i =1;i<=10;i++) {
				preS.setInt(1, seatID);
				char a = (char) (64+i);
				String ad ="";
				ad+=a;
				preS.setString(2, ad);
				 int recordsInsert = preS .executeUpdate();
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	public boolean checkValidAddShow(String showtiming, String date, String screenNo, String movie) {
		String query =  "select * from screens where screen_ID = "+screenNo;
		
		 ResultSet check = null;
		ArrayList<Integer> showID = new ArrayList<>();
		try {

			Statement stmt = con.createStatement();
			check =  stmt.executeQuery(query);
			while(check.next()) {
				showID.add(check.getInt("show_ID"));
				
			}
			
			
			for(int i=0;i<showID.size();i++) {
				int count =0;
				String checkQuery = "select * from shows where show_ID="+showID.get(i)+" and date_ID = '"+date+"' and show_timing= '"+showtiming+":00'"; 
				Statement stmt1 = con.createStatement();
				ResultSet ans = stmt1.executeQuery(checkQuery);
				
				while(ans.next()) {
					count++;
				}
				
				if(count>0) {
					return false;
				}
			}
			
			
			
		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean ans = addShow(showtiming, date, screenNo, movie);
		return ans;
	}

	public boolean addMovie(String movieName, String duration, String certification, String trailer, String banner) {
		
		
		
		
		
		int insertedRecord = 0;
		
		try {
			String checkQuery = "Select * from movies where movie_name = '"+movieName+"' and movie_duration = '"+duration+"' and description = '"+trailer+"' and certificate = '"+certification+"' and img = '"+banner+"'"; 
			Statement st = con.createStatement();
			
			ResultSet r = st.executeQuery(checkQuery);
			int count = 0;
			while(r.next()) {
				count++;
			}
			if(count>0) {
				return false;
			}
			
			PreparedStatement pre = con.prepareStatement("insert into movies(movie_name,movie_duration,description,certificate,img) values(?,?,?,?,?)");
			pre.setString(1,movieName);
			pre.setString(2, duration);
			pre.setString(3, trailer);
			pre.setString(4, certification);
			pre.setNString(5, banner);
			
			insertedRecord = pre.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(insertedRecord == 1) {
			return true;
		}
		return false;
	}
	public ResultSet viewShowtiming(String date, String screen) {
		ResultSet showtimings = null;
		String query = "select show_timing from screens inner join shows on screens.show_ID = shows.show_ID where  screens.screen_ID = +"+screen+" and shows.date_ID ='"+date+"'";
		Statement stmt;
		try {
			stmt = con.createStatement();
			showtimings = stmt.executeQuery(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return showtimings;
		
	}

	public boolean deleteMovie(String movie_id) {
		String query = "delete from movies where movie_ID = "+movie_id;
		Statement st;
		boolean ans = false;
		try {
			st = con.createStatement();
		  ans =  st.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
		
		
	}
 public ResultSet getAvailableShows() {
	 String Query = "select show_ID,show_timing,date_ID,movie_name,seat_ID from shows join  movies on movies.movie_ID = shows.movie_id  order by date_ID,show_timing";
	 
	 Statement st;
	 ResultSet res = null ;
	try {
		st = con.createStatement();
		res = st.executeQuery(Query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return res; 
 }

public boolean deleteShow(String seat_ID) {
	String query = "delete from shows where seat_ID = "+seat_ID;
	Statement st;
	boolean ans = false;
	try {
		st = con.createStatement();
	  ans =  st.execute(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ans;

}

public ResultSet getActiveShows() {
	String query = "select show_ID,show_timing,date_ID,movie_name,active,seat_ID from shows  join movies on movies.movie_id = shows.movie_ID  where date_ID > curdate() order by date_ID";
	Statement st;
	ResultSet ans = null;
	try {
		st = con.createStatement();
	  ans =  st.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ans;
}

public boolean deactive(int seat) {
	String query ="update shows set active = 0 where seat_ID ="+seat;
	Statement stmt;
	boolean updated = false;
	try {
		stmt = con.createStatement();
		updated  = stmt.execute(query);

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return updated;
}
	
}
