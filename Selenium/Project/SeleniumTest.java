package examples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
    public static void main(String[] args) {
        //Driver object
        WebDriver driver=new FirefoxDriver();

        //open a browser
        driver.get("https://www.training-support.net/");

        //close a browser
        driver.close();

    }
}
