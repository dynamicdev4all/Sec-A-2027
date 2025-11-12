package com.app.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shadow.org.bson.Document;

import java.io.IOException;
import java.lang.annotation.Documented;

import com.app.database.DatabaseConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Data rec from login page");
		String emailAdd = request.getParameter("email_key");
		String password = request.getParameter("password_key");
		
		Document loginUser =  DatabaseConnection.loginUser(emailAdd);
		
		if(loginUser != null) {
			if(emailAdd.equals(loginUser.getString("userEmail")) && password.equals(loginUser.getString("userPassword")) && loginUser.getBoolean("isVerified")) {
				HttpSession session = request.getSession();
				String name = loginUser.getString("firstName") + " " + loginUser.getString("lastName");
				session.setAttribute("username_key", name);
				response.sendRedirect("home.jsp");
			}else if(emailAdd.equals(loginUser.getString("userEmail")) && password.equals(loginUser.getString("userPassword")) && !loginUser.getBoolean("isVerified")) {
				System.out.println("The account in not verified");
			}
			else {
				System.out.println("Password is invalid");
			}
		}else {
			System.out.println("No Account Found");
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
