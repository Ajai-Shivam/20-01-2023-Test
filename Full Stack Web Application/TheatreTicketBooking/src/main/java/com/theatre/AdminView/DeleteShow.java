package com.theatre.AdminView;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteShow
 */
@WebServlet("/DeleteShow")
public class DeleteShow extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seat_ID = request.getParameter("seat_ID");
		AdminViewModel adminViewModel = new AdminViewModel(this);
		boolean ans  = adminViewModel.deleteShow(seat_ID);
		PrintWriter out = response.getWriter();
		out.print(ans);
		out.flush();
	}

}
