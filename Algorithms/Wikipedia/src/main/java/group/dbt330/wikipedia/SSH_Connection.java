package group.dbt330.wikipedia;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.StatementResult;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.mysql.jdbc.Statement;

public class SSH_Connection {
	Session SSHSession;
	
	
	public void createSSH() {
		try {
			JSch jsch = new JSch();
			SSHSession = jsch.getSession("root", "10.10.14.103", 22);
			SSHSession.setConfig("StrictHostKeyChecking", "no");
			SSHSession.setPassword("dbt230mongodb");
			System.out.println("Establishing SSH Connection...");
			SSHSession.connect();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void createNeo4jSSH() {
		try {
	        int assinged_port = SSHSession.setPortForwardingL(4321, "10.10.16.192", 7687);
	        System.out.println("Neo SSH Created");
	        System.out.println(assinged_port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Driver openNeoDriver() {
        String connectionString = "bolt://localhost:4321";
		return GraphDatabase.driver(connectionString, AuthTokens.basic("neo4j", "Rock1000"));
	}
	
	public void disconnectSSH() {
		this.SSHSession.disconnect();
	}
	
	public java.sql.Connection createSQLSSH() {
		try {
			int assinged_port = SSHSession.setPortForwardingL(1234, "10.10.18.122", 3306);
			System.out.println("SSH SQL Created");
			System.out.println(assinged_port);

			Class.forName("com.mysql.jdbc.Driver");
			String connectionString = "jdbc:mysql://localhost:" + assinged_port;
			java.sql.Connection con = DriverManager.getConnection(connectionString, "remote", "changeme");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
