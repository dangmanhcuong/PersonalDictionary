package javass20142.dictionary.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.DefaultListModel;

public class Databases {
	private String url;
	private String user;
	private String password;
	private Connection connection = null;
	private Statement statement = null;

	public void initiAndConnectDB() {
		// get account information connected database
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("database.properties"));
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			// Register JDBC driver
			try {
				Class.forName("com.mysql.jdbc.Driver");
				// Open a connection
				if (connection == null)
					connection = DriverManager.getConnection(url, user,
							password);
				if (statement == null)
					createStatement();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// test connections in console
		// System.out.println(url);
		// System.out.println(user + "   :  " + password);
		// System.out.println("successful connections...");
	}

	// make the statement to interact with databases
	public void createStatement() {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println("successful create Statement...");
	}

	public ResultSet getResult(String sqlcmd) {
		try {
			ResultSet re = statement.executeQuery(sqlcmd);
			return re;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> getListWordEN(String tblName, String colName) {
		ArrayList<String> listWord = new ArrayList<String>();
		initiAndConnectDB();
		ResultSet rSet = getResult("SELECT " + colName + " FROM `dictionary`.`"
				+ tblName + "`");
		try {
			while (rSet.next()) {
				listWord.add(rSet.getString(colName));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listWord;

	}

	public void upDateData(String sql) {
		// initiAndConnectDB();
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("successful update Data...");
	}

	public void closeColection() throws SQLException {
		// TODO Auto-generated method stub
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		System.out.println("connection closed...");
	}

//	public void insertDB(String wordEN, String wordVI) {
//		String sql = "INSERT INTO `dictionary`.`tb_dictionary` (`wordEN`, `wordVI`) VALUES ('"
//				+ wordEN + "', '" + wordVI + "')";
//		upDateData(sql);
//		System.out.println("Inserted records into the table...");
//
//	}

	public void insertDB2(String dbName, String wordEN, String wordVI) {
		String sql = "INSERT INTO `dictionary`.`tbl_word" + dbName
				+ "` (`wordEN`, `wordVI`) VALUES ('" + wordEN + "', '" + wordVI
				+ "')";
		System.out.println(sql);
		upDateData(sql);
		// System.out.println("Inserted records into the table...");

	}

	public int getWordID(String wordEN) {
		initiAndConnectDB();
		ResultSet rSet = getResult("SELECT DISTINCT wordID FROM `dictionary`.`tbl_word"
				+ wordEN.charAt(0) + "`" + " WHERE wordEN='" + wordEN + "'");
		try {
			while (rSet.next()) {
				return rSet.getInt("wordID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}

	public void upDateDB(int wordID, String wordEN, String wordVI) {
		String sql = "UPDATE `dictionary`.`tbl_word" + wordEN.charAt(0) + "`"
				+ " SET `wordEN` ='" + wordEN + "', `wordVI`='" + wordVI
				+ "' WHERE `wordID`='" + wordID + "'";
		// System.out.println(sql);
		upDateData(sql);
	}

	public String getwordVI(String tblName, String wordEN) {
		initiAndConnectDB();
		ResultSet rSet = getResult("SELECT DISTINCT wordVI FROM `dictionary`.`"
				+ tblName + "`" + " WHERE wordEN='" + wordEN + "'");
		try {
			while (rSet.next()) {
				return rSet.getString("wordVI");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

//	public void filterWord(String tblName, String stringFilter) {
//		ResultSet rSet = getResult("SELECT wordEN FROM `dictionary`.`"
//				+ tblName + "`" + " WHERE wordEN LIKE '" + stringFilter + "%'");
//		try {
//			while (rSet.next()) {
//				String aString = rSet.getString("wordEN");
//				System.out.println(aString);
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public DefaultListModel<String> filterWord2(String tblName,
			String stringFilter) {
		initiAndConnectDB();
		DefaultListModel<String> aDefaultListModel = new DefaultListModel<>();
		ResultSet rSet = getResult("SELECT wordEN FROM `dictionary`.`tbl_word"
				+ tblName + "`" + " WHERE wordEN LIKE '" + stringFilter
				+ "%' LIMIT 50");
		try {
			while (rSet.next()) {
				String aString = rSet.getString("wordEN");
				aDefaultListModel.addElement(aString);
			}
			return aDefaultListModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> filterWord2l(String tblName, String stringFilter) {
		initiAndConnectDB();
		ArrayList<String> arrayList = new ArrayList<>();
		ResultSet rSet = getResult("SELECT wordEN FROM `dictionary`.`tbl_word"
				+ tblName + "`" + " WHERE wordEN LIKE '" + stringFilter
				+ "%' LIMIT 50");
		try {
			while (rSet.next()) {
				String aString = rSet.getString("wordEN");
				arrayList.add(aString);
			}
			return arrayList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
