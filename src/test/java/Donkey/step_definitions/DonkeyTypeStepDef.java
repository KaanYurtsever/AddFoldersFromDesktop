package Donkey.step_definitions;

import Donkey.pages.BasePage;
import Donkey.pages.ConfPage;
import Donkey.utilities.ConfigurationReader;
import Donkey.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

public class DonkeyTypeStepDef {

    WebDriver driver = Driver.get();
    BasePage basePage = new BasePage();
    ConfPage confPage = new ConfPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 15);

    @Given("User opens the browser")
    public void user_opens_the_browser() {
        //Goes to the given url
        driver.get(ConfigurationReader.get("url"));
        //Wait until close username field is clickable
        wait.until(ExpectedConditions.elementToBeClickable(basePage.userNameField));
    }


    @When("User clicks on conf page and adds the new file type")
    public void userClicksOnConfPageAndAddsTheNewFileType() throws InterruptedException {
        //Changes the format type
        confPage.changeType();
    }

    @And("User uploads an empty file with txt format")
    public void userUploadsAnEmptyFileWithTxtFormat() throws InterruptedException, AWTException {
        //Uploads desired file
        basePage.uploadFileType();
    }

    @Then("User should see an error")
    public void userShouldSeeAnError() {
        //Assert that file cannot be empty
        Assert.assertEquals("File cannot be empty", basePage.errorMsg.getText());

    }
}
