package group.dbt330.wikipedia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.driver.v1.Driver;

import com.jcraft.jsch.Session;
import com.mysql.jdbc.Statement;

public class Wikipedia {

	public static void main(String[] args) {
		SSH_Connection ssh = new SSH_Connection();
		ssh.createSSH();
		java.sql.Connection sshSQL = ssh.createSQLSSH();
		ssh.createNeo4jSSH();
		System.out.println("SSH");

		Neo4j_Database_Connection neo = new Neo4j_Database_Connection();

		List<String> ids = new ArrayList<String>();
		List<String> names = new ArrayList<String>();
		String query = "select * from pages limit 10000000,1000000";

		try {
			Statement test = (Statement) sshSQL.createStatement();
			test.execute("use wiki");
			System.out.println("Query Start");
			ResultSet set = test.executeQuery(query);
			System.out.println("Query Done");

			Driver driver = ssh.openNeoDriver();
			int counter = 0;
			CharSequence quote_check = "\"";
			CharSequence quote_replace = "\\\"";
			String replaceString = "";

			// while (set.next()) {
			//
			// if (set.getString("page_title").contains(quote_check)) {
			// replaceString = set.getString("page_title").replace(quote_check,
			// quote_replace);
			// driver.session().run("create (e:Wiki_Page {title:\"" + replaceString + "\",
			// id:"
			// + set.getString("page_id") + "})");
			// } else
			// driver.session().run("create (e:Wiki_Page {title:\"" +
			// set.getString("page_title") + "\", id:"
			// + set.getString("page_id") + "})");
			// if (++counter % 100 == 0) {
			// System.out.println(counter);
			// }
			// }

			int index = 1;
			while (set.next()) {
				ids.add(set.getString("page_id"));
				names.add(set.getString("page_title"));

				if (ids.size() >= 1000) {
					neo.create_Table_For_WikiLab(ids, names, driver);

					ids.clear();
					names.clear();

					if (index % 10 == 0) {
						System.out.println("Importing... " + index * 1000);

						Thread.sleep(500);
					}
					index++;
				}
				// System.out.println("Added Node to List");
			}
			System.out.println("Last Import");
			// neo.create_Table_For_WikiLab(ids, names, driver);
			Thread.sleep(5000);
			System.out.println("Neo4j Driver Closing");
			driver.close();
			ids.clear();
			names.clear();
			System.out.println("Done");

		} catch (Exception e) {
			e.printStackTrace();
		}

		ssh.disconnectSSH();
	}
}
