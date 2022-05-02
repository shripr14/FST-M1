package examples;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstExampleTest {
    AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps=new DesiredCapabilities();

        //Desired Capabilities
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceId", "14231JEC209166");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset", true);

        //Appium Server URL
        URL serverURL= new URL("http://localhost:4723/wd/hub");

        //Driver Initialization
        driver=new AndroidDriver<>(serverURL, caps);
    }

    @Test
    public void additionWithCalc() {
        //Find Number 5
        MobileElement digit5 = driver.findElementById("digit_5");

        //Tap Number 5
        digit5.click();
        //Tap plus
        driver.findElementById("op_add").click();
        //Tap 5 again
        digit5.click();

        //Tap equal
        driver.findElementById("eq").click();

        //Find the resultText
        String result = driver.findElementByClassName("android.widget.TextView").getText();

        //Assertion
        Assert.assertEquals(result, "10");

    }

    @AfterClass
    public void tearDown() {

        driver.quit();
    }

}
