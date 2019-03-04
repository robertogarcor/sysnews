package com.roberto.jpa.sysnews.repository.impl;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roberto.jpa.sysnews.model.Token;
import com.roberto.jpa.sysnews.model.User;
import com.roberto.jpa.sysnews.repository.TokenRepository;

/**
 * Token repository management class implementation
 * @author Roberto
 */

@Repository
public class TokenRepositoryImpl implements TokenRepository {

	@Autowired
	private EntityManagerFactory emf;
	
	@Override
	public Token create(User user) throws Exception {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Token token = new Token();
			token.setKey(generateUUIDToken());
			token.setUser(user);
			em.persist(token);
			em.getTransaction().commit();
			em.close();
			return token;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}

	@Override
	public void delete(User user) throws Exception {
		try {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.createNamedQuery("Token.delete")
				.setParameter("user_id", user.getId())
				.executeUpdate();
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}	
	}
	
	/**
	 * Generated UUID Token
	 * @return token
	 */
	private String generateUUIDToken() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

}
