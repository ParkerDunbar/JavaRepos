<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("username")%> <!-- Shorthand to print -->
</title>
</head>
<body>
	<H1>
	You say your favorite move is '<%=session.getAttribute("favMovie") %>'
	</H1>
	<H1>
	Your actual favorite movie is '<%=session.getAttribute("realFavMovie") %>'
	</H1>
</body>
</html>