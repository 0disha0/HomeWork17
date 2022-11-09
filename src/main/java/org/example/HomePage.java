package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage {

    protected static WebDriver driver;//declaring a variable for webdriver

    public void clickOnElement(By by) {//this method is finding the element and clicking on it
        driver.findElement(by).click();
    }
    public void typeText(By by, String text) {// this method is finding the element and giving the text
        driver.findElement(by).sendKeys(text);
    }

    @BeforeMethod// this method will be called before the main method
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver","src/test/java/Drivers/chromedriver");//Setting a path for a webdriver and creating basis for automation on chrome
        driver = new ChromeDriver();  //creating a chromedriver object
        driver.get("https://demo.nopcommerce.com/");// Navigating the web address
        driver.manage().window().maximize();//opening and customising window
    }
    @AfterMethod// this method will be called after calling the main method
    public void closeBrowser() {
        driver.quit();// to close webdriver session and window
    }

    public static void selectListByVisibleText(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }
    public static void selectListByValue(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    @Test
    public void toVerifyUserCanRegisterSuccessfully() {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());// Storing current date and time as given pattern
        System.out.println();
        clickOnElement(By.className("ico-register"));// finding the element within the webpage as class(in locator) and clicking on it
        clickOnElement(By.id("gender-female"));//finding the element within the webpage as id(in locator) and clicking on it
        typeText(By.id("FirstName"),"Daisha");// finding the element with in the webpage as id(in locator) and adding data in it
        typeText(By.id("LastName"),"Kanani");// finding the element with in the webpage as id(in locator) and adding data in it
        selectListByValue(By.name("DateOfBirthDay"),"10");
        selectListByVisibleText(By.name("DateOfBirthMonth"),"February");
        selectListByVisibleText(By.name("DateOfBirthYear"),"2000");
        typeText(By.id("Email"),"dish" +timeStamp+ "kan@gamil.com");// finding the element with in the webpage as id(in locator) and adding data in it
        typeText(By.xpath("//input[@id=\"Company\"]"),"Unique private ltd.");// finding the element with in the webpage from xpath(in locator) and adding data in it
        typeText(By.id("Password"),"dish@5903");// finding the element with in the webpage as id(in locator) and adding data in it
        typeText(By.id("ConfirmPassword"),"dish@5903");// finding the element with in the webpage as id(in locator) and adding data in it
        clickOnElement(By.id("register-button"));//finding the element within the webpage as id(in locator) and clicking on it
        String regMsg = driver.findElement(By.className("result")).getText(); // Storing string value after finding text in regMsg variable
        System.out.println(regMsg);// printing a stored data(text msg)
    }
    @Test
    public void toGetInformationAboutProduct() {
        clickOnElement(By.linkText("Computers"));//finding the element within the webpage from link text(in locator) and clicking on it
        clickOnElement(By.linkText("Desktops"));//finding the element within the webpage from link text(in locator) and clicking on it

        String store = driver.findElement(By.className("center-2")).getText();// Storing string value after finding text in regMsg variable
        System.out.println(store);// It prints out stored message variables
    }
    @Test
    public void toVerifyUserCanCommentOnNews() {
        clickOnElement(By.xpath("//div[@class='news-list-homepage']/div[2]/div[2]/div[3]//a"));// finding the element with in the webpage from xpath(in locator) and clicking on it
        typeText(By.className("enter-comment-title"),"News");// finding the element within the webpage as class(in locator) and adding daya in it
        typeText(By.className("enter-comment-text")," Thank you so much\nThat was a stunning news");// finding the element within the webpage as class(in locator) and adding daya in it
        clickOnElement(By.name("add-comment"));// finding the element with in the webpage as name(in locator) and clicking on it

        String getMessage = driver.findElement(By.className("result")).getText();// Storing string value after finding text in regMsg variable
        System.out.println(getMessage);// printing a stored data(text msg)
    }
    



}


