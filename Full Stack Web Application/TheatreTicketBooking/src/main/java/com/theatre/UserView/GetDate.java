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
 * Servlet implementation class GetDate
 */
@WebServlet("/GetDate")
public class GetDate extends HttpServlet {
	private UserModel userModel;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String movieID = request.getParameter("movieID"); 
		HttpSession session = request.getSession();
		session.setAttribute("movie_ID",movieID);
		userModel = new UserModel(this);
		int num = Integer.parseInt(movieID);
		JSONArray dates = userModel.getDates(num);
		PrintWriter out = response.getWriter();
		out.print(dates);
		out.flush();
	}

	
}
