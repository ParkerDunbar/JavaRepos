package group.dbt330.wikipedia;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.Statement;

public class SQLConnection {

	public static void main(String[] args) {
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession("root", "10.10.14.103", 22);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword("dbt230mongodb");
			System.out.println("Establishing Connection...");
			session.connect();
			int assinged_port = session.setPortForwardingL(4321, "10.10.18.122", 3306);
			System.out.println("SSH Connected");
			System.out.println(assinged_port);
			// 10.10.16.25

			Class.forName("com.mysql.jdbc.Driver");
			String test = "jdbc:mysql://localhost:" + assinged_port;
			java.sql.Connection con = DriverManager.getConnection(test, "remote", "changeme");
			Statement s = (Statement) con.createStatement();
			s.execute("Use wiki");
			ResultSet set = s.executeQuery("select count(*) as shit from pages");
			while (set.next()) {
				System.out.println(set.getString("shit"));
			}
			con.close();
			session.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
