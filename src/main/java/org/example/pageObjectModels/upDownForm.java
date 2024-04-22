package org.example.pageObjectModels;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class upDownForm extends PageObject {

    private final String url;

    @FindBy(id = "uploadFile")
    private WebElement buttonUpload;

    @FindBy(id = "uploadedFilePath")
    private WebElement uploadPath;

    public upDownForm(WebDriver driver) {
        super(driver);
        this.url = host + "/upload-download";
    }

    public upDownForm open() {
        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(buttonUpload));

        return this;
    }

    public upDownForm uploadFile(String file) {
        var directory = System.getProperty("user.dir");

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonUpload);
        buttonUpload.sendKeys(directory + "/src/test/java/resources/" + file);
        wait.until(ExpectedConditions.elementToBeClickable(uploadPath));

        return this;
    }

    public boolean isUploaded() {
        wait.until(ExpectedConditions.elementToBeClickable(uploadPath));

        return uploadPath.isDisplayed();
    }

}
