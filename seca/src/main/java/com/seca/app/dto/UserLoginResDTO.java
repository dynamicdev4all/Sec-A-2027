package com.seca.app.dto;

import org.springframework.http.HttpStatusCode;

public class UserLoginResDTO {
	HttpStatusCode code;
	String name;
	String email;
	long id;
	String gender;
	
	public UserLoginResDTO(HttpStatusCode code, String name, String email, long id, String gender) {
		this.code = code;
		this.name = name;
		this.email = email;
		this.id = id;
		this.gender = gender;
	}
}
