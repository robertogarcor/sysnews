package com.roberto.jpa.sysnews.controller.impl;


import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roberto.jpa.sysnews.controller.UserAuthController;
import com.google.gson.JsonObject;
import com.roberto.jpa.sysnews.controller.ModelController;
import com.roberto.jpa.sysnews.model.Token;
import com.roberto.jpa.sysnews.model.User;
import com.roberto.jpa.sysnews.service.UserAuthService;
import com.roberto.jpa.sysnews.service.ModelService;
import com.roberto.jpa.sysnews.service.TokenService;

/**
 * Class Management Request Mapping User Controller
 * @author Roberto
 */

@RestController
public class UserControllerImpl implements ModelController<User, String, Long>, UserAuthController {

	@Autowired
	private ModelService<User, Long> userService;
	@Autowired
	private TokenService tokenService;
	@Autowired 
	private HttpServletRequest context;
	@Autowired
	private UserAuthService userAuthService;
	
	private static MultiValueMap<String, String> headers;
	
	
	@Override
	@RequestMapping(value="/account/login", method=RequestMethod.POST,
					produces= {
						MediaType.APPLICATION_JSON_UTF8_VALUE,
						MediaType.APPLICATION_XML_VALUE
					}
				)	
	public ResponseEntity<User> login(@RequestBody User user) {
		try {
			this.addInfoHeaders();
			if (user.getUsername().length() > 0  & user.getPassword().length() > 0) {
				User user_valid = userAuthService.login(user);
				if(user_valid != null) {
					Token token = tokenService.create(user_valid);
					user_valid.setToken(token);
					return new ResponseEntity<User>(user_valid, headers, HttpStatus.OK);	
				}	
			}
		} catch (NoResultException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (Exception e1) {
			e1.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
		
	}
	
	
	@Override
	@RequestMapping(value="/account/logout", method=RequestMethod.POST,
						produces= {
							MediaType.APPLICATION_JSON_UTF8_VALUE,
							MediaType.APPLICATION_XML_VALUE
						}
					)	
	public ResponseEntity<String> logout(@RequestBody User user) {
		try {
			this.addInfoHeaders();
			userAuthService.logout(user);
			JsonObject message = new JsonObject();
			message.addProperty("message", "Successfully logout account. Token destroy.");
			return new ResponseEntity<String>(message.toString(), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@Override
	@RequestMapping(value="/account/register", method=RequestMethod.POST, 
					produces= {
								MediaType.APPLICATION_JSON_UTF8_VALUE,
								MediaType.APPLICATION_XML_VALUE
								}
					)
	public ResponseEntity<User> register(@Valid @RequestBody User user) {
		try {
			this.addInfoHeaders();
			return new ResponseEntity<User>(userService.save(user), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	
	@Override
	@RequestMapping(value="/account/update", method=RequestMethod.PUT, 
					produces= {
								MediaType.APPLICATION_JSON_UTF8_VALUE,
								MediaType.APPLICATION_XML_VALUE
								}
					)
	public ResponseEntity<User> update(@RequestBody User entity) {
		try {
			this.addInfoHeaders();
			Optional<User> user = userService.findOne(entity.getId());
			if (user.get() != null) {
				user.get().getId();
				user.get().setUsername(entity.getUsername());
				user.get().getPassword();
				user.get().setFirst_name(entity.getFirst_name());
				user.get().setLast_name(entity.getLast_name());
				user.get().getEmail();
				user.get().setImage(entity.getImage());
				user.get().setDescription(entity.getDescription());
				
				return new ResponseEntity<User>(userService.save(user.get()), headers, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}


	@Override
	@RequestMapping(value="/account/{id}/delete", method=RequestMethod.DELETE, 
					produces= {
								MediaType.APPLICATION_JSON_UTF8_VALUE,
								MediaType.APPLICATION_XML_VALUE
								}
					)
	public ResponseEntity<String> deleteById(@RequestParam Long id) {
		try {
			this.addInfoHeaders();
			if (userService.existById(id)) {
				userService.deleteById(id);
				JsonObject message = new JsonObject();
				message.addProperty("message", "Successfully deleted account.");
				return new ResponseEntity<String>(message.toString(), headers, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	
	@Override
	@RequestMapping(value="/account/delete", method=RequestMethod.DELETE, 
					produces= {
								MediaType.APPLICATION_JSON_UTF8_VALUE,
								MediaType.APPLICATION_XML_VALUE
								}
					)
	public ResponseEntity<String> delete(@RequestBody User entity) {
		try {
			this.addInfoHeaders();
			if (userService.existById(entity.getId())) {
				userService.delete(entity);
				JsonObject message = new JsonObject();
				message.addProperty("message", "Successfully deleted account.");
				return new ResponseEntity<String>(message.toString(), headers, HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}
	
	

	
	private void addInfoHeaders() {
		headers = new LinkedMultiValueMap<String, String>();
		if (context.getServerPort() > 0) {
			headers.add("Location", context.getScheme() + "://" + context.getServerName() + ":" + context.getServerPort() + context.getRequestURI());
		} else {
			headers.add("Location", context.getScheme() + "://" + context.getServerName() + context.getRequestURI());
		}	
	}


	
	
	//////////////////////////////////////////////////////////////////////////////////////
	
	

	@Override
	@RequestMapping(value="/users", method=RequestMethod.GET, 
					produces= {
								MediaType.APPLICATION_JSON_UTF8_VALUE,
								MediaType.APPLICATION_XML_VALUE
								}
					)
	public ResponseEntity<List<User>> findAll() {
		//return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		try {
			this.addInfoHeaders();
			if (userService.findAll().isEmpty()) {
				return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<User>>(userService.findAll(), headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


}
	


	
	
	

