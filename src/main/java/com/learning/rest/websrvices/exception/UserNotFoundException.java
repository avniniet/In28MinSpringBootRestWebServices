package com.learning.rest.websrvices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)//For giving specific status code in case if customer exception
public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
		
	}
	
	
	
	

}
