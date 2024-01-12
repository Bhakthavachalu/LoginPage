<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	
	<h1>Login Page</h1>
	<form action="LoginServlet" method="post">
		Username <input type="text" name="n1"><br><br>
		password <input type="password" name="n2"><br><br>
		<input type="submit"><br><br>
	</form>
	
	<a href="update.jsp"> Update Password </a><br>
	<a href="forgot.jsp"> Forgot Password </a><br>
	<a href="delete.jsp"> Delete Account </a><br>
	
</body>
</html>