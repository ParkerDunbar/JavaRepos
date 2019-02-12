package dunbar.parker.csc180.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HelloJDBC {

	public static void main(String[] args) throws SQLException {
		String jdbcConnectionString =
				"jdbc:mysql://localhost/mydb?autoReconnect=true&useSSL=false";
		
		try (Connection con = DriverManager.getConnection(jdbcConnectionString, "myuser", "testtest")) {
			
			createTable(con);
			System.out.println("Table created successfully");
			insertRecords(con);
			System.out.println("Records Inserted successfully");
			updateRecord(con, 3, "CSC180", "awesome@student.neumont.edu");
			System.out.println("Records Updated successfully");
			printRecords(con);
		}
	}

	private static void printRecords(Connection con) throws SQLException {
		String sql =
				"SELECT * FROM mytable ORDER BY myname DESC";
		try (ResultSet results = con.createStatement().executeQuery(sql)) {
			while(results.next()) {
				System.out.println(
						"ID=" + results.getInt("myid") + ", " +
						"Name='" + results.getString("myname") + "', " + 
						"Email='" + results.getString("myemail") + "', ");
			}
		}
	}

	private static void updateRecord(Connection con, int id, String newName, String newEmail) throws SQLException {
		String sql =
				"UPDATE mytable SET myname=?, myemail=? " +
				"WHERE myid=?";
		PreparedStatement s = con.prepareStatement(sql);
		s.setString(1, newName);
		s.setString(2, newEmail);
		s.setInt(3, id);
		s.execute();
	}

	private static void insertRecords(Connection con) throws SQLException {
		String sql = "INSERT INTO mytable (myname, myemail) " +
						"VALUES (?, ?)";
		
		PreparedStatement s = con.prepareStatement(sql);
		
		for(int i=0;i<10;i++) {
			s.setString(1, "Name-" + (i + 1));
			s.setString(2, "name@email" + (i + 1) + ".com");
			s.execute();
		}
	}

	private static void createTable(Connection con) throws SQLException {
		String sql =
			"CREATE TABLE `mytable` ( " +
			"`myid` INT NOT NULL AUTO_INCREMENT, " +
			"`myname` VARCHAR(255) NOT NULL, " +
			"`myemail` VARCHAR(255) NOT NULL, " +
			"PRIMARY KEY (`myid`))";
		
		con.createStatement().executeUpdate(sql);
	}

}
