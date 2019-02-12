package dunbar.parker.dbt330;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
	// "C:\Users\Max Curtis\Documents\Persitence App\ap\ap.contacts"
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static String[] heads;

	public static void main(String[] args) throws IOException {
		Parser p = new Parser();
		DatabaseConnection con = new DatabaseConnection();
		Map<File, List<File>> dbFiles = p.getDatabaseDirectory();
		for (Map.Entry entry : dbFiles.entrySet()) {
			List<File> a = dbFiles.get(entry.getKey());
			for (File path : a) {
				String[] t = p.getfile(path);
				if (t != null) {
					String[] dataType = p.parcetext(t);
					DatabaseConnection.Createtable(path.getName().replace(".", "_"), heads, dataType);
					insertData(path);
					
//					DatabaseConnection.InsertIntoTable(path.getName(), , heads);
				}
			}
		}
	}

	private static void insertData(File path) throws IOException {
		FileReader fileR = new FileReader(path);
		BufferedReader fr = new BufferedReader(fileR);
		String buffer = fr.readLine();
		buffer = fr.readLine();
		String valuesString = "";
		int rowCount = 0;
		int totalCount = 0;
		do {
			String[] values = buffer.split("\t");
			valuesString += "(";
			for(int i = 0; i < values.length; i++) {
				values[i] = values[i].trim();
				if(values[i].contains("-") || values[i].length() == 0) {
					values[i] = "null";
				}
				boolean vchar = false;
				for(int j = 0; j < values[i].length(); j++) {
					if(values[i].charAt(j) > 64 && values[i].charAt(j) < 123) {
						vchar = true;
						break;
					}
				}
				if(vchar && values[i] != "null") {
					valuesString += "'";
				}
				valuesString += values[i];
				if(vchar && values[i] != "null") {
					valuesString += "'";
				}
				if(i != values.length - 1) {
					valuesString += ","; 
				}
				else {
					valuesString += ")";
					rowCount++;
				}
			}
			if(rowCount == 1000) {
				DatabaseConnection.InsertIntoTableBulk(path.getName().replace(".", "_"), valuesString, heads);
				System.out.println(totalCount);
				totalCount++;
				valuesString = "";
				rowCount = 0;
			}
			buffer = fr.readLine();
			if(buffer != null && rowCount != 0) {
				valuesString += ",";
			}
			if(buffer == null) {
				DatabaseConnection.InsertIntoTableBulk(path.getName().replace(".", "_"), valuesString, heads);
			}
		}while(buffer != null);
		
	}

	private Map<File, List<File>> getDatabaseDirectory() {
		Map<File, List<File>> dbFiles = new HashMap<File, List<File>>();
		File dbDirectory = new File("C:\\Users\\Parker Dunbar\\Desktop\\Databases");
		File[] dbList = dbDirectory.listFiles();
		for (File f : dbList) {
			File[] dataFile = f.listFiles();
			List<File> dataFiles = new ArrayList<File>();
			for (File data : dataFile) {
				if (!(data.getAbsolutePath().endsWith(".txt") || data.getAbsolutePath().endsWith(".html")
						|| data.getAbsolutePath().endsWith(".contacts") || data.getAbsolutePath().endsWith(".duration")
						|| data.getAbsolutePath().endsWith(".selection"))) {
					dataFiles.add(data);
				}
			}
			dbFiles.put(f, dataFiles);
		}
		return dbFiles;

	}

	private String[] parcetext(String[] values) {
		String[] datatypes = new String[values.length];
		ArrayList<String> dataTypesName = new ArrayList<String>();
		dataTypesName.add("varChar(50)");
		dataTypesName.add("int");
		dataTypesName.add("varChar(3)");
		dataTypesName.add("float");
		dataTypesName.add("varChar(5)");
		ArrayList<String> regex = new ArrayList<String>();
		regex.add("[(A-Z)]{3}[(\\d)]{9}");
		regex.add("(^\\d{4}$)");
		regex.add("[(A-Z)]{1}[\\d]{2}");
		regex.add("^\\d+.?\\d{0,4}");
		regex.add("\\d+\\w+");
		int regexCounter = 0;
		for (int i = 0; i < values.length; i++) {
			Pattern p = Pattern.compile(regex.get(i % 5));
			Matcher m = p.matcher(values[i].trim());
			if (m.find()) {
				if (p.pattern() == regex.get(0)) {
					datatypes[i] = dataTypesName.get(0);
				} else if (p.pattern() == regex.get(1)) {
					datatypes[i] = dataTypesName.get(1);
				} else if (p.pattern() == regex.get(2)) {
					datatypes[i] = dataTypesName.get(2);
				} else if (p.pattern() == regex.get(3)) {
					datatypes[i] = dataTypesName.get(3);
				} else if (p.pattern() == regex.get(4)) {
					datatypes[i] = dataTypesName.get(4);
				} else {
					datatypes[i] = dataTypesName.get(0);
				}
			} else {
				datatypes[i] = dataTypesName.get(0);
			}
		}
		return datatypes;

	}

	private String[] getfile(File path) throws IOException {
		FileReader fileR = new FileReader(path);
		BufferedReader fr = new BufferedReader(fileR);
		String line1 = fr.readLine();
		heads = line1.split("\t");
		String line2 = fr.readLine();
		if (line2 != null) {
			String[] text = line2.split("\t");
			fr.close();
			return text;
		}
		fr.close();
		return null;
	}

}
