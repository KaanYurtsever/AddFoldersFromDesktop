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

public class DonkeySizeStepDef {
    WebDriver driver = Driver.get();
    BasePage basePage = new BasePage();
    ConfPage confPage = new ConfPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 15);

    @Given("User opens the given browser")
    public void user_opens_the_given_browser() {
        //Goes to the given url
        driver.get(ConfigurationReader.get("url"));
        //Wait until close username field is clickable
        wait.until(ExpectedConditions.elementToBeClickable(basePage.userNameField));
    }


    @When("User clicks on conf page and changes the size")
    public void user_clicks_on_conf_page_and_changes_the_size() {
        //Changes the size
        confPage.changeSize();
    }

    @And("User uploads the changed size file")
    public void user_uploads_the_changed_size_file() throws InterruptedException, AWTException {
        //Uploads desired file
        basePage.uploadFileSize();
        Thread.sleep(3000);

    }

    @Then("User should upload bigger sized file than default")
    public void user_should_upload_bigger_sized_file_than_default() {
        //Asserts that uploading file is successfully
        Assert.assertEquals("100%", basePage.successMsg.getText());
    }


}
