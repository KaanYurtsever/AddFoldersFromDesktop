package Donkey.step_definitions;

import Donkey.pages.BasePage;
import Donkey.pages.ConfPage;
import Donkey.utilities.ConfigurationReader;
import Donkey.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class DonkeyITStepDef {

    WebDriver driver = Driver.get();
    BasePage basePage = new BasePage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 15);

    @Given("User opens the browser and goes the url")
    public void userOpensTheBrowserAndGoesTheUrl() {
        //Goes to the given url
        driver.get(ConfigurationReader.get("url"));
        //Wait until close username field is clickable
        wait.until(ExpectedConditions.elementToBeClickable(basePage.userNameField));
    }
    @When("User uploads the file")
    public void user_uploads_the_file() throws InterruptedException, AWTException {
        //Uploads desired file
        basePage.uploadFileValid();

    }
    @Then("User should see uploaded file")
    public void user_should_see_uploaded_file() {
        //Asserts that uploading file is successfully
        Assert.assertEquals("100%", basePage.successMsg.getText());
    }
}
