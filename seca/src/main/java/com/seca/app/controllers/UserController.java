package com.seca.app.controllers;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seca.app.models.User;
import com.seca.app.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	UserRepository repo;
	
	@PostMapping("/user/register")
	public String createUser(@RequestBody User newUser) {
		try {
			repo.register(newUser);
			return "Registration Successful.";
		} catch (Exception e) {
			return "Registration Failed.";
		}
	}
	
	
	@GetMapping("/user/showall")
	public ArrayList<User> showAll(){
		return repo.viewAll();
	}
	
	@GetMapping("/user/showone/{id}")
	public User showOne(@PathVariable long id) {
		return repo.viewOne(id);
	}
	
	@PostMapping("/user/login/{id}")
	public String login(@PathVariable long id, Map<String, String> loginUser) {
		
		User user = repo.login(id, loginUser.get("email"), loginUser.get("pass"));
		if(user != null) {
			return "Login Success.";
		}
		return "Login Failed.";
	}
}
