package dunbar.parker.csc280;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String username = request.getParameter("loginusername");
	String password = request.getParameter("loginpassword");
	
	RequestDispatcher d = request.getRequestDispatcher("");
	if(username.equals(request.getSession().getAttribute("username")) && password.equals(request.getSession().getAttribute("password"))) {
		d = request.getRequestDispatcher("shoppinglist.jsp");
	}
	else {
		d = request.getRequestDispatcher("loginfail.jsp");
	}
	d.forward(request, response);
	}

}
