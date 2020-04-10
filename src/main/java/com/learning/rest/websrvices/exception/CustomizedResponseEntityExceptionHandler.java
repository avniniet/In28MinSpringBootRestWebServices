package com.learning.rest.websrvices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	
	
	
	@ExceptionHandler(UserNotFoundException.class ) public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex){

		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(),ex.getMessage(), ex.getLocalizedMessage()	);

		return new ResponseEntity(exceptionResponse,HttpStatus.NOT_FOUND);



	}
	 
	
	
	@ExceptionHandler(Exception.class  )
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest wsr){
		
		ExceptionResponse exceptionResponse=new ExceptionResponse(new Date(), ex.getMessage(), ex.getLocalizedMessage());
		
		return new ResponseEntity(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
		
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity(new ExceptionResponse(new Date(), ex.getMessage(), ex.getBindingResult().toString()),HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	

}
