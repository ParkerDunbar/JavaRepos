<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<H1>Register</H1>
	<%
		String errMsg = null;
		if (session != null && (errMsg = (String) session.getAttribute("error-msg")) != null) {
	%>
	<div style="color: red"><%=errMsg%></div>
	<%
		session.removeAttribute("error-msg");
		}
	%>
	<form method="POST" action="RegisterUser">
		<label>Username</label> <input type="text" name="username"> <br>
		<label>Password</label> <input type="password" name="password"> <br>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>