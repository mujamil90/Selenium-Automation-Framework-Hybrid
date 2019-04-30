/**
 * 
 */
package com.ui.qa.genes.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ui.qa.genes.helpers.JSExecutor;

/****
 * 
 * @author Muzzamil
 *
 * This class is responsible to provide driver instance.
 */
public class DriverFactory extends BrowserFactory {
	public static ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();
	public static String browser;
	public static String url;

	@BeforeSuite
	public void beforeMethod() throws Exception
	{

		new DriverFactory();
		WebDriver driver = DriverFactory.startBrowser(Browser);
		setWebDriver(driver);
		wait = new WebDriverWait(driver, MaxPageLoadTime);
	    js = new JSExecutor();
	}

	public void setWebDriver(WebDriver driver) {
		wd.set(driver);
	}

	public static WebDriver getWebDriver() {
		return wd.get();
	}


	@AfterSuite(alwaysRun = true, enabled = true)
	public void afterMethod() throws Exception {
		
		getWebDriver().quit();
	}
}
