package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Activity5 {
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
    public void editInfo() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("btnSave")).click();

        // Edit fName
        driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"personal_txtEmpFirstName\"]")).sendKeys("John");

        // Edit lName
        driver.findElement(By.xpath("//*[@id=\"personal_txtEmpLastName\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"personal_txtEmpLastName\"]")).sendKeys("Avil");

        // Edit DOB
        driver.findElement(By.xpath("//*[@id=\"personal_DOB\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"personal_DOB\"]")).sendKeys("1997-10-26");

        // Select Nationality from dropdown
        Actions a = new Actions(driver);
        WebElement nat = driver.findElement(By.xpath("//*[@id=\"personal_cmbNation\"]"));
        a.moveToElement(nat).build().perform();
        Select dropdown = new Select(nat);
        dropdown.selectByVisibleText("Indian");

        driver.findElement(By.id("btnSave")).click();
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}
