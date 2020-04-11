package com.learning.rest.websrvices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learning.rest.websrvices.exception.UserNotFoundException;
import com.learning.rest.websrvices.helloWorld.HelloWorldBean;
import javax.validation.Valid;

@RestController
public class UserController {

	@Autowired
	UserDao userDaoService;

	@Autowired
	HelloWorldBean helloWorldBean;

	//retrive all users

	@RequestMapping(method=RequestMethod.GET, path="/getAllUsers")
	public List<User> retireveAllUser(){


		return userDaoService.findAll();
	}


	@RequestMapping(method=RequestMethod.POST, path="/createUser")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {

		User savedUser=userDaoService.saveUser(user);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build(); 

		
	}



	//get user by id
	@RequestMapping(method=RequestMethod.GET, path="/getUserById/{id}")
	public User getUserById(@PathVariable int id) {

     
		User user=userDaoService.findById(id);
		if(user==null) {
			throw new UserNotFoundException("User Id="+id);
		}

		return user;
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, path="/deleteUserById/{id}")
	public void deleteUserById(@PathVariable int id) {
		
		User user=userDaoService.deleteUserById(id);
		if(user==null) {
			throw new UserNotFoundException("User Id"+id);
		}
	}

	

}
