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
import javax.servlet.http.HttpSession;

import com.theatre.dto.User;


@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private AdminLoginModel adminLoginModel;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(password);
		String encryptedPassword = encryption(password);
		System.out.println(encryptedPassword);
		adminLoginModel = new AdminLoginModel(this);
		User adminDetails = adminLoginModel.checkValidAdmin(username, encryptedPassword);	
		PrintWriter out = response.getWriter();
		if(adminDetails == null) {
			out.print(false);
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