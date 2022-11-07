package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Maven {

    protected static WebDriver driver;//declaring a variable for webdriver

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    public void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
    @BeforeMethod
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");//Setting a path for a webdriver and creating basis for automation on chrome
        driver = new ChromeDriver();  //creating a chromedriver object
        driver.get("https://demo.nopcommerce.com/");// Navigating the web address
        driver.manage().window().maximize();//opening and customising window
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();// to close webdriver session and window
    }



}
