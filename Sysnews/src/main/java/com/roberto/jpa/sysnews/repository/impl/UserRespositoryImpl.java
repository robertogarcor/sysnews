package com.roberto.jpa.sysnews.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roberto.jpa.sysnews.model.User;
import com.roberto.jpa.sysnews.repository.UserAuthRespository;

/**
 * User repository management class implementation
 * @author Roberto
 */

@Repository
@Transactional
public class UserRespositoryImpl implements UserAuthRespository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public User login(User user) throws Exception {
		try {
			return (User) em.createNamedQuery("User.login")
					.setParameter(1, user.getUsername())
					.setParameter(2, user.getPassword())
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Override
	public void logout(User user) throws Exception {
		try {
			em.createNamedQuery("User.logout")
				.setParameter(1, user.getId())
				.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
		
	}

}
