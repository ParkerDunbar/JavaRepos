package dunbar.parker.dbt330;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	public static Map<File, List<File>> dbFiles = new HashMap<File, List<File>>();
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		String url ="jdbc:sqlserver://localhost;integratedSecurity=true";
//		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		Connection conn = DriverManager.getConnection(url);
//		C:\Users\Parker Dunbar\Desktop\Databases\ap
		
		
		File dbDirectory = new File("C:\\Users\\Parker Dunbar\\Desktop\\Databases");
		
		File[] dbList = dbDirectory.listFiles();
		
		for(File f : dbList) {
			File[] dataFile = f.listFiles();
			List<File> dataFiles = new ArrayList<File>();
			for(File data : dataFile) {
				if(!(data.getAbsolutePath().endsWith(".txt") || data.getAbsolutePath().endsWith(".html"))) {
					dataFiles.add(data);
				}
			}
			dbFiles.put(f, dataFiles);
		}
		
		for(Map.Entry entry : dbFiles.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		for(Map.Entry entry : dbFiles.entrySet()) {
			List<File> a = dbFiles.get(entry.getKey());
			for(File path : a) {
				System.out.println(path.getName());
			}
		}

	}
}
