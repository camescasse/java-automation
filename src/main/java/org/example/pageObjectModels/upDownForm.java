package org.example.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class upDownForm extends PageObject {

    private final String url;

    @FindBy(id = "downloadButton")
    private WebElement buttonDownload;

    public upDownForm(WebDriver driver) {
        super(driver);
        this.url = host + "/upload-download";
    }

    public upDownForm open() {
        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(buttonDownload));

        return this;
    }

    public boolean isFileDownloaded() {
        var timeoutSeconds = 30;
        var downloadPath = System.getProperty("user.home") + "\\Downloads";

        var filesBeforeDownload = getFileCount(downloadPath);
        buttonDownload.click();

        for (int i = 0; i < timeoutSeconds; i++) {
            var filesAfterDownload = getFileCount(downloadPath);

            if (filesAfterDownload > filesBeforeDownload) {
                return true;
            }
            oneSecondSleep();
        }
        return false;
    }

    private int getFileCount(String path) {
        return Objects.requireNonNull(new File(path).listFiles()).length;
    }

    private void oneSecondSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.err.println("Download failed.");
        }
    }

}
