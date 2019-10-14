package com.nagarro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.models.User;
import com.nagarro.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	// method to authenticate user using username and password
	public User authenticateUser(String username, String password) throws Exception {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			}
			return null;
		}
		return null;
	}

}
