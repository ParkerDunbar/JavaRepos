package dunbar.parker.csc280;

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

/**
 * Servlet implementation class JDBCReader
 */
@WebServlet("/jdbc")
public class JDBCReader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String sql = "Select * From test";
			response.getOutputStream().print("<ul>");
			Class.forName("com.mysql.jdbc.Driver");
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "user", "password")) {
				try(PreparedStatement statement = con.prepareStatement(sql)) {
					try(ResultSet results = statement.executeQuery()) {
						while(results.next()) {
							//DONT do this
							response.getOutputStream().print("<li>" + results.getString("name") + "</li>");
						}
					}
				}
			}
			response.getOutputStream().print("</ul>");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



}
