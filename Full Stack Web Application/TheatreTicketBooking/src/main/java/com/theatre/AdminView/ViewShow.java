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
 * Servlet implementation class ViewShow
 */
@WebServlet("/ViewShow")
public class ViewShow extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date = request.getParameter("date");
		String screen = request.getParameter("screen");
		AdminViewModel adminViewModel = new AdminViewModel(this);
	    JSONArray array = adminViewModel.viewShowtiming(date,screen);
		PrintWriter out = response.getWriter();
		out.print(array);
		out.flush();
	}

}
