package com.ui.qa.genes.utills;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.testng.SkipException;

import com.ui.qa.genes.base.Initializer;

/***
 * 
 * 
 * @author Muzzamil
 * 
 * 
 * This is utility is provides function to read Runmode on @TestSuite and @Testcase level from test data file
 *  skip and continue as per mentioned runmode.
 *
 */
public class Utility extends Initializer{
// is suite runnable
	public static boolean isSuiteRunnable (String SuiteName, Xls_Reader xls){
		int rows=xls.getRowCount(SUITE_SHEET);//Sheet Name
		
		for(int rnum=2; rnum<=rows; rnum++){
			String data=xls.getCellData(SUITE_SHEET, SUITENAME_COL, rnum);//SuiteName-> Colomn Name
			//System.out.println(data);
			if(data.equalsIgnoreCase(SuiteName)){
				String runmode=xls.getCellData(SUITE_SHEET, RUNMODE_COL, rnum);//RunMode->Colomn Name
				if(runmode.equalsIgnoreCase(RUNMODE_YES))
					return true;
				else
					return false;
					
			}
		}
			
		return false;//default
	}

	public static boolean isTestCaseRunnable (String TestCase, Xls_Reader xls){
		int rows=xls.getRowCount(TESTCASES_SHEET);
		for(int rnum=2; rnum<=rows;rnum++){
			String testcasexls=xls.getCellData(TESTCASES_SHEET, TESTCASES_COL, rnum);
			if(testcasexls.equalsIgnoreCase(TestCase)){
				String runmode=xls.getCellData(TESTCASES_SHEET, RUNMODE_COL, rnum);
			if(runmode.equalsIgnoreCase(RUNMODE_YES))
				return true;
			else
				return false;
				
		}
	}	return false;
	}
	
public static List<Hashtable<String, String>> getdata(String testName, Xls_Reader xls){
	List<Hashtable<String, String>> alltestData = new ArrayList<Hashtable<String, String>>();
	 
		int rows=xls.getRowCount(DATA_SHEET);
		System.out.println("Total Rows are---"+rows);
		
		//row no. for test case
		int testCaseRowNum=1;
		for(testCaseRowNum=1; testCaseRowNum<=rows; testCaseRowNum++){
			String testNamexls=xls.getCellData(DATA_SHEET, 0, testCaseRowNum);
			if(testNamexls.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test Starts from Row No."+testCaseRowNum);
		int DataStartRowNum=testCaseRowNum+2;
		int ColStartRowNum=testCaseRowNum+1;
		
		//Rows of data
		int testRows=1;
		while(!xls.getCellData(DATA_SHEET,0, DataStartRowNum+testRows).equals("")){
			testRows++;
		}
		System.out.println("Total rows of data are--"+testRows);
		
		// col of data
		int testcols=0;
		while(!xls.getCellData(DATA_SHEET, testcols, ColStartRowNum).equals("")){
			testcols++;
		}
		 
		Object [][] data= new Object [testRows][1]; 
		//System.out.println("Total cols are--"+testcols);
		
		//for iterating  all data (all cells)
		int r=0;
		for(int rnum=DataStartRowNum;rnum<(DataStartRowNum+testRows);rnum++){
			Hashtable<String,String> table=new Hashtable<String,String> (); 
			for(int cnum=0;cnum<testcols;cnum++){
				//System.out.println(xls.getCellData(Constants.DATA_SHEET, cnum, rnum));
			//data [r][cnum]=xls.getCellData(Constants.DATA_SHEET, cnum, rnum);
			table.put(xls.getCellData(DATA_SHEET, cnum, ColStartRowNum), xls.getCellData(DATA_SHEET, cnum, rnum));
			
			}
			data [r][0]=table;
			r++;
			alltestData.add(table);
		}
		
		
		return alltestData;
				
	}


	
	public static void validateRunmodes (String testName, String suiteName) {
		// suite runmode
		boolean suiteRunmode=Utility.isSuiteRunnable(suiteName, new Xls_Reader (TestData+MAIN_SUITE+FILE_EXTENSION));
		boolean testRunmode=Utility.isTestCaseRunnable(testName, new Xls_Reader(TestData+suiteName+FILE_EXTENSION));
		if(!(suiteRunmode && testRunmode))
		{
			throw new SkipException("Skipping & throw the testcase "+testName+" inside "+suiteName);

		}
	}
			

}
	
