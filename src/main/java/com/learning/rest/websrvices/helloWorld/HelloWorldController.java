package com.learning.rest.websrvices.helloWorld;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController implements ErrorController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	@RequestMapping(method=RequestMethod.GET,  path = "/helloWorldBean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Sample Message");
	}
	
	
	@RequestMapping("/error")
	public String handleError(HttpServletResponse response,HttpServletRequest request) {
		
		return response.getStatus()+"-"+"Error occurred during opening"+request.getRequestURI();
		
	}
	
	@RequestMapping(method=RequestMethod.GET ,path = "/helloWorld/PathVariable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s", name));
	}


	@Override
	public String getErrorPath() {
		
		return "/error";
	}

}
