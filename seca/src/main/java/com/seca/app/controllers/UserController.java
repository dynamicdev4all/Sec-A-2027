package com.seca.app.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seca.app.dto.UserLoginDTO;
import com.seca.app.dto.UserLoginResDTO;
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
	public String login(@PathVariable UserLoginDTO uDTO ) {
		
		User user = repo.login(uDTO.getId(), uDTO.getEmail(), uDTO.getPass());
		if(user != null) {
			UserLoginResDTO lDto = new UserLoginResDTO(HttpStatus.OK, "name", "email", 1, "gender");
			return lDTO;
		}
		return "Login Failed.";
	}
}
