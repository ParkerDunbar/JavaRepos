package group.dbt330.wikipedia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.StatementResult;

import com.mysql.jdbc.Statement;

public class creatingConnection {

	public static void main(String[] args) {
		SSH_Connection ssh = new SSH_Connection();
		ssh.createSSH();
		java.sql.Connection sshSQL = ssh.createSQLSSH();
		ssh.createNeo4jSSH();
		System.out.println("SSH");

		Neo4j_Database_Connection neo = new Neo4j_Database_Connection();

		String startid = "Banjo";
		try {
			Statement test = (Statement) sshSQL.createStatement();
			test.execute("use wiki");
			System.out.println("Query Start");
			String id = mysqlQueryRun.getIDWithName(startid, test);
			ResultSet set = mysqlQueryRun.getToPagesIDWithFromPageID(id, test);
			System.out.println("Query Done");
			Driver driver = ssh.openNeoDriver();
			while (set.next()) {
				StatementResult result = neo.create_connection_for_wikilab(id, set.getString("page_to_id"), driver);
				System.out.println(set.getString("page_to_id"));
				while(result.hasNext()) {
					System.out.println("Create Node: " + result.next());
				}
			}
			driver.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		ssh.disconnectSSH();
	}

}
