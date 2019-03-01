package com.roberto.jpa.sysnews.repository;


import com.roberto.jpa.sysnews.model.User;

public interface UserAuthRespository {
	
	/**
	 * Login User
	 * @param user login
	 * @return User 
	 */
	public User login(User user) throws Exception;
	

}
