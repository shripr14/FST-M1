package liveproject;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Activity2 {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();
        //Desired Capabilities
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceId", "14231JEC209166");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        //Appium Server URL
        URL serverURL= new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver = new AndroidDriver<MobileElement>(serverURL, caps);
    }

    @Test
    public void addGoogleKeep() throws IOException {
            driver.findElementById("new_note_button").click();
            driver.findElementById("edit_note_text").sendKeys("Hi, Welcome to Keep App");
            driver.findElementById("editable_title").sendKeys("Welcome");
            takeScreenshot("KeepNew Note");
            driver.findElementByAccessibilityId("Navigate up").click();
            takeScreenshot("KeepHome");
            MobileElement note=driver.findElementByXPath("//androidx.cardview.widget.CardView[@content-desc=\"Welcome. Hi, Welcome to Keep App. \"]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView[1]");
            String s=note.getText();
            Assert.assertEquals(s,"Welcome");
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

