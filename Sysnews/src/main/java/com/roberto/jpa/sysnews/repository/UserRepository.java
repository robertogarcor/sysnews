package com.roberto.jpa.sysnews.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roberto.jpa.sysnews.model.User;

/**
 * Interface ModelRespository
 * @author Roberto
 * @version 23 feb. 2019 11:20:39
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	


}
