package com.roberto.jpa.sysnews.controller.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

public class HomeControllerImpl {
	
	@Autowired 
	private HttpServletRequest context;
	
	private static MultiValueMap<String, String> headers;
	
	@RequestMapping(value="/")
	public ResponseEntity<String> welcome() {
		try {
			this.addInfoHeaders();
			return new ResponseEntity<String>("Hello!!", headers ,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private void addInfoHeaders() {
		headers = new LinkedMultiValueMap<String, String>();
		if (context.getServerPort() > 0) {
			headers.add("Location", context.getScheme() + "://" + context.getServerName() + ":" + context.getServerPort() + context.getRequestURI());
		} else {
			headers.add("Location", context.getScheme() + "://" + context.getServerName() + context.getRequestURI());
		}	
	}

}
