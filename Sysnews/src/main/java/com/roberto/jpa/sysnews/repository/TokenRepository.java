package com.roberto.jpa.sysnews.repository;

import com.roberto.jpa.sysnews.model.Token;
import com.roberto.jpa.sysnews.model.User;

/**
 * Interface Token Respository
 * @author Roberto
 */

public interface TokenRepository {
	
	/**
	 * Create and Insert token UUID by User
	 * @param user entity
	 * @return token
	 * @throws Exception
	 */
	public Token create(User user) throws Exception;
	
	/**
	 * Delete token by user
	 * @param id by user
	 * @throws Exception
	 */
	//public void deleteById(Long id) throws Exception;
	
	/**
	 * Delete token UUID by user
	 * @param user entity
	 * @throws Exception
	 */
	public void delete(User user) throws Exception;
	
	
}
