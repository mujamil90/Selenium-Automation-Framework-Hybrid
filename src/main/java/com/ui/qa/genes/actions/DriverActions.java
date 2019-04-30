package com.ui.qa.genes.actions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ui.qa.genes.extentreport.ExtentReport;
import com.ui.qa.genes.factory.DriverFactory;
import com.ui.qa.genes.helpers.Wait;

/**
 * @author Muzzamil 
 * 
 * Class containing all the function that can be used along the
 *         UI interaction and will use in data engine.
 */
public class DriverActions extends DriverFactory {


	public static void goBack() {
		try {
			ExtentReport.logInfo("Going back to the previous page");
			getWebDriver().navigate().back();
			ExtentReport.logInfo("Back to the previous page was successfully performed");
		} catch (Exception e) {
			ExtentReport.logInfo("Not able to go back to the previous page");
		}
	}

	public static void goForward(String object, String locator, String data) {
		try {
			ExtentReport.logInfo("Going forward from this page : " + getWebDriver().getCurrentUrl());
			getWebDriver().navigate().forward();
			ExtentReport.logInfo("Browse forward was successfully performed");
		} catch (Exception e) {
			ExtentReport.logInfo("Not able to go to target page");

		}
	}

	public static void navigate(String data) {
		try {
			ExtentReport.logInfo("Navigating to URL");

			getWebDriver().get(data);
			ExtentReport.logInfo("Navigated to " + data);
		} catch (Exception e) {
			ExtentReport.logInfo("Not able to navigate the url : " + data + " | " + e.getMessage());

		}
	}

	public static void refresh(String object, String locator, String data) {
		try {
			ExtentReport.logInfo("Refreshing this page : " + getWebDriver().getCurrentUrl());
			getWebDriver().navigate().refresh();

			ExtentReport.logInfo("Refreshed");
		} catch (Exception e) {
			ExtentReport.logInfo("Not able to go to refresh the page : " + getWebDriver().getCurrentUrl());

		}
	}

	/**
	 * Element actions.
	 */

	public static void click(By by, String objLogicalName) {
			try 
			{
			ExtentReport.logInfo("waiting for " + objLogicalName + " to be clickable.");
			Wait.untilElementIsClickable(by);
			ExtentReport.logInfo("Wait succeeded and will click " + objLogicalName);
			WebElement element = getWebDriver().findElement(by);
			element.click();
			ExtentReport.logInfo("Click for " + objLogicalName + " was successfully performed");
			js.waitUntilDocIsReady();			
			}
			catch (Exception e) {
				ExtentReport.logInfo("Not able on given object "+objLogicalName+ " due to error "+ e.getMessage());
			}
		
	}

	public static void input(By by, String objLogicalName, String data) {
		try {
			ExtentReport.logInfo("Waiting until " + objLogicalName + " is Visible");
			Wait.untilElementVisible(by);

			ExtentReport.logInfo("Waiting until " + objLogicalName + " is clickable");
			Wait.untilElementIsClickable(by);

			WebElement element = getWebDriver().findElement(by);

			ExtentReport.logInfo("Entering the " + data + " in : " + objLogicalName);
			element.sendKeys(data);

			ExtentReport.logInfo("Inputted " + data + " to " + objLogicalName);
		} catch (Exception e) {
			ExtentReport.logInfo("Not able to enter " + data + " : " + e.getMessage());

		}
	}

	public static void inputAndEnter(By by, String objLogicalName, String data) {
		try {
			ExtentReport.logInfo("Waiting until " + objLogicalName + " is Visible");
			Wait.untilElementVisible(by);

			ExtentReport.logInfo("Waiting until " + objLogicalName + " is clickable");
			Wait.untilElementIsClickable(by);

			WebElement element = getWebDriver().findElement(by);
			ExtentReport.logInfo("Entering the " + data + " in : " + objLogicalName);
			element.sendKeys(data);

			ExtentReport.logInfo("Inputted " + data + " to " + objLogicalName);

			element.sendKeys(Keys.ENTER);
			ExtentReport.logInfo("Input and enter " + data + " to " + objLogicalName + " successfully");
		} catch (Exception e) {
			ExtentReport.logInfo("Not able to enter and submit :" + data + " : " + e.getMessage());

		}
	}

	public static void selectByVisibleText(By by, String objLogicalName, String data) {
		try {
			ExtentReport.logInfo("Waiting until " + objLogicalName + " is Visible");
			Wait.untilElementVisible(by);

			ExtentReport.logInfo("Waiting until " + objLogicalName + " is clickable");
			Wait.untilElementIsClickable(by);

			WebElement element = getWebDriver().findElement(by);
			Select select = new Select(element);
			select.selectByVisibleText(data);
			ExtentReport.logInfo(data + " is selected in dropdown " + objLogicalName);

		} catch (Exception e) {
			ExtentReport.logInfo("Not able to select the text " + data + " in the dropdown : " + e.getMessage());

		}
	}

	/**
	 * Mouse hover actions.
	 */

