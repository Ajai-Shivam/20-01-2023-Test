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
 * Servlet implementation class GetRevenue
 */
@WebServlet("/GetRevenue")
public class GetRevenue extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		System.out.println(date);
		AdminViewModel adminViewModel = new AdminViewModel(this);
		JSONArray revenue = adminViewModel.getRevenue(date);
		PrintWriter out = response.getWriter();
		out.print(revenue);
		out.flush();
	}

	

}
