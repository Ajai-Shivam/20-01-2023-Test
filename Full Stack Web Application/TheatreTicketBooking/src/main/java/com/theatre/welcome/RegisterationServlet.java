package com.theatre.welcome;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterationServlet
 */
@WebServlet("/RegisterationServlet")
public class RegisterationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(password);
		String hashedPassword = encryption(password);
		System.out.println(hashedPassword);
		RegistrationModel registrationModel =  new RegistrationModel(this);
		boolean result  = registrationModel.register(username, email, hashedPassword);
		
		PrintWriter out = response.getWriter();
		out.print(result);
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
