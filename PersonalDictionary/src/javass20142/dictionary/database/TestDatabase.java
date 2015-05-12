package javass20142.dictionary.database;

import java.sql.SQLException;

public class TestDatabase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Databases testDbUtils = new Databases();
		testDbUtils.initiAndConnectDB();
		// testDbUtils.initiAndConnectDB();
//		testDbUtils
//				.upDateData("UPDATE `dictionary`.`tb_dictionary` SET `wordVI`=' không  gì' WHERE `wordID`='7'");
//		ArrayList<String> listENArrayList = testDbUtils.getListWordEN();
//		for (int i = 0; i < listENArrayList.size(); i++) {
//			System.out.println(listENArrayList.get(i));
//
//		}
		// testDbUtils.insertDB("hi", "fsdf");
		System.out.println(testDbUtils.getwordVI("testdata", "a few"));
		testDbUtils.closeColection();

	}

}
