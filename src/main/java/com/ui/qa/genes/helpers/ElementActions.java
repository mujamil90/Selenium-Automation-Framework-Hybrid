package com.ui.qa.genes.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * @author Muzzamil
 * 
 * DriverActions class methods and operations storage.
 */
public class ElementActions {

    private WebDriver driver;
    private Actions actions;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(this.driver);
    }

    public void moveToElement(WebElement element) {
        actions.moveToElement(element).build().perform();
    }

    public void doubleClick(WebElement target) {
        actions.doubleClick(target).perform();
    }
}
