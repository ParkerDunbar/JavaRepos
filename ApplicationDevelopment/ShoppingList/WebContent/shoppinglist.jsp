<%@page import="dunbar.parker.csc280.Item"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String username = (String) session.getAttribute("username");
	if (username == null) {
		response.sendRedirect("loginfail.jsp");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping List</title>
</head>
<body>
	<H1>Welcome to your Shopping List, <%out.println(session.getAttribute("username")); %></H1>
	<H3>Enter information about each item in the fields, and then
		press submit to add it to the list.</H3>
	<form method="POST" action="ItemAdd">
		<label>Name:</label> <input type="text" name="itemname" /> <br>
		<label>Description:</label> <input type="text" name="itemdesc" /> <br>
		<label>Quantity:</label> <input type="text" name="itemqty" /> <br>
		<label>Price: </label> <input type="text" name="itemprice" /> <br>
		<input type="submit" value="Add" />
	</form>
	<br>
	<form method="POST" action="ItemEdit">
		<label>Item #</label> <input type="text" name="editItemNumber" /> <br>
		<label>Attribute Name</label> <input type="text" name="editAttributeName" /> <br>
		<label>Attribute Edit</label> <input type="text" name="editAttribute" /> <br>
		<input type="submit" value="Edit" />
	</form>
	<br>
	<form method="POST" action="ItemDelete">
		<label>Item #</label> <input type="text" name="deleteItemNumber" /> <br>
		<input type="submit" value="Delete" />
	</form>
	<ul>
	<%
	
	List<Item> item = (ArrayList) session.getAttribute("itemlist");
	if(item != null) {
		for(int i=0; i<item.size(); i++) {
			out.print("<li>" + item.get(i).toString() + "</li>");
		}
	}
	else {
		out.println("No lists");
	}

	%>
	</ul>
		
</body>
</html>