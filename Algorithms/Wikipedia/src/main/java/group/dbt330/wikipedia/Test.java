package group.dbt330.wikipedia;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.StatementResult;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.Statement;

public class Test {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "Rock1000"));
		org.neo4j.driver.v1.Session session = driver.session();
		StatementResult res = session.run("create (ee:Page {title: \"Tree\", id: 1})");
		while(res.hasNext()) {
			System.out.println(res.next());
		}
//		StatementResult res = session.run("Match (e:Page) where e.title = \"Tree\" return e");
//		while (res.hasNext()) {
//			System.out.println(res.next());
//		}
		
		driver.close();
		
//		try {
//			JSch jsch = new JSch();
//			Session session = jsch.getSession("root", "10.10.14.103", 22);
//			session.setConfig("StrictHostKeyChecking", "no");
//			session.setPassword("dbt230mongodb");
//			System.out.println("Establishing Connection...");
//            session.connect();
//            int assinged_port = session.setPortForwardingL(4321, "10.10.18.93", 3306);
//            System.out.println("SSH Connected");
//            System.out.println(assinged_port);
//            //10.10.16.25
//
//            
//			Class.forName("com.mysql.jdbc.Driver");
//			String test = "jdbc:mysql://localhost:" + assinged_port;
//			java.sql.Connection con = DriverManager.getConnection(test, "remote", "changeme");
//			Statement s = (Statement) con.createStatement();
//			s.execute("Use wiki");
//			ResultSet set = s.executeQuery("select * from pages limit 3");
//			while(set.next()) {
//				System.out.println(set.getString("page_title"));
//			}
//			con.close();
//			session.disconnect();
//		}
//		catch (Exception e){
//			e.printStackTrace();
//		}
	}
}