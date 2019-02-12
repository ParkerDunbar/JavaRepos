package group.dbt330.wikipedia;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

public class Neo4j_Database_Connection {

	private String URI;
	private String username;
	private String password;
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(org.neo4j.driver.v1.Driver driver) {
		this.session = driver.session();
	}

	private org.neo4j.driver.v1.Driver driver;

	public Neo4j_Database_Connection(String username, String password, String URI) {
		this.setUsername(username);
		this.setPassword(password);
		this.setURI(URI);
		this.setDriver();
		this.setSession(this.getDriver());
	}

	public Neo4j_Database_Connection() {

	}

	private void setDriver() {
		this.driver = GraphDatabase.driver(this.getURI(), AuthTokens.basic(this.getUsername(), this.getPassword()));
	}

	public org.neo4j.driver.v1.Driver getDriver() {
		return driver;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String uRI) {
		URI = uRI;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void getNode(String id, Driver driver) {
		Session session = driver.session();
		StatementResult res = session.run("match (a:Wiki_Page) where a.id=" + id + " return a;");

		while (res.hasNext()) {
			System.out.println("Response: " + res.next());
		}
	}

	public StatementResult create_connection_for_wikilab(String fromid, String toid, Driver driver) {
		Session session = driver.session();
		// System.out.println("match (a:Wiki_Page) where a.id=" + fromid + " match
		// (b:Wiki_Page) where b.id=" + toid + " create (a)-[r:Links_To]->(b) return
		// r");
		StatementResult res = session.run("match (a:Wiki_Page) where a.id=" + fromid
				+ "\n match (b:Wiki_Page) where b.id=" + toid + "\n create (a)-[r:Links_To]->(b) return r");
		return res;
	}

	public void create_Table_For_WikiLab(List<String> ids, List<String> names, Driver driver) throws Exception {
		Session session = driver.session();
		String command = "create ";
		if (ids.size() != names.size()) {
			throw new Exception("Not the same length");
		} else {
			for (int i = 0; i < names.size(); i++) {
				command += "(a" + i + ":Wiki_Page {title:" + "\"" + names.get(i) + "\", id:" + ids.get(i) + "})";
				if (i != names.size() - 1) {
					command += ", ";
				}

			}
			// command +=";";
			// System.out.println(command);
			session.run(command);
			// StatementResult response = session.run("MATCH p=()-[r:CONNECTS]->() RETURN p
			// LIMIT 1000");
			// while (response.hasNext()) {
			// System.out.println(response.next());
			// }
			// driver.close();
		}

	}

	public void create_Node(String table, String[] vars, String[] labels, String[] values) throws Exception {
		Session session = this.getSession();
		Driver driver = this.getDriver();
		String command = "create";
		if (labels.length != values.length && vars.length != labels.length) {
			throw new Exception();
		} else {
			for (int i = 0; i < values.length; i++) {
				command += "(" + vars[i] + ":" + table + "{" + labels[i] + ":" + "\"" + values[i] + "\"})";
				if (i != values.length - 1) {
					command += ",";
				}
			}
		}
		// \n"(ee)-[:CONNECTS]->(cc),\n"
		System.out.println(command);
		session.run(command);
		StatementResult response = session.run("MATCH p=()-[r:CONNECTS]->() RETURN p LIMIT 25");
		while (response.hasNext()) {
			System.out.println(response.next());
		}
		driver.close();
	}

	public static void main(String[] args) {
		// for (int k = 0; k < 800; k++) {
		// Neo4j_Database_Connection m = new Neo4j_Database_Connection("neo4j",
		// "Rock1000", "bolt://localhost:7687");
		// ArrayList<String> id = new ArrayList<>();
		// ArrayList<String> value = new ArrayList<>();
		// for (int i = 0; i < 5000; i++) {
		// id.add("" + i);
		// value.add("value" + i);
		// }
		// try {
		// m.create_Table_For_WikiLab(id, value);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// System.out.println(k + ":Times");
	}

	// // TODO Auto-generated method stub
	// System.out.println("Hello World");
	// org.neo4j.driver.v1.Driver driver =
	// GraphDatabase.driver("bolt://localhost:7687",
	// AuthTokens.basic("neo4j", "Rock1000"));
	//
	// Session session = driver.session();
	// session.run("Create (ee:Page {title: \"Tree\", id: 1}),\n" + "(cc:Page
	// {title: \"Bike\", id:2}),\n"
	// + "(ff:Page {title: \"Wheel\", id:3}),\n" + "(ee)-[:CONNECTS]->(cc),\n" +
	// "(cc)-[:CONNECTS]->(ff)");
	// StatementResult response = session.run("MATCH p=()-[r:CONNECTS]->() RETURN p
	// LIMIT 25");
	//
	// while (response.hasNext()) {
	// System.out.println(response.next());
	// }
	//
	// driver.close();
	// }

}
