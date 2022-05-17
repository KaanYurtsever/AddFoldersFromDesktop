package Donkey.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfPage extends BasePage{

    //Maximum file size field
    @FindBy(xpath = "/html/body/app-root/div/div/div/config-comp/form/div[1]/input")
    public WebElement sizeFld;

    //Allowed File Types field
    @FindBy(xpath = "/html/body/app-root/div/div/div/config-comp/form/div[2]/input")
    public WebElement typeFld;

    //Configuration save button
    @FindBy(xpath = "/html/body/app-root/div/div/div/config-comp/form/div[3]/button")
    public WebElement saveBtn;

    public void changeSize(){
        confBtn.click();
        sizeFld.click();
        sizeFld.sendKeys(Keys.CONTROL + "a");
        sizeFld.sendKeys("999999");
        saveBtn.click();
        homeBtn.click();
    }

    public void changeType() throws InterruptedException {
        confBtn.click();
        typeFld.click();
        typeFld.sendKeys(Keys.END);
        typeFld.sendKeys(", txt");
        saveBtn.click();
        Thread.sleep(5000);
        homeBtn.click();

    }
}
