package com.ui.qa.genes.utills;

/***
 * 
 * This class provides test data from excel file in usable format @hashtable and utilize it to perform action in order to accomplish test cases.
 */
import java.util.Hashtable;
import java.util.List;

import com.ui.qa.genes.actions.Keywords;
import com.ui.qa.genes.base.Initializer;

public class TestDataProvider extends Initializer {

	private static List<Hashtable<String, String>> getTestData(String testcaseName, String suiteName) {
		Xls_Reader xls1 = new Xls_Reader(TestData + suiteName + FILE_EXTENSION);
		return Utility.getdata(testcaseName, xls1);
	}

	public static void executeActions(String testcaseName, String suiteName) throws Exception {
		List<Hashtable<String, String>> tables = getTestData(testcaseName, suiteName);
		for (Hashtable<String, String> table : tables) {

			Keywords.perform(table.get(KEYWORD_COL), table.get(LOCATOR_COL), table.get(LOCATOR_TYPE_COL),
					table.get(VALUE_COL), table.get(EXPECTED_RESULT_COL), table.get(OBJ_LOGICAL_NAME_COL));
		}

	}
}
