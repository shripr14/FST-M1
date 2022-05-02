package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class TagsExample extends BaseClass{

    @Given("^user is on the TS home page$")
    public void openTSHomepage(){
        driver.get("https://training-support.net");

    }

    @When("^user clicks on the Menu button$")
    public void clickMenu(){
        driver.findElement(By.id("about-link")).click();
    }

    @Then("^user is redirected to Menu options$")
    public void aboutUsPage(){
        String aboutUsPageTitle= driver.findElement(By.xpath("//h1[@class='ui header']")).getText();
        Assert.assertEquals("About Us", aboutUsPageTitle);
    }
}
