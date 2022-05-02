package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class Activity8 {
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
    public void clickDashboard() throws InterruptedException {
        Actions a = new Actions(driver);
        WebElement db=driver.findElement(By.xpath("//div[@class='menu']/ul/li[8]/a/b"));
        a.moveToElement(db).click().build().perform();
    }

    @Test(dependsOnMethods = {"clickDashboard"})
    public void applyLeave() throws InterruptedException {
        Actions a = new Actions(driver);
        WebElement al = driver.findElement(By.xpath("//div[@id='panel_draggable_0_0']/fieldset/div/div/table/tbody/tr/td[4]/div/a/span"));
        a.moveToElement(al).click().build().perform();
        Thread.sleep(1000);
        a.moveToElement(al).click().build().perform();
        Thread.sleep(1000);

        // Select leave type from the dropdown
        WebElement lType = driver.findElement(By.xpath("//div[@id='apply-leave']/div[2]/form/fieldset/ol[1]/li[1]/select"));
        a.moveToElement(lType).build().perform();
        Select dropdown = new Select(lType);
        dropdown.selectByVisibleText("DayOff");

        // Set from date
        driver.findElement(By.id("applyleave_txtFromDate")).clear();
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2022-10-26");

        // Set To date
        driver.findElement(By.id("applyleave_txtToDate")).clear();
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("20202-10-28");

        driver.findElement(By.id("applyBtn")).click();

        driver.findElement(By.xpath("//*[@id=\"menu_leave_viewMyLeaveList\"]")).click();

        List<WebElement> navStatus = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[6]"));
        for(int i=0; i<1; i++)
            System.out.println("Current Leave Status is:"+ navStatus.get(i).getText() );

    }
        @AfterClass
        public void afterMethod() {
            //Close the browser
            driver.quit();
        }

}
