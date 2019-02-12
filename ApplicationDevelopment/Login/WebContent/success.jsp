<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
String username = (String)session.getAttribute("username");
if(username == null) {
	response.sendRedirect("fail.jsp");
//	request.getRequestDispatcher("fail.jsp").forward(request, response);
//	return;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Calendar now = Calendar.getInstance();
		out.println(now.getTime().toString());
	%>
	<h1>
		<span style="color: darkblue;">Welcome <% out.println(request.getAttribute("username")); %></span>
	</h1>
</body>
</html>