package com.roberto.jpa.sysnews.service;

import java.util.List;
import java.util.Optional;

import com.roberto.jpa.sysnews.model.User;

/**
 * Interface Model Service Generic
 * @author Roberto
 * @param <T> Type entity
 * @param <ID> Type ID default Long
 */
public interface ModelService<T, ID> {

	/**
	 * Insert a Type entity
	 * @param entity Type to save
	 * @return entity Type to saved
	 * @throws Exception
	 */
	public T save(T entity) throws Exception;
	
	
	/**
	 * Update a Type entity
	 * @param entity Type to update
	 * @return entity Type to updated
	 * @throws Exception
	 */
	public T update(T entity) throws Exception;
	
	/**
	 * Delete a Type entity
	 * @param id entity to delete
	 * @throws Exception
	 */
	public void deleteById(ID id) throws Exception;
	
	
	/**
	 * Delete a Type entity
	 * @param entity Type to delete
	 * @throws Exception
	 */
	public void delete(T entity) throws Exception;


	/**
	 * Get one object by entity
	 * @param id object by entity
	 * @return entity Type 
	 * @throws Exception
	 */
	public Optional<T> findOne(ID id) throws Exception;
	
	
	
	/////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * Get all objects by entity
	 * @return List<T> entity Type
	 * @throws Exception
	 */
	public List<T> findAll() throws Exception;
	
	
	
	/**
	 * Find if exist entity
	 * @param id object by entity
	 * @return true/false
	 * @throws Exception
	 */
	public boolean existById(ID id) throws Exception;
}
