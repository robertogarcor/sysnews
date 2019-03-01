package com.roberto.jpa.sysnews.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

/**
 * Interface ModelController generic
 * @author Roberto
 * @version 23 feb. 2019 11:19:27
 * @param <T> Type entity
 * @param <ID> Type ID default Long
 */

public interface ModelController<T, S, ID> {

	
	/**
	 * Insert a Type entity
	 * @param entity Type to insert
	 * @return response entity Type saved
	 * @throws Exception
	 */
	public ResponseEntity<T> register(T entity);
	
	/**
	 * Update a Type entity
	 * @param entity Type to update
	 * @return response entity Type saved
	 * @throws Exception
	 */
	public ResponseEntity<T> update(T entity);
	
	
	/**
	 * Delete a Type entity
	 * @param id entity Type to delete
	 * @return 
	 */
	public ResponseEntity<S> deleteById(ID id);
	
	
	/**
	 * Delete a Type entity
	 * @param entity Type to delete
	 * @return 
	 */
	public ResponseEntity<S> delete(T entity);
	
	
	
	/**
	 * Get all object by entity
	 * @param id entity Type to search
	 * @return response entity Type
	 * @throws Exception
	 */
	public ResponseEntity<List<T>> findAll();
	
	
}
