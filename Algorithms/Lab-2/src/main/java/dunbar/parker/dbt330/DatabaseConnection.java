package dunbar.parker.dbt330;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseConnection {

	public static String DatabaseConnetionString = "jdbc:sqlserver://localhost;databaseName=DBT330;integratedSecurity=true";
	public static final String DIRVERNAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public static void setConString(String con) {
		DatabaseConnetionString = con;
	}

	public static String getDatabaseConnetionString() {
		return DatabaseConnetionString;
	}

	public static String getDRIVERNAME() {
		return DIRVERNAME;
	}

	/**
	 * 
	 * @param table
	 *            the table to be selected from
	 * @param columns
	 *            the column you wish to select if no column is given all columns
	 *            will be selected
	 * @return the reslut of the query
	 */
	public static String SelectFromTable(String table, String... columns) {
		String sql = "Select ";
		String query = "";
		int size = columns.length;
		if (columns.length > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql += columns[i];
				if (i != size - 1) {
					sql += ",";
				}
			}
		}
		sql += " From ";
		sql += table;
		try {
			Class.forName(getDRIVERNAME());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(sql + "\n" + "Driver");
		}
		try (Connection connection = DriverManager.getConnection(getDatabaseConnetionString())) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					ResultSetMetaData meta = resultSet.getMetaData();
					int columnLength = meta.getColumnCount();
					while (resultSet.next()) {
						for (int i = 1; i <= columnLength; i++) {
							query += resultSet.getString(i);
							if (i > 1) {
								query += ",";
							}
						}
					}
					connection.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql + "\n" + query);
		}
		return query;
	}

	/**
	 * 
	 * @param table
	 *            the table being selected from
	 * @param whereValue
	 *            Where "Value" =
	 * @param whereEquils
	 *            = "Equils"
	 * @param columns
	 *            the column you wish to select if no column is given all columns
	 *            will be selected
	 * @return
	 */
	public static String SelectWithWhereFromTable(String table, String whereValue, String whereEquils,
			String... columns) {
		String sql = "Select ";
		int size = columns.length;
		if (size > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql += columns[i];
				if (i != size - 1) {
					sql += ",";
				}
			}
		} else {
			sql += " * ";
		}
		sql += " From ";
		sql += table;
		sql += " Where ";
		sql += whereValue;
		sql += " = '";
		sql += whereEquils;
		sql += "'";
		String query = "";
		try {
			Class.forName(getDRIVERNAME());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(sql + "\n" + "Driver");
		}
		try (Connection connection = DriverManager.getConnection(getDatabaseConnetionString())) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					ResultSetMetaData rMetaData = resultSet.getMetaData();
					int columnLength = rMetaData.getColumnCount();
					while (resultSet.next()) {
						for (int i = 1; i >= columnLength; i++) {
							query += resultSet.getString(i);
							if (i > 1) {
								query += ",";
							}
						}
					}
					connection.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql + "\n" + query);
		}
		return query;
	}

	public static String SelectFriendsList(String table, String whereValue, String whereEquils, String... columns) {
		String sql = "Select ";
		int size = columns.length;
		if (size > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql += columns[i];
				if (i != size - 1) {
					sql += ",";
				}
			}
		} else {
			sql += " * ";
		}
		sql += " From ";
		sql += table;
		sql += " Where ";
		sql += whereValue;
		sql += " = '";
		sql += whereEquils;
		sql += "'";
		String query = "";
		try {
			Class.forName(getDRIVERNAME());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(sql + "\n" + "Driver");
		}
		try (Connection connection = DriverManager.getConnection(getDatabaseConnetionString())) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				try (ResultSet resultSet = statement.executeQuery()) {
					ResultSetMetaData rMetaData = resultSet.getMetaData();
					int columnLength = rMetaData.getColumnCount();
					while (resultSet.next()) {
						query = resultSet.getString(columnLength);
					}
					connection.close();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql + "\n" + query);
		}
		return query;
	}
	
	public static boolean InsertIntoTableBulk(String table, String values, String[] columns) {
		String sql = "Insert into " + table + " (";
		if (columns.length > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql += columns[i];
				if (i != columns.length - 1) {
					sql += ",";
				}
			}
			sql += ")";
		} else {
			sql = "";
		}
		sql += " Values ";
		sql += values;
		
		try {
			Class.forName(getDRIVERNAME());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection(getDatabaseConnetionString())) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.executeQuery();
			}
		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println(sql);
			return false;
		}
		return true;
	}

	public static boolean InsertIntoTable(String table, String[] values, String[] columns) {
		String sql = "Insert into " + table + " (";
		if (columns.length > 0) {
			for (int i = 0; i < columns.length; i++) {
				sql += columns[i];
				if (i != columns.length - 1) {
					sql += ",";
				}
			}
			sql += ")";
		} else {
			sql = "";
		}
		sql += " Values (";
		if (values.length > 0) {
			for (int i = 0; i < values.length; i++) {
				boolean vchar = false;
				for(int j = 0; j < values[i].length(); j++) {
					if(values[i].charAt(j) > 64 && values[i].charAt(j) < 123) {
						vchar = true;
					}
				}
				if(vchar) {
					sql += "'";
				}
				sql += values[i];
				if(vchar) {
					sql += "'";
				}

				if (i != values.length - 1) {
					sql += ",";
				}
			}
			sql += ")";
		} else {
			sql = "";
		}
		try {
			Class.forName(getDRIVERNAME());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection(getDatabaseConnetionString())) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
			return false;
		}
		return true;
	}

	public static boolean InsterIntoTableWithWhere(String table, String[] values, String[] columns, String where,
			String wherevalue) {
		return false;
	}

	public static boolean Createtable(String tableName, String[] columnNames, String[] datatypes) {
		String sql = "Create table ";
		sql += tableName + "(";
		for (int i = 0; i < columnNames.length; i++) {
			sql += columnNames[i] + " ";
			sql += datatypes[i];
			if (i != datatypes.length - 1) {
				sql += ",";
			}
		}
		sql += ")";
		// System.out.println(sql);
		try (Connection connection = DriverManager.getConnection(getDatabaseConnetionString())) {
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(sql);
			return false;
		}
		return true;
	}
}
