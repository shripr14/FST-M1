package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Activity4 {
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
    public void clickPIM() throws InterruptedException {
        Actions a = new Actions(driver);
        WebElement btnPIM=driver.findElement(By.xpath("//div[@class='menu']/ul/li[2]/a/b"));
        a.moveToElement(btnPIM).click().build().perform();
        Thread.sleep(3000);
        a.moveToElement(btnPIM).click().build().perform();
    }

    @Test (dependsOnMethods = {"clickPIM"})
    public void addEmployee() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.name("btnAdd")).click();
        driver.findElement(By.id("firstName")).sendKeys("Abc");
        driver.findElement(By.id("lastName")).sendKeys("hi");
        driver.findElement(By.id("btnSave")).click();
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
