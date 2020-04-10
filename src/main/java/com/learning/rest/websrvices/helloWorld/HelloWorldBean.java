package com.learning.rest.websrvices.helloWorld;

import org.springframework.stereotype.Component;


@Component
public class HelloWorldBean {
	
	private String message;
	
	
	

	public HelloWorldBean() {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldNBean [message=" + message + "]";
	}
	
	
	
	

}
