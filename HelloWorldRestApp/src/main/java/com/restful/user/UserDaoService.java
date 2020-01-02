package com.restful.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	// private static List users = (List) new ArrayList<User>();
	private static int userCount = 3;
	private static List<Object> users = new ArrayList<Object>();

	static {
		users.add(new User(1, "raj", new Date()));
		users.add(new User(2, "irshad", new Date()));
		users.add(new User(3, "alam", new Date()));
		users.add(new User(4, "samir", new Date()));
		users.add(new User(5, "asif", new Date()));
		users.add(new User(6, "aman", new Date()));
	
	}

	// find the list of users
	public List findAll() {
		return users;
	}

	// save and create the user
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	// find the specific user
	public User findOne(int id) {
		for (Object user : users) {
			if (((User) user).getId() == id) {
				return (User) user;
			}
		}
		return null;
	}

	// delete the specific id
	public User deleteById(int id) {
		
		Iterator<Object> iterator=users.iterator();
		while(iterator.hasNext()) {
			
			User user=(User) iterator.next();
			if (((User) user).getId() == id) {
				iterator.remove();
				return (User) user;
			}
		}
		
		return null;
	}
}



