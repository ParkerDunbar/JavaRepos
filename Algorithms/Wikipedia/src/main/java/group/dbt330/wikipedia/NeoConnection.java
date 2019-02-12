package group.dbt330.wikipedia;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.StatementResult;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class NeoConnection {

	public static void main(String[] args) {
		
		try {
//			JSch jsch = new JSch();
//			Session session = jsch.getSession("root", "10.10.14.103", 22);
//			session.setConfig("StrictHostKeyChecking", "no");
//			session.setPassword("dbt230mongodb");
//			System.out.println("Establishing Connection...");
//	        session.connect();
//	        int assinged_port = session.setPortForwardingL(4321, "10.10.17.4", 7687);
//	        System.out.println("SSH Connected");
//	        System.out.println(assinged_port);
//	        //10.10.16.25
	        
			Driver driver = GraphDatabase.driver("bolt://10.0.10.239:7687", AuthTokens.basic("neo4j", "Rock1000"));
			org.neo4j.driver.v1.Session neoSession = driver.session();
			StatementResult res = neoSession.run("create (ee:Page {title:\"test\"})");
			
			while(res.hasNext()) {
				System.out.println(res.next());
			}
			driver.close();
			//session.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
