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
 * Servlet implementation class LoginHandler
 */
@WebServlet({ "/LoginHandler", "/doLogin" })
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, String> credentials = new HashMap<>();
	private Map<String, String> favMovies = new HashMap<>();
	private Map<String, String> realFavMovies = new HashMap<>();
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
        super();
        credentials.put("test", "test1");
        credentials.put("parker", "test1");
        favMovies.put("parker", "Shrek");
        realFavMovies.put("parker", "Shrek 2");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String p = credentials.get(username);
		RequestDispatcher d = request.getRequestDispatcher("");
		if(p != null && p.equals(password)) {
//			request.setAttribute("username", username);
			HttpSession session = request.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("favMovie", favMovies.get(username));
			session.setAttribute("realFavMovie", realFavMovies.get(username));
			d = request.getRequestDispatcher("success.jsp");
		}
		else {
			d = request.getRequestDispatcher("fail.jsp");
		}
		d.forward(request, response);
	}

}
