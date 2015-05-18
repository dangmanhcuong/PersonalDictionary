package javass20142.dictionary.model;

import java.util.ArrayList;

import javass20142.dictionary.database.Databases;

import javax.swing.JTextField;
import javax.swing.JTextPane;

public class TranslateWord {
	ArrayList<String> listWord = new ArrayList<String>();
	Databases databases = new Databases();

	public void translateWord(JTextField wordSearch, JTextPane txtWordVI) {
		String wordsearch = wordSearch.getText();
		if (checkWord(wordsearch)) {
			txtWordVI.setText(databases.getwordVI(
					"tbl_word" + wordsearch.charAt(0), wordsearch));

		} else {
			txtWordVI
					.setText("word is not in the database enter or misspelled");

		}
	}

	public boolean checkWord(String wordEN) {
		if (wordEN.equals("")==false) {
			ArrayList<String> listWord = databases.getListWordEN("tbl_word"
					+ wordEN.charAt(0), "wordEN");
			for (int i = 0; i < listWord.size(); i++) {
				if (wordEN.equalsIgnoreCase(listWord.get(i)))
					return true;
			}
			return false;
		} else {
			return false;
		}

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
	}
}
