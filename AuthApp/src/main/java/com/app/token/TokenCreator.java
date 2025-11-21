package com.app.token;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class TokenCreator {
	public static void main(String a[]) {
		createJWT();
	}
	
	static String secret = "thisistopsecret";
	
	static Algorithm a = Algorithm.HMAC256(secret);
	
	static long duration = 10 * 60 * 1000; // this is 10 mins in mili Sec
	static long currentTime = new Date().getTime();
	static Date d = new Date(currentTime + duration);
	
	
	static long expireTime = currentTime + duration;
	public static void createJWT() {
		String JWTToken = JWT.create()
		.withSubject("piebytwo014@gmail.com")
		.withExpiresAt(d)
		.sign(a);
		System.out.println(JWTToken);
	}
	
	public static void verifyJWT() {
		
	}
}
