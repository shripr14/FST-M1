package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 {
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
    public void clickMyInfo() throws InterruptedException {
        Actions a = new Actions(driver);
        WebElement myInfo=driver.findElement(By.xpath("//div[@class='menu']/ul/li[6]/a/b"));
        a.moveToElement(myInfo).click().build().perform();
        Thread.sleep(3000);
        a.moveToElement(myInfo).click().build().perform();
    }
    @Test (dependsOnMethods = {"clickMyInfo"})
    public void emContacts() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='employee-details']/div[1]/ul/li[3]/a")).click();
            List<WebElement> tablelist = driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody"));

            for(int i=0; i<tablelist.size(); i++)
                System.out.println(tablelist.get(i).getText() );
        }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
