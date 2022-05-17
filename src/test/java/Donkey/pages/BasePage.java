package Donkey.pages;

import Donkey.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    //Username field
    @FindBy(xpath = "/html/body/app-root/div/div/div/app-home/div[1]/upload-comp/div[1]/div/input")
    public WebElement userNameField;

    //Upload button
    @FindBy(xpath = "/html/body/app-root/div/div/div/app-home/div[1]/upload-comp/div[2]/div[2]/button")
    public WebElement uploadBtn;

    //Successful massage for uploading file
    @FindBy(xpath = "/html/body/app-root/div/div/div/app-home/div[1]/upload-comp/div[2]/div[1]/span[1]")
    public WebElement successMsg;

    //Error massage
    @FindBy(xpath = "/html/body/app-root/div/div/div/app-home/div[1]/upload-comp/div[2]/div[1]/span")
    public WebElement errorMsg;

    //Home button
    @FindBy(xpath = "//*[@id=\"navbarNavDropdown\"]/ul[2]/li[1]/a")
    public WebElement homeBtn;

    //Configuration button
    @FindBy(xpath = "//*[@id=\"navbarNavDropdown\"]/ul[2]/li[2]/a")
    public WebElement confBtn;



    public void uploadFileValid() throws InterruptedException, AWTException {
        userNameField.click();
        userNameField.sendKeys("kaan");
        uploadBtn.click();
        uploadBtn.sendKeys(Keys.ENTER);
        uploadFile("C:\\Users\\kaan\\Desktop\\kaan.pdf"); //valid
    }

    public void uploadFileSize() throws InterruptedException, AWTException {
        userNameField.click();
        userNameField.sendKeys("kaanSize");
        uploadBtn.click();
        uploadBtn.sendKeys(Keys.ENTER);
        uploadFile("C:\\Users\\kaan\\Desktop\\size.pdf");
    }

    public void uploadFileType() throws InterruptedException, AWTException {
        userNameField.click();
        userNameField.sendKeys("kaanType");
        uploadBtn.click();
        uploadBtn.sendKeys(Keys.ENTER);
        uploadFile("C:\\Users\\kaan\\Desktop\\kaan.txt");

    }

    public static void setClipBoard(String file){
        StringSelection obj = new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
    }

    public static void uploadFile(String filePath) throws AWTException, InterruptedException {
        setClipBoard(filePath);

        Robot rb = new Robot();

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(3500);

        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }
}
