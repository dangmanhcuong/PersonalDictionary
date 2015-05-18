package javass20142.dictionary.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UpDateDatabase {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		UpDateDatabase iDatabase = new UpDateDatabase();
		iDatabase.readFile();
	}

	public void readFile()
			throws com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException {
		Databases Data = new Databases();
		Data.initiAndConnectDB();
		// Path srcFile = Paths
		// .get("F:\\Dictionary\\voice\\stardict editor\\en_vi.txt");
		Path srcFile = Paths
				.get("F:\\Dictionary\\voice\\stardict editor\\en_vii.txt");
		Charset cs = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(srcFile, cs)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				// String lINEString = line.to
				writeData(line, Data);
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}

	public void writeData(String line, Databases Data) {
		int cs1 = line.indexOf("@");
		if (cs1 != -1) {
			line = line.replace("'", "");
			String wordEN = line.substring(0, cs1).trim().toLowerCase();
			String wordVI = line.substring(cs1 + 1, line.length()).trim()
					.replace("\\n", "\n");
			char c = wordEN.charAt(0);
			if ((c >= 97) && (c <= 122)) {
				Data.insertDB2("tbl_word" + line.charAt(0), wordEN, wordVI);
			} else {
				Data.insertDB2("tbl_wordother", wordEN, wordVI);
			}

		} else {
			int cs2 = line.indexOf("\t");
			line = line.replace("'", "");
			String wordEN = line.substring(0, cs2).trim();
			String wordVI = line.substring(cs2 + 1, line.length()).trim()
					.replace("\\n", "\n");
			char c = wordEN.charAt(0);
			if ((c >= 97) && (c <= 122)) {
				Data.insertDB2("tbl_word" + line.charAt(0), wordEN, wordVI);
			} else {
				Data.insertDB2("tbl_wordother", wordEN, wordVI);
			}
		}
	}
}
