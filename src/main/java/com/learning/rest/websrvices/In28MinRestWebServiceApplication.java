package com.learning.rest.websrvices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class In28MinRestWebServiceApplication {

	
	//Error type 406 is comes when data format is not acceptable
	
	
	public static void main(String[] args) {
		SpringApplication.run(In28MinRestWebServiceApplication.class, args);
	}
	
	
	
	@Bean
	public LocaleResolver localResolver() {
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		
		return  localeResolver;
	}
	
	
	//This can be set as in below code or in application properties using 
	//using spring.message.basename
	
	/*
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * 
	 * ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
	 * messageSource.setBasename("message"); return messageSource;
	 * 
	 * 
	 * }
	 */

}
