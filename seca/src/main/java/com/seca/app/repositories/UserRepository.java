package com.seca.app.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.seca.app.models.User;

@Repository
public class UserRepository {
	
	/*
	  id : 2342435245
	  name : Anurag Yadav
	  phone : 123234
	  email : anurag@gmail.com
	  pass : 121212
	  deliveryAddress : RDEC, Ghaziabad, Duhai
	  paymentMode : UPI
	 */
	
	Map<Long, User> db = new HashMap<Long, User>();
	
	public User register(User newUser) {
		try {
			db.put(newUser.getId(), newUser);
			return newUser;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	public User login(long id, String email, String pass) {
		User loginUser = viewOne(id);
		if(loginUser != null) {
			if(loginUser.getEmail().equals(email) && loginUser.getPass().equals(pass)) {
				return loginUser;
			}
			else {
				return null;
			}
		}
		return null;
	}
	
	
	
	
	
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
	
	public ArrayList<User> viewAll() {
		return new ArrayList<User>(db.values());
	}
	
	public User viewOne(long id) {
		return db.get(id);
	}
}
