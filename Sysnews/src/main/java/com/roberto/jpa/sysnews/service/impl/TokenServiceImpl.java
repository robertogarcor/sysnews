package com.roberto.jpa.sysnews.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.jpa.sysnews.model.Token;
import com.roberto.jpa.sysnews.model.User;
import com.roberto.jpa.sysnews.repository.TokenRepository;
import com.roberto.jpa.sysnews.service.TokenService;

/**
 * Token service management class implementation
 * @author Roberto
 */

@Service("TokenServiceImpl")
public class TokenServiceImpl implements TokenService {

	@Autowired
	private TokenRepository tokenRepository;
	
	@Override
	public Token create(User user) throws Exception {
		try {
			return tokenRepository.create(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void delete(User user) throws Exception {
		try {
			tokenRepository.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

}
