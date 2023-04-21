package com.theatre.AdminView;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddMovie
 */
@WebServlet("/AddMovie")
public class AddMovie extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieName = request.getParameter("moviename");
		String duration = request.getParameter("movieduration");
		String certification = request.getParameter("certification");
		String trailer = request.getParameter("trailer");
		String banner = request.getParameter("banner");		
		AdminViewModel adminViewModel = new AdminViewModel(this);
		boolean added = adminViewModel.addMovie(movieName,duration,certification,trailer,banner);
		PrintWriter out = response.getWriter();
		out.print(added);
		out.flush();
	}

}
