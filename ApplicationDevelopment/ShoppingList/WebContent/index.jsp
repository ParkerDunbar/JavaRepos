<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping List</title>
</head>
<body>
<H1>Shopping List</H1>
	<form method="POST" action="Login">
	<p>Log In</p>
		<label>Username:</label>
		<input type="text" name="loginusername" />
		<label>Password:</label>
		<input type="password" name="loginpassword" />
		<input type="submit" value="Log In"/>
	</form>
	<H3>OR</H3>
	<form method="POST" action="Register">
		<p>Register a new user</p>
		<label>Username:</label>
		<input type="text" name="registerusername" />
		<label>Password:</label>
		<input type="password" name="registerpassword" />
		<input type="submit" value="Register"/>
		</form>
</body>
</html>