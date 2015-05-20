package javass20142.dictionary.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javass20142.dictionary.model.TranslateWord;

public class UpDateDatabase {
	TranslateWord checkWord = new TranslateWord();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UpDateDatabase iDatabase = new UpDateDatabase();
		System.out.println(iDatabase
				.readFile("C:\\Users\\Nagato\\Desktop\\testupdate.txt"));
	}

	public String readFile(String linkFile)
			throws com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException {
		Databases Data = new Databases();
		Data.initiAndConnectDB();
		try {
			Path srcFile = Paths.get(linkFile);
			Charset cs = Charset.forName("UTF-8");
			try (BufferedReader reader = Files.newBufferedReader(srcFile, cs)) {
				String line = null;
				while ((line = reader.readLine()) != null) {
					// String lINEString = line.to
					try {
						writeData(line, Data);
					} catch (java.lang.NullPointerException exception) {
						return "ban chua chon duong dan";
					} catch (Exception e) {
						// TODO: handle exception
						return "false";
					}

				}
				return "success";
			} catch (IOException e) {
				// System.err.format("IOException: %s%n", e);
				return "fail";
			}
		} catch (java.lang.NullPointerException e) {
			return "ban chua chon duong dan";
		}
	}

	public void writeData(String line, Databases Data) {
		int cs1 = line.indexOf("@");
		line = line.replace("'", "");
		String wordEN = line.substring(0, cs1).trim().toLowerCase();
		String wordVI = line.substring(cs1 + 1, line.length()).trim()
				.replace("\\n", "\n");
		if (checkWord.checkWord(wordEN) == false) {
			char c = wordEN.charAt(0);
			if ((c >= 97) && (c <= 122)) {
				Data.insertDB2(line.charAt(0) + "", wordEN, wordVI);
			} else {
				Data.insertDB2("other", wordEN, wordVI);
			}
		}

	}

	// public void writeData(String line, Databases Data) {
	// int cs1 = line.indexOf("@");
	// if (cs1 != -1) {
	// line = line.replace("'", "");
	// String wordEN = line.substring(0, cs1).trim().toLowerCase();
	// String wordVI = line.substring(cs1 + 1, line.length()).trim()
	// .replace("\\n", "\n");
	// char c = wordEN.charAt(0);
	// if ((c >= 97) && (c <= 122)) {
	// Data.insertDB2(line.charAt(0) + "", wordEN, wordVI);
	// } else {
	// Data.insertDB2("other", wordEN, wordVI);
	// }
	//
	// } else {
	// int cs2 = line.indexOf("\t");
	// line = line.replace("'", "");
	// String wordEN = line.substring(0, cs2).trim();
	// String wordVI = line.substring(cs2 + 1, line.length()).trim()
	// .replace("\\n", "\n");
	// char c = wordEN.charAt(0);
	// if ((c >= 97) && (c <= 122)) {
	// Data.insertDB2(line.charAt(0) + "", wordEN, wordVI);
	// } else {
	// Data.insertDB2("other", wordEN, wordVI);
	// }
	// }
	// }
}
