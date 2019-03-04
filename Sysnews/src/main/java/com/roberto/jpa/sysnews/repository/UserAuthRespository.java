package com.roberto.jpa.sysnews.repository;


import com.roberto.jpa.sysnews.model.User;

/**
 * Interface User Authenticate Repository
 * @author Roberto
 */

public interface UserAuthRespository {
	
	/**
	 * Login User
	 * @param user login
	 * @return User 
	 */
	public User login(User user) throws Exception;
	
	
	/**
	 * Logout User
	 * @param user logout
	 */
	public void logout(User user) throws Exception;
	
	

}
