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

	public void readFile() {
		Databases Data = new Databases();
		Data.initiAndConnectDB();
		Path srcFile = Paths
				.get("F:\\Dictionary\\voice\\stardict editor\\en_vi.txt");
		Charset cs = Charset.forName("UTF-8");
		try (BufferedReader reader = Files.newBufferedReader(srcFile, cs)) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				int i = line.indexOf("@");
				// int j = line.indexOf("\t");
				if (i != -1) {
					String wordEN = line.substring(0, i).trim();
					String wordVI = line.substring(i + 1, line.length()).trim();
					String bString = wordVI.replace("\\n", "\n");
					Data.insertDB2("tbl_translateev", wordEN, bString);
				} else {
					System.out.println(line);
				}

				// System.out.print(wordEN);
				// System.out.println(wordVI);
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}
	}
}
