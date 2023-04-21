package com.theatre.booking;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

/**
 * Servlet implementation class GetCinimaHall
 */
@WebServlet("/GetCinimaHall")
public class GetCinimaHall extends HttpServlet {
	private BookingModel bookingModel ;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String showtiming = request.getParameter("showtiming");
		HttpSession session = request.getSession();
		session.setAttribute("show_timing", showtiming);
		
		bookingModel = new BookingModel(this);
		
		String movieID = null;
		String date= null;
		movieID = (String) session.getAttribute("movie_ID");
		date  = (String) session.getAttribute("date");
				
		JSONArray seats = bookingModel.getcinimaHall(movieID,date,showtiming);
		PrintWriter out = response.getWriter();
		out.print(seats);
		out.flush();
	}
}