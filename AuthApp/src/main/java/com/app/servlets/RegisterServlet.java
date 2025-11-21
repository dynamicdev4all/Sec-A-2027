package com.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.app.database.DatabaseConnection;
import com.app.util.EmailUtil;
import com.app.util.JWTUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fName_key");
		String lastName = request.getParameter("lName_key");
		String emailAdd = request.getParameter("email_key");
		String password = request.getParameter("password_key");
		
		
		boolean saveDataStatus =  DatabaseConnection.insertUserData(firstName, lastName, emailAdd, password);
		
		if(saveDataStatus) {
			int OTP = (int)(Math.random() * 900000) + 100000;
			String token =  JWTUtil.createJWT(emailAdd, firstName + " " + lastName, OTP);
			boolean OTPSentStatus = EmailUtil.sendRegisterOTP(emailAdd, firstName + " " + lastName, token);
			if(OTPSentStatus) {
				HttpSession session = request.getSession();
				session.setAttribute("emailOTP", OTP);
				session.setAttribute("email", emailAdd);
				response.sendRedirect("verify_otp.html");
			}else {
				System.out.println("OTP sent Failed");
			}
		}else {
			System.out.println("Data Save Failed");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
