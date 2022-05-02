package liveproject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps=new DesiredCapabilities();

        //Desired Capabilities
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceId", "14231JEC209166");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        //Appium Server URL
        URL serverURL= new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver<MobileElement>(serverURL, caps);
        wait = new WebDriverWait(driver, 20);
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void chromeToDoList() throws IOException, InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[2][contains(@text,'Get Started!')]")));
        driver.findElementByXPath("//android.widget.Button[2][contains(@text,'Get Started!')]").click();

        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"To-Do List\")")).click();
        String taskList[] = {"Add tasks to list", "Get number of tasks", "Clear the list"};

        for (String task : taskList) {
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));
            driver.findElementByXPath("//android.widget.EditText[@resource-id='taskInput']").sendKeys(task);
            wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[contains(@text,'Add Task')]")));
            driver.findElementByXPath("//android.widget.Button[contains(@text,'Add Task')]").click();
        }
        takeScreenshot("To-Do List");
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View[contains(@text,'Add tasks to list')]").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View[contains(@text,'Get number of tasks')]").click();
        Thread.sleep(3000);
        driver.findElementByXPath("//android.view.View[contains(@text,'Clear the list')]").click();
        Thread.sleep(3000);

        takeScreenshot("Striked");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[2][contains(@text,'Clear List')]")));
        driver.findElementByXPath("//android.view.View[contains(@text,'Clear List')]").click();
        String actual = driver.findElementByXPath("//android.view.View[contains(@text, '')]").getText();
        String expected = "";

        Assert.assertEquals(actual, expected);
    }

    public void takeScreenshot(String filename) throws IOException {
        // Take screenshot
        File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // This specifies the location the screenshot will be saved
        File screenShotName = new File("src/test/resources/screenshot_" + filename + ".jpg");

        // This will copy the screenshot to the file created
        FileUtils.copyFile(scrShot, screenShotName);

        // Set filepath for image
        String filePath = "../" + screenShotName;

        // Set image HTML in the report
        String path = "<img src='" + filePath + "'/>";

        // Show image in report
        Reporter.log(path);
    }

    @AfterClass
    public void tearDown() {
        //Close the Application
           driver.quit();
    }

}


