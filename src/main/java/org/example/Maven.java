package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Maven {

    protected static WebDriver driver;//declaring a variable for webdriver

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    public void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }






}
