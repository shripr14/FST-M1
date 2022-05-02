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

public class Activity7 {
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
    public void qualification() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='employee-details']/div[1]/ul/li[9]/a")).click();
        //driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("Edward");
        driver.findElement(By.id("addWorkExperience")).click();
        driver.findElement(By.id("experience_employer")).sendKeys("Test");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test");

        // Set from date
        driver.findElement(By.xpath("//*[@id=\"experience_from_date\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"experience_from_date\"]")).sendKeys("2019-08-19");

        // Set To date
        driver.findElement(By.xpath("//*[@id=\"experience_to_date\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"experience_to_date\"]")).sendKeys("2022-04-28");

        driver.findElement(By.id("btnWorkExpSave")).click();
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
