package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity3 {
    WebDriver driver;
    @BeforeClass
    public void openBrowser() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void orangeHRMLogin() {
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));

        //Enter credentials
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");

        //Click login
        driver.findElement(By.id("btnLogin")).click();
        WebElement welcome = driver.findElement(By.id("welcome"));
        System.out.println("Welcome to OrangeHRM portal");
        Assert.assertTrue(welcome.isDisplayed());
    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
