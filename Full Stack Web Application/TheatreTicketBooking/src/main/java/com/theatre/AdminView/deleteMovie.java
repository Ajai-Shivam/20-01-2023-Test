package com.theatre.AdminView;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteMovie
 */
@WebServlet("/deleteMovie")
public class deleteMovie extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminViewModel adminViewModel = new AdminViewModel(this);
		String movie_id  =  request.getParameter("movie_id");
		boolean res =  adminViewModel.deleteMovie(movie_id);
		PrintWriter out = response.getWriter();
		out.print(res);
		out.flush();
	}

}
