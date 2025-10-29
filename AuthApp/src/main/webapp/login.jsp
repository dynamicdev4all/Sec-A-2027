<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
      String userName = (String) session.getAttribute("username_key");
      if(userName != null){
      	response.sendRedirect("home.jsp");
      }
      %>
    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome to the login page</h1>
<form action="LoginServlet" method="post">
	<label>Email Address : </label>
	<input type="email" placeholder="Email Address" required="required" name="email_key">
	<label>Password : </label>
	<input type="password" placeholder="password" required="required" name="password_key">
	<button type="sumbit">Login Now</button>
</form>
</body>
</html>