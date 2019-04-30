package com.ui.qa.genes.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.qa.genes.factory.DriverFactory;

/**
 * @author Muzzamil
 * 
 * Methods for 2 waits
 *  Explicit wait
 *  Implicit Wait
 */
public class Wait extends DriverFactory{

    /**
     * Implicit Waits
     */
    public  void impWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        js.waitUntilDocIsReady();
    }

    /**
     * @param seconds
     *  Takes the integer value argument as second.
     *  This is purely different from the i.e. `3000`
     *  since this takes seconds value, it will be enough to put `3` if you would
     *  want to put {3 seconds} as timeout value
     * @param element
     *  Takes the single object element reference argument when used.
     *  The purpose why this param is added with the same method name is that to
     * take advantage of the instance that there might be some point that you may
     * need to wait for the element to be visible first before executing the next code.
     * This is often happening in Javascript dependent DOM's.
     * i.e. getDriver().findElement(By.xpath("//your/xpath")) [when used with native Selenese]
     * i.e. getYourXpath() [when used with static PageFactoryLocators returnables of @FindBy annotations]
     */
    public static void impWait(int seconds, WebElement element) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();

        js.waitUntilDocIsReady();
    }

    /**
     * Explicit Waits
     */
    public static void untilElementVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void untilElementVisible(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    
    public static void untilElementNotVisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void untilPresenceOfElementBy(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void untilElementIsClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public static void untilElementIsClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static boolean isElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return true;
    }

    public static boolean untilWindowAmountIs(int number) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(number));
        return true;
    }

    public static void untilTextIsPresent(WebElement element, String txt) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, txt));
    }
}
