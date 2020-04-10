package com.learning.rest.websrvices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

	private static List<User> users= new ArrayList<User>();

	private static int userCount=7;

	static {
		users.add(new User(1, "Avnish", new Date()));
		users.add(new User(2, "Neetish", new Date()));
		users.add(new User(3, "Gyanu", new Date()));
		users.add(new User(4, "Bhanu", new Date()));
		users.add(new User(5, "Suraj", new Date()));
		users.add(new User(6, "Dheeru", new Date()));
		users.add(new User(7, "Manan", new Date()));
	}


	public List<User> findAll(){
		return users;
	}

	public User saveUser(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);

		return user;
	}

	public User findById(Integer id ) {

		for(User user: users) {
			if(user.getId()!=null && user.getId().equals(id)) {
				return user;
			}
		}

		return null;

	}


	public User deleteUserById(Integer id) {

		Iterator<User> iterator = users.iterator();

		while(iterator.hasNext()) {
			User user=(User) iterator.next();
			if(user.getId()!=null && user.getId().equals(id)){
				iterator.remove();
				return user;
			}

		}
		return null;
	}



}
