package com.theatre.UserView;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

@WebServlet("/getMovies")
public class UserController extends HttpServlet{
	private UserModel userModel;

	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		userModel = new UserModel(this);
		System.out.println("con");
		JSONArray movies = userModel.getAvailableMovies();

		PrintWriter out = res.getWriter();
        out.print(movies);
        out.flush();
	}

}
