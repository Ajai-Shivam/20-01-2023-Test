package com.theatre.AdminView;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

/**
 * Servlet implementation class GetShowsActive
 */
@WebServlet("/GetShowsActive")
public class GetShowsActive extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminViewModel adminViewModel = new AdminViewModel(this);
		JSONArray res =  adminViewModel.getActiveShows();
		PrintWriter out = response.getWriter();
		out.print(res);
		out.flush();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seat = Integer.parseInt( request.getParameter("seat_ID"));
		AdminViewModel adminViewModel = new AdminViewModel(this);
		boolean res =  adminViewModel.deactivate(seat);
		PrintWriter out = response.getWriter();
		out.print(res);
		out.flush();

	}

}
