package com.app.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;



public class JWTUtil {
	
//	public static void main(String a[]) {
//		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJTRUMtQSIsInN1YiI6InBpZWJ5dHdvMDE0QGdtYWlsLmNvbSIsInVzZXJOYW1lIjoiQXl1c2giLCJ1c2VyUGhvbmUiOiIxMjM0NTYiLCJpYXQiOjE3NjM3MjExNTMsImV4cCI6MTc2MzcyMTI3M30._9nICEADx7CnudXFPAS8acde-0Smb4ao-nTREPDWOgM";
////		createJWT("piebytwo014@gmail.com", "Ayush", "123456");
//		verifyJWT(token);
//	}
	
	static String secret = "thisistopsecret";
	
	static Algorithm a = Algorithm.HMAC256(secret);
	
	static long duration = 10 * 60 * 1000; // this is 10 mins in mili Sec
	
	static Date currentDate = new Date();
	static long currentTime = currentDate.getTime();
	static Date expireDate = new Date(currentTime + duration);
	
	
	//this function is used to create a JWT token which expires in 10 mins
	public static String createJWT(String email, String name, int OTP) {
		String JWTToken = JWT.create()
		.withIssuer("SEC-A")
		.withSubject(email)
		.withClaim("userName", name)
		.withClaim("emailOTP", OTP)
		.withIssuedAt(currentDate)
		.withExpiresAt(expireDate)
		.sign(a);
		return JWTToken;
	}
	
	public static void verifyJWT(String token) {
		try {
			DecodedJWT decodedToken = JWT.require(a)
			.build()
			.verify(token);
			System.out.println("THE TOKEN IS VALID");
			System.out.println("The email add is " + decodedToken.getSubject());
			System.out.println("User name is " + decodedToken.getClaim("userName"));
			System.out.println("Phone Number is " + decodedToken.getClaim("userPhone"));
			System.out.println("Token is issued at" + decodedToken.getIssuedAt());
			System.out.println("Token will expire at" + decodedToken.getExpiresAt());
		} catch (Exception e) {
			System.out.println("TOKEN IS EXPIRED");
		}
		
		
	}
}
