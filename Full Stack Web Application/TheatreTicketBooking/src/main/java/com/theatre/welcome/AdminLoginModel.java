package com.theatre.welcome;

import com.theatre.dto.User;
import com.theatre.repository.TheatreRepository;

public class AdminLoginModel {

	private AdminLoginServlet adminLoginServlet;
	private TheatreRepository instance;
	public AdminLoginModel(AdminLoginServlet adminLoginServlet) {
		this.adminLoginServlet = adminLoginServlet;
		instance = TheatreRepository.getInstance();
	}

	public User checkValidAdmin(String username, String encryptedPassword) {
		User user = instance.checkValidAdmin(username,encryptedPassword);
		if(user!=null) {
			if(user.getUsername().equals(username)&& user.getPassword().equals(encryptedPassword)) {
			return user;
			}
		}
		return null;
		
	}

}
