package com.roberto.jpa.sysnews.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.roberto.jpa.sysnews.model.User;
import com.roberto.jpa.sysnews.repository.UserAuthRespository;

@Repository
public class UserRespositoryImpl implements UserAuthRespository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User login(User user) throws Exception {
		try {
			return (User) em.createNamedQuery("User.ckeckLogin")
					.setParameter(1, user.getUsername())
					.setParameter(2, user.getPassword())
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
