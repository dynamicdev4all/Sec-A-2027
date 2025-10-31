package com.app.util;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailUtil {
	public static boolean sendRegisterOTP(String to, String userName, int OTP) {
		String senderEmail = "piebytwo014@gmail.com";
		String senderPassword = "oszxwqqplagxqgkx";
		
		
		Properties emailProperties = new Properties();
		emailProperties.put("mail.smtp.host", "smtp.gmail.com");
		emailProperties.put("mail.smtp.port", "587");
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		
		Authenticator emailAuth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {	
				return new PasswordAuthentication(senderEmail, senderPassword);
			}
		};
		
		
		Session emailSession = Session.getInstance(emailProperties, emailAuth);
		
		
		Message emailMsg = new MimeMessage(emailSession);
		try {
			emailMsg.setFrom(new InternetAddress(senderEmail));
			emailMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			emailMsg.setSubject("Welcome Onboard.");
			emailMsg.setText("Hello, " +userName+". \n\n"
							+"Your One Time Password (OTP) is : " + OTP+". \n\n"
							+"This OTP will expire in next 10 mins. \n\n"
							+"Note : Do not share this OTP with anyone. \n\n"
							+"Best Regards. \n"
							+"Team Sec-A.");
			Transport.send(emailMsg);
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
