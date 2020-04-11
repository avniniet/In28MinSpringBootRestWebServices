package com.learning.rest.websrvices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController /* implements ErrorController */ {
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	@RequestMapping(method=RequestMethod.GET,  path = "/helloWorldBean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Sample Message");
	}
	
	
	/*
	 * @RequestMapping("/error") public String handleError(HttpServletResponse
	 * response,HttpServletRequest request) {
	 * 
	 * return response.getStatus()+"-"+"Error occurred during opening"+request.
	 * getRequestURI();
	 * 
	 * }
	 */
	
	@RequestMapping(method=RequestMethod.GET ,path = "/helloWorld/PathVariable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s", name));
	}


	/*
	 * @Override public String getErrorPath() {
	 * 
	 * return "/error"; }
	 */

	@RequestMapping(method=RequestMethod.GET, path = "/helloWorldI18n")
	public String helloWorldInternationalize(/*
												 * @RequestHeader(value = "Accept-Language" , required = false) Locale
												 * locale
												 */) {
		
		return messageSource.getMessage("good.morning.message", null,LocaleContextHolder.getLocale());
	}
}