	public static void moveToElement(By by, String objLogicalName) {
		try {
			ExtentReport.logInfo("Waiting until " + objLogicalName + " is Visible");
			Wait.untilElementVisible(by);

			ExtentReport.logInfo("Waiting until " + objLogicalName + " is clickable");
			Wait.untilElementIsClickable(by);

			WebElement element = getWebDriver().findElement(by);
			ExtentReport.logInfo("Moving to the element : " + objLogicalName);
			elementActions.moveToElement(element);
			ExtentReport.logInfo("Moved the mouse to " + objLogicalName);
		} catch (Exception e) {
			ExtentReport.logInfo("Not able to move to element : " + e.getMessage());

		}
	}

	public static void WaitForElementInvisibility(By by, String objLogicalName, int timeout) {
		try {

			ExtentReport.logInfo("Waiting for " + objLogicalName + " to be invisible within " + timeout + " seconds");
			Wait.untilElementNotVisible(by);
			ExtentReport.logInfo("Object " + objLogicalName + " has been invisible");
		} catch (Exception e) {
			ExtentReport.logInfo("Not able to Wait : " + e.getMessage());

		}
	}

	/**
	 * Assertion actions.
	 */

	public static void assertElementVisible(By by, String objLogicalName) {
		try {
			ExtentReport.logInfo("Waiting until " + objLogicalName + " is Visible");
			Wait.untilElementVisible(by);
			WebElement element = getWebDriver().findElement(by);
			ExtentReport.logInfo("Asserting if element is visible.");
			Assert.assertTrue(element.isDisplayed());
			ExtentReport.logInfo("Assertion : Object " + objLogicalName + " was visible");
		} catch (Exception e) {
			ExtentReport.logInfo("Assertion : Object " + objLogicalName + " is not visible | " + e.getMessage());

		}
	}

	public static void assertPageReached(String data) {
		try {
			ExtentReport.logInfo("Asserting if page was reached");
			Assert.assertTrue(getWebDriver().getCurrentUrl().contains(data));
			ExtentReport.logInfo("Assertion : Target page was reached");
		} catch (Exception e) {
			ExtentReport.logInfo("Assertion error. Page was not reached." + e.getMessage());

		}
	}

	public static void assertHasResults(By by) {
		try {
			int amountOfResults = getWebDriver().findElements(by).size();
			ExtentReport.logInfo("Asserting if there is/are result(s)");

			if (amountOfResults > 0) {
				ExtentReport.logInfo("Assertion : There are result(s)");
			} else {
				ExtentReport.logInfo("Assertion : There are no result(s)");

			}
		} catch (Exception e) {
			ExtentReport.logInfo("Assertion : There was an error in counting the results > " + e.getMessage());

		}
	}

	public static List<WebElement> getListOfElements(By by, String objLogicalName) {
		List<WebElement> matchingElements = new ArrayList<>();
		try {
			ExtentReport.logInfo("Waiting until " + objLogicalName + " is clickable");
			// Wait.untilElementVisible(by);
			ExtentReport.logInfo("Wait succeeded and will click on " + objLogicalName);
			matchingElements = getWebDriver().findElements(by);
			ExtentReport.logInfo("Total number of elements are : " + matchingElements.size());
		} catch (Exception e) {
			ExtentReport.logInfo("There was an error in counting the results > " + e.getMessage());
		}
		return matchingElements;

	}

	public static String verifyCurrentPage(String matchingText) {
		String currentUrl = null;
		try {
			currentUrl = getWebDriver().getCurrentUrl();
			ExtentReport.logInfo("Current page Url is : "+currentUrl);
			boolean isContains=org.apache.commons.lang3.StringUtils.containsIgnoreCase(currentUrl, matchingText);
			Assert.assertTrue(isContains, "Wrong page " + currentUrl);
			ExtentReport.logInfo("Current page : "+ currentUrl + " is verified.");
		} catch (Exception e) {
			ExtentReport.logInfo("There was to some problem to get current page url " + e.getMessage());
		}
		return currentUrl;
	}

	public static WebElement getWebElement(By by, String objLogicalName) {
		WebElement matchingElement = null;
		try {
			ExtentReport.logInfo("Waiting until " + objLogicalName + " is Visible");
			Wait.untilElementVisible(by);

			matchingElement = getWebDriver().findElement(by);

		} catch (Exception e) {
			ExtentReport.logInfo("There is no matchng element for " + objLogicalName + " " + e.getMessage());
		}
		return matchingElement;

	}

	
	public static String verifyPageTitle(String matchingText) {
		String pageTitle = null;
		try {
			pageTitle = getWebDriver().getTitle();
			ExtentReport.logInfo("Current page Url is : "+pageTitle);
			boolean isContains=org.apache.commons.lang3.StringUtils.containsIgnoreCase(pageTitle, matchingText);
			Assert.assertTrue(isContains, "Wrong page " + pageTitle);
			ExtentReport.logInfo("Current page : "+ pageTitle+ " is verified.");
		} catch (Exception e) {
			ExtentReport.logInfo("There is some issue to get page's Title :  " + e.getMessage());
		}
		return pageTitle;
	}
	
	
	public static String getText(By by, String objLogicalName) {
		 String fetchText = null;
		try {
			ExtentReport.logInfo("Waiting until " + objLogicalName + " is Visible");
			Wait.untilElementVisible(by);
			
			fetchText = getWebDriver().findElement(by).getText();
			
		} catch (Exception e) {
			ExtentReport.logInfo("There is some issue to get page's Title :  " + e.getMessage());
		}
		return fetchText;
	}
}
