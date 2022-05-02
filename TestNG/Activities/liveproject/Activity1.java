package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void testWebTitle() {
        String title = driver.getTitle();
        System.out.println("Title of the website is:" + title);
        Assert.assertEquals(title, "OrangeHRM");

    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
