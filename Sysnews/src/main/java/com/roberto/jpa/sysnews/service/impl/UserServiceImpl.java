package com.roberto.jpa.sysnews.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberto.jpa.sysnews.model.User;
import com.roberto.jpa.sysnews.repository.UserAuthRespository;
import com.roberto.jpa.sysnews.repository.UserRepository;
import com.roberto.jpa.sysnews.service.UserAuthService;
import com.roberto.jpa.sysnews.service.ModelService;

/**
 * Class UserService
 * @author Roberto
 * @version 23 feb. 2019 11:18:22
 */
@Service
public class UserServiceImpl implements ModelService<User, Long>, UserAuthService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserAuthRespository authRepository;
	

	@Override
	public User save(User entity) throws Exception {
		try {
			return userRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}


	@Override
	public User update(User entity) throws Exception {
		try {
			return userRepository.save(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void deleteById(Long id) throws Exception {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	@Override
	public User login(User user) throws Exception {
		try {
			return authRepository.login(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	@Override
	public void delete(User entity) throws Exception {
		try {
			userRepository.delete(entity);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	@Override
	public Optional<User> findOne(Long id) throws Exception {
		try {
			return userRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Override
	public boolean existById(Long id) throws Exception {
		try {
			return userRepository.existsById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	////////////////////////////////////////////////////////////////
	
	
	@Override
	public List<User> findAll() throws Exception {
		try {
			return (List<User>) userRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	

	
	
	
}
