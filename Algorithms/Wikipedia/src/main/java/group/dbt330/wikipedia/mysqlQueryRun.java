package group.dbt330.wikipedia;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class mysqlQueryRun {
	public static String getIDWithName(String startname, Statement statement) throws SQLException {
		System.out.println("startName");
		ResultSet set = statement
				.executeQuery("select page_id from pages where page_title='" + startname + "' limit 1");

		String id = "";
		while (set.next()) {
			id = set.getString("page_id");
		}

		return id;
	}

	public static ResultSet getToPagesIDWithFromPageID(String toID, Statement statement) throws SQLException {
		ResultSet result = statement.executeQuery("select page_to_id from links where page_from_id=" + toID + " limit 10");
		return result;
	}

}
