package com.roberto.jpa.sysnews.controller;

import org.springframework.http.ResponseEntity;

import com.roberto.jpa.sysnews.model.User;

/**
 * Interface UserAuthController
 * @author Roberto
 */

public interface UserAuthController {
	
	/**
	 * Login User
	 * @param user login
	 * @return response entity User 
	 */
	public ResponseEntity<User> login(User user);
	
	
	/**
	 * Logout User
	 * @param user logout
	 * @return response string message
	 */
	public ResponseEntity<String> logout(User user);
	
			
}
