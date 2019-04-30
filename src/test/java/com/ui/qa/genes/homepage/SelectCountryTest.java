package com.ui.qa.genes.homepage;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.ui.qa.genes.extentreport.ExtentReport;
import com.ui.qa.genes.utills.TestDataProvider;
import com.ui.qa.genes.utills.Utility;


public class SelectCountryTest extends ExtentReport {

	@Test
	public void selectCountryTest(Method method) throws Exception {

		Utility.validateRunmodes(this.getClass().getSimpleName(), HOMEPAGE_SUITE);
		TestDataProvider.executeActions(method.getName(), HOMEPAGE_SUITE);
		

	}
	


}
