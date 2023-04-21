package com.theatre.welcome;

import com.theatre.repository.TheatreRepository;

public class RegistrationModel {
	
	private RegisterationServlet registerationServlet;
	private TheatreRepository instance;
	public RegistrationModel(RegisterationServlet registerationServlet) {
		this.registerationServlet = registerationServlet;
		instance = TheatreRepository.getInstance();
	}

	public boolean register(String username, String email, String password) {
		boolean registered = instance.register(username, email, password);
		return registered;
	}

}
