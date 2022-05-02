package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity2 {
    WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void headerImgUrl() {
        WebElement headerImg = driver.findElement(By.xpath("//div[@id='divLogin']/div[@id='divLogo']/img"));
        String src = headerImg.getAttribute("src");
        System.out.println("URL of the Header Image is: " + src);
    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
