package com.theatre.welcome;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.theatre.dto.User;

/**
 * Servlet implementation class userLoginServlet
 */
@WebServlet("/userLoginServlet")
public class userLoginServlet extends HttpServlet {
	private UserLoginModel userLoginModel;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(password);
		String encryptedPassword = encryption(password);
		System.out.println(encryptedPassword);
		userLoginModel = new UserLoginModel(this);
		User userDetails = userLoginModel.checkValidUser(username, encryptedPassword);	
		PrintWriter out = response.getWriter();
		if(userDetails == null) {
			out.print(false);
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("userdetails", userDetails);
			response.sendRedirect("UserLogin.html");
		}
		out.flush();
	}

	private String encryption(String password) {
		MessageDigest md;
		byte[] messageDigest;
		BigInteger bigInteger = null;
		try {
			md = MessageDigest.getInstance("MD5");
			messageDigest = md.digest(password.getBytes());
			bigInteger = new BigInteger(1,messageDigest);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return bigInteger.toString();

	}

}
