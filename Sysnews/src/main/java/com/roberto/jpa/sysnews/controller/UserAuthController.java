package com.roberto.jpa.sysnews.controller;

import org.springframework.http.ResponseEntity;

import com.roberto.jpa.sysnews.model.User;

public interface UserAuthController {
	
	/**
	 * Login User
	 * @param user login
	 * @return response entity User 
	 */
	public ResponseEntity<User> login(User user);
	
	
		
}
