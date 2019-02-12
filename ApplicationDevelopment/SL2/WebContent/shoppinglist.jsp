<%@page import="dunbar.parker.csc280.sl.model.ShoppingList"%>
<%@page import="dunbar.parker.csc280.sl.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	User user = (User) session.getAttribute("user");
	if (user == null) {
		session.setAttribute("error-msg", "You must login before accessing the application");
		response.sendRedirect("Login");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=user.getUsername() + "'s Shopping Lists"%></title>
</head>
<body>
	<H1><%=user.getUsername() + "'s Shopping Lists"%></H1>
		<form method="POST" action="ShoppingList">
		<input type="text" name="newListName" />
		<input type="submit" name="New List" />
		</form>
	<ul>
		<%
			for (ShoppingList list : user.getShoppingLists()) {
		%>
		<li style="border: 1px solid red">
			<form method="POST" action="ShoppingList">
				<input type="hidden" name="http_method" value="delete" />
				<input type="hidden" name="list" value="<%=list.getName()%>" />
				<input type="submit" value="X" />
			</form> <a href="items?list=<%=list.getName()%>"><%=list.getName()%></a>
			<form method="POST" action="ShoppingList">
				<input type="hidden" name="http_method" value="put" />
				<input type="hidden" name="list" value="<%=list.getName()%>" />
				<input type="text" name="newName" />
				<input type="submit" value="Rename" />
			</form>
		</li>
		<%
			}
		%>
	</ul>
</body>
</html>