package com.ui.qa.genes.factory;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Listeners;

import com.ui.qa.genes.base.Initializer;
import com.ui.qa.genes.config.Constants;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;

/***
 * 
 * @author Muzzamil
 * 
 * This class is responsible to setup webdriver instance.
 *
 */
@Listeners(com.automation.remarks.testng.VideoListener.class)
public class BrowserFactory  extends Initializer  {
    public static WebDriver driver = null;

    @SuppressWarnings("deprecation")
	public static WebDriver startBrowser(String browser) throws MalformedURLException 
    {
        switch (browser) 
        {
            case Constants.CHROME:
                ChromeDriverManager.getInstance().setup();
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.default_content_settings.popups", 0);
                prefs.put("credentials_enable_service", false);
                prefs.put("password_manager_enabled", false);
                options.addArguments("disable-extensions");
                options.setExperimentalOption("prefs", prefs);
                options.addArguments("chrome.switches", "--disable-extensions");
                options.addArguments("--test-type");
                options.addArguments("disable-infobars");
                options.addArguments("start-maximized");
                DesiredCapabilities cap = DesiredCapabilities.chrome();
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
                 driver = new ChromeDriver(cap);
                 break;
            case Constants.FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                DesiredCapabilities capabilities = new DesiredCapabilities();
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.startup.homepage","about:blank");
                capabilities.setCapability(FirefoxDriver.PROFILE, profile);
                 driver = new FirefoxDriver(capabilities);
    			break;
                 
            case Constants.IE:
            	InternetExplorerDriverManager.getInstance().setup();
            	DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer(); 
    			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            	 driver= new InternetExplorerDriver(ieCapabilities);
            	 break;
            default:
                throw new IllegalArgumentException("Invalid browser name : " + browser);
    }
        driver.get(WebsiteURL);
		
	    driver.manage().window().maximize();
		 
      return driver;  
    }
    
    
    public static void implicitlywait(int timeInSeconds) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
	}

	public static void setMaxPageLoadTime(int timeInSeconds) throws Exception
	{
		driver.manage().timeouts().pageLoadTimeout(timeInSeconds, TimeUnit.SECONDS);
	}
	
}
