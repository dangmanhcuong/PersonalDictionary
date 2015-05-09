package javass20142.dictionary.model;

import java.sql.SQLException;
import java.util.ArrayList;

import javass20142.dictionary.database.Databases;

public class TranslateWord {
	ArrayList<String> listWord = new ArrayList<String>();

	public ArrayList<String> getListWord() {
		Databases dbUtils = new Databases();
		listWord = dbUtils.getListWord();
		try {
			dbUtils.closeColection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listWord;
	}

	public boolean checkWord(String wordString) {
		ArrayList<String> listWord = getListWord();
		for (int i = 0; i < listWord.size(); i++) {
			if (wordString.equalsIgnoreCase(listWord.get(i)))
				return true;
		}
		return false;

	}

	public ArrayList<String> searchWord2(String wordString,
			ArrayList<String> listWord) {
		ArrayList<String> result = new ArrayList<String>();
		for (int i = 0; i < listWord.size(); i++) {
			if (wordString.length() < listWord.get(i).length())
				if (wordString.equalsIgnoreCase(listWord.get(i).substring(0,
						wordString.length()))) {
					result.add(listWord.get(i));
				}
		}
		return result;

		// String str1 = "1bkhn";
		// String str2 = "bk";
		//
		// if(str2.equals(str1.substring(0, str2.length()))){
		// System.out.println("true 111111111111111");
		// }
		//
		// if (str1.contains(str2)) {
		// System.out.println("true");
		// }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TranslateWord testTranslateWord = new TranslateWord();
		Databases dbUtils = new Databases();
		TranslateWord testTranslateWord = new TranslateWord();
		ArrayList<String> listWord2 = new ArrayList<String>();
		listWord2 = dbUtils.getListWord();
		try {
			dbUtils.closeColection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < listWord2.size(); i++) {
			System.out.println(listWord2.get(i));
		}
		// System.out.print(testTranslateWord.searchWord1("234234"));
		ArrayList<String> testArrayList = testTranslateWord.searchWord2("bk",
				listWord2);
		for (int i = 0; i < testArrayList.size(); i++) {
			System.out.println(testArrayList.get(i));

		}

	}

}
