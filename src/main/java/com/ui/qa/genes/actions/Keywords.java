package com.ui.qa.genes.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.qa.genes.model.Keyword;
import com.ui.qa.genes.model.Locators;

/***
 * 
 * @author Muzzamil
 * 
 * This class is spine of the framework. It provides keywords/Action such @click and @EnterText to perform specific test case. This class
 * is also responsible to decide what locator we are giving in test data and it returns the same.
 *
 */
public class Keywords {

	WebDriver driver;

	

	public static void perform(String operation, String locator, String objectType, String value, String ExpectedResult,String objLogicalName)
			throws Exception {

		Keyword operationType = Keyword.valueOf(operation);
		switch (operationType) {
		case Click:
			// Perform click
			DriverActions.click(getByObject(locator, objectType), objLogicalName);
			break;
		case EnterText:
			// Set text on control
			DriverActions.input(getByObject(locator, objectType), objLogicalName, value);
			break;

		case NavigateTo:
			// Get url of application
			DriverActions.navigate(value);
			break;
			
		case GetText:
			// Get text of an element
			DriverActions.getText(getByObject(locator, objectType), objLogicalName);
			break;

		case verifyPage:
			// Get text of an element
			DriverActions.verifyCurrentPage(ExpectedResult);
			break;
			
		case verifyPageTitle:
			// Get text of an element
			DriverActions.verifyPageTitle(ExpectedResult);			
			break;
			
		default:
			break;
		}
	}

	/***
	 * 
	 * @param locator
	 * @param objectType
	 * @return
	 * @throws Exception
	 */
	 
	private static By getByObject(String locator, String objectType) throws Exception {
		// Find by xpath
		By by = null;
		Locators locatorType = Locators.valueOf(objectType);
		switch (locatorType) {
		case Id:

			by = By.id(locator);
			break;

		case Xpath:

			by = By.xpath(locator);
			break;

		case ClassName:

			by = By.className(locator);
			break;

		case Name:

			by = By.name(locator);
			break;

		case Css:

			by = By.cssSelector(locator);
			break;

		case Link:

			by = By.linkText(locator);
			break;

		case PartialLink:

			by = By.partialLinkText(locator);
			break;

		default:
			throw new Exception("Wrong object type");

		}
		return by;
	}
}
