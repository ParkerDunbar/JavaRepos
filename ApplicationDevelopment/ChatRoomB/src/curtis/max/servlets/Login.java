package curtis.max.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import curtis.max.Datastore.DatabaseConnection;
import curtis.max.model.users.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String UserName = request.getParameter("UserName");
		//check fields are null if display error and let them re-enter 
		if (UserName == null || UserName.isEmpty()) {
		
		} else {
			//check if the User is in the database if not display error and let them re-enter 
			
			//if the user is valide send them to the chat room
			session.setAttribute("UserName", UserName);
			request.getRequestDispatcher("chatRoom.jsp").forward(request, response);
		}
	}

}
