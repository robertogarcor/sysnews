package com.roberto.jpa.sysnews.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roberto.jpa.sysnews.model.User;

/**
 * Interface Entity User Respository
 * @author Roberto
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	


}
