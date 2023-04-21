package com.theatre.AdminView;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class AdminViewServlet
 */
@WebServlet("/AdminViewServlet")
public class AdminViewServlet extends HttpServlet {
	private AdminViewModel adminViewModel;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			adminViewModel = new AdminViewModel(this);
			JSONObject data =  adminViewModel.getOnloadData();
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
			
	}

	

}
