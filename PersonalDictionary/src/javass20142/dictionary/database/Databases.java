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
		System.out.println(url);
		System.out.println(user + "   :  " + password);
		System.out.println("successful connections...");
	}

	// make the statement to interact with databases
	public void createStatement() {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("successful create Statement...");
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

	public void upDateData(String sql) {
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("successful update Data...");
	}

	public void closeColection() throws SQLException {
		// TODO Auto-generated method stub
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		System.out.println("connection closed...");
	}

	// public void show(ResultSet rSet, String colum) throws SQLException {
	// while (rSet.next()) {
	// String string = rSet.getString(colum);
	// System.out.println(string);
	// }
	// }

	public void insertDB(int wordID, String wordEN, String wordVI) {
		String sql = "INSERT INTO `dictionary`.`tb_dictionary` (`wordID`, `wordEN`, `wordVI`) VALUES ("
				+ wordID + ", 'sjdw9sddf', 'f', 'g')";

		try {
			statement.executeUpdate(sql);
			// statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Inserted records into the table...");

	}

	public ResultSet selectRecord() {
		String sql = "SELECT wordID, wordEN, wordVI, wordNote FROM `dictionary`.`tbl_dictionary`";
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;

	}

	public String getwordVI(String wordEN) {
		ResultSet rSet = getResult("SELECT DISTINCT wordVI FROM `dictionary`.`tbl_dictionary`"
				+ " WHERE wordEN='" + wordEN + "'");
		try {
			while (rSet.next()) {
				return rSet.getString("wordVI");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wordEN;

	}

	public ArrayList<String> getListWord() {
		ArrayList<String> listWord = new ArrayList<String>();
		initiAndConnectDB();
		ResultSet rSet = getResult("SELECT wordEN FROM `dictionary`.`tb_dictionary`");
		try {
			while (rSet.next()) {
				listWord.add(rSet.getString("wordEN"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listWord;

	}

	// test class
	public static void main(String args[]) {
		Databases testDbUtils = new Databases();
		testDbUtils.initiAndConnectDB();
		testDbUtils
				.upDateData("UPDATE `dictionary`.`tb_dictionary` SET `wordVI`=' không ra gì' WHERE `wordID`='7'");
		try {
			testDbUtils.closeColection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ResultSet rs = testDbUtils.selectRecord();
		// ResultSet rs = testDbUtils
		// .getResult("SELECT wordID, wordEN, wordVI, wordNote FROM `dictionary`.`tbl_dictionary`");
		// try {
		// while (rs.next()) {
		// // Retrieve by column name
		// int id = rs.getInt("wordID");
		// String age = rs.getString("wordEN");
		// String first = rs.getString("wordVI");
		// String last = rs.getString("wordNote");
		//
		// // Display values
		// System.out.print("ID:     " + id);
		// System.out.print(", wordEN: " + age);
		// System.out.print(", wordVI: " + first);
		// System.out.println(", wordNote: " + last);
		// }
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// System.out.println();
		// testDbUtils
		// .upData("UPDATE `dictionary`.`tbl_dictionary` SET wordVI = 'hihi' WHERE wordEN = 'hello'");
		// ResultSet rSet = testDbUtils
		// .getData("SELECT  wordVI FROM dictionary.tbl_dictionary");
		// try {
		// testDbUtils.show(rSet, "wordVI");
		// testDbUtils.closeColection();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// testDbUtils.insertDB(196, "sdfafaa", "dsfa", "dssfa");
		// ResultSet rSet2 = testDbUtils
		// .getData("SELECT  wordEN FROM dictionary.tbl_dictionary");
		// try {
		// testDbUtils.show(rSet2, "wordEN");
		// // testDbUtils.closeColection();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
