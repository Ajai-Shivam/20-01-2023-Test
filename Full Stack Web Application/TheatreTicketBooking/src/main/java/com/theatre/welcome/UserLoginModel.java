package com.theatre.welcome;

import com.theatre.dto.User;
import com.theatre.repository.TheatreRepository;

public class UserLoginModel {

	private userLoginServlet userLoginServlet;
	private TheatreRepository instance;
	public UserLoginModel(userLoginServlet userLoginServlet) {
		this.userLoginServlet= userLoginServlet;
		instance= TheatreRepository.getInstance();
	}

	public User checkValidUser(String userName, String encryptedPassword) {
		User user = instance.checkValidUser(userName,encryptedPassword);
		if(user!=null) {
			if(user.getUsername().equals(userName)&& user.getPassword().equals(encryptedPassword)) {
			return user;
			}
		}
		return null;
	}
}
