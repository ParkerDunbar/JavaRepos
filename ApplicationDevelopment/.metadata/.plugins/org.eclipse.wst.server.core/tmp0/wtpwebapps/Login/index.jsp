<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome, please log in</title>
</head>
<body>
	<form method="POST" action="doLogin">
		<label>Username:</label>
		<input type="text" name="username" />
		<label>Password:</label>
		<input type="password" name="password" />
		<input type="submit" />
	</form>
</body>
</html>