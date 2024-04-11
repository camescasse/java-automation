package org.example.pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationModal extends PageObject {

    public ConfirmationModal(ChromeDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        var title = driver.findElement(By.id("example-modal-sizes-title-lg"));
        return title.getText();
    }
}
