package dunbar.parker.csc280.sl.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dunbar.parker.csc280.sl.model.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HttpSession session = request.getSession(true);
		// session.setAttribute("error-msg", "You must enter registration information");
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null || password == null || DataStore.users.containsKey(username)) {
			session.setAttribute("error-msg", "You must enter valid information");
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return;
		}

		try {
			String sql = "Insert Into info (username, password) VALUES (" + username + ", " + password + ")";
			Class.forName("com.mysql.jdbc.Driver");
			try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "user", "password")) {
				try (PreparedStatement statement = con.prepareStatement(sql)) {
					statement.executeQuery();
				}
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		DataStore.users.put(username, new User(username, password));
		response.sendRedirect("Login");
	}

}
