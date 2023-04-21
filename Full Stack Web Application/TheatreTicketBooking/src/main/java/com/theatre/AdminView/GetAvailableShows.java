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
 * Servlet implementation class GetAvailableShows
 */
@WebServlet("/GetAvailableShows")
public class GetAvailableShows extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminViewModel adminViewModel = new AdminViewModel(this);
		JSONArray res  =  adminViewModel.getAvailableShows();
		PrintWriter out = response.getWriter();
		out.print(res);
		out.flush();
	}

}
