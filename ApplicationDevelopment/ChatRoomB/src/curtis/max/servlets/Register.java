package curtis.max.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curtis.max.Datastore.DatabaseConnection;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String UserName = request.getParameter("UserName");
		if (UserName == null || UserName.isEmpty()) {
			// check if fields are null if are display error and allow for re-entry
		} else {
			// check if the "User Name" is "Taken" in the database if true display error and alow for re-entry
			// if all filds are valid store user in the the database 
			// send them to the Chatroom 
			session.setAttribute("UserName", UserName);
			request.getRequestDispatcher("ChatRoom").forward(request, response);

		}
	}

}
