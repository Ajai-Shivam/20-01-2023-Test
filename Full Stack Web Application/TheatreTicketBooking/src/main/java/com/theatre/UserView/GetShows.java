package com.theatre.UserView;

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
 * Servlet implementation class GetShows
 */
@WebServlet("/GetShows")
public class GetShows extends HttpServlet {
	private UserModel userModel;


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userModel = new UserModel(this);
		String date = null;
		String movieID = null;
		HttpSession session = req.getSession();
		date = (String) session.getAttribute("date");
		movieID = (String) session.getAttribute("movie_ID");
		JSONArray shows = userModel.getShows(date,movieID);
		PrintWriter out = resp.getWriter();
		out.print(shows);
		out.flush();
		
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String date = request.getParameter("date");
		HttpSession session = request.getSession();
		session.setAttribute("date", date);
		PrintWriter out = response.getWriter();
		response.sendRedirect("Booking.html");
		out.flush();
	}

}
