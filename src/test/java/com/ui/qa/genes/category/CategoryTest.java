package com.ui.qa.genes.category;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.ui.qa.genes.extentreport.ExtentReport;
import com.ui.qa.genes.utills.TestDataProvider;
import com.ui.qa.genes.utills.Utility;

public class CategoryTest extends ExtentReport {

	@Test
	public void testSelectGenderBasedCategory(Method method) throws Exception {

		Utility.validateRunmodes(this.getClass().getSimpleName(), CATEGORY_SUITE);
		TestDataProvider.executeActions(method.getName(), CATEGORY_SUITE);

	}

	@Test
	public void testSelectCategory(Method method) throws Exception {

		Utility.validateRunmodes(this.getClass().getSimpleName(), CATEGORY_SUITE);
		TestDataProvider.executeActions(method.getName(), CATEGORY_SUITE);
	}

}
