package examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgAssertions {
        WebDriver driver;

        @Test
        public void testCase() {
            driver = new FirefoxDriver();
            driver.get("https://www.training-support.net");

            // Here driver will try to find out My Account link on the application
            WebElement aboutUsButton = driver.findElement(By.linkText("About Us"));

            //Test will only continue, if the below statement is true
            //This is to check whether the link is displayed or not
            Assert.assertTrue(aboutUsButton.isDisplayed());

            //My Account will be clicked only if the above condition is true
            aboutUsButton.click();
        }
    }
