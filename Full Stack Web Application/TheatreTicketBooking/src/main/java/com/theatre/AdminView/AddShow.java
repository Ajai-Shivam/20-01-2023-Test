package com.theatre.AdminView;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddShow
 */
@WebServlet("/AddShow")
public class AddShow extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String showtiming = request.getParameter("showtiming");
			String date =  request.getParameter("SelectDate");
			String screenNo = request.getParameter("SelectedScreen");
			String movie = request.getParameter("SelectMovie");
			System.out.println(showtiming+"      "+date+"      "+ screenNo + "   "+movie);
			AdminViewModel adminViewModel = new AdminViewModel(this);
			boolean ans = adminViewModel.addShow(showtiming,date,screenNo,movie);
			PrintWriter out = response.getWriter();
			out.print(ans);
			out.flush();
	}

}