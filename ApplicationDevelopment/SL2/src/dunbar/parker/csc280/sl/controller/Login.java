package dunbar.parker.csc280.sl.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		if(username == null || username.isEmpty() || password == null || password.isEmpty() || 
				!DataStore.users.containsKey(username)) {
			session.setAttribute("error-msg", "Authentification failed. Try again");
			response.sendRedirect("Login");
			return;
		}
		
		session.setAttribute("user", DataStore.users.get(username));
		response.sendRedirect("ShoppingList");
	}

}