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
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Map<String, String> credentials = new HashMap<>();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("registerusername");
		String password = request.getParameter("registerpassword");

		RequestDispatcher d = request.getRequestDispatcher("");
		if(username.length() != 0 && password.length() != 0) {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			d = request.getRequestDispatcher("registerok.jsp");
		}
		else {
			d = request.getRequestDispatcher("registerfail.jsp");
		}
		d.forward(request, response);
	}

}
