package com.theatre.booking;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.theatre.dto.User;

/**
 * Servlet implementation class paymentdone
 */
@WebServlet("/paymentdone")
public class paymentdone extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seatnumbers = request.getParameter("seatnumber");
		String[] seats = seatnumbers.split(",");
		System.out.println(Arrays.toString(seats));
		BookingModel bookingModel = new BookingModel(this);
		String movieID = null;
		String showtiming = null;
		String date = null;
		String userName = null;
		HttpSession session = request.getSession();
		movieID = (String) session.getAttribute("movie_ID");
		showtiming = (String) session.getAttribute("show_timing");

		date = (String) session.getAttribute("date");

		User userdetails = (User) session.getAttribute("userdetails");

		bookingModel.fillseats(movieID,showtiming,date,seats,seatnumbers,userdetails.getUsername());
		
	}

}
