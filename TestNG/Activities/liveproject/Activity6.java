package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    WebDriverWait w;
    @BeforeClass
    public void loginOrangeHRM() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement username = driver.findElement(By.id("txtUsername"));
        WebElement password = driver.findElement(By.id("txtPassword"));

        //Enter credentials
        username.sendKeys("orange");
        password.sendKeys("orangepassword123");

        //Click login
        driver.findElement(By.id("btnLogin")).click();

        //Maximize current window
        driver.manage().window().maximize();
    }

    @Test
    public void directoryMenu() throws InterruptedException {
        Actions a = new Actions(driver);
        WebElement dir=driver.findElement(By.xpath("//div[@class='menu']/ul/li[9]/a/b"));
        a.moveToElement(dir).build().perform();
        Thread.sleep(3000);
        if(dir.isDisplayed()){
            if(dir.isEnabled()){
                a.moveToElement(dir).click().build().perform();
                Thread.sleep(3000);
            }
        }
        String text=driver.findElement(By.xpath("//div[@id='content']/div[1]/div[1]/h1")).getText();
        Assert.assertEquals(text, "Search Directory");
    }
    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
