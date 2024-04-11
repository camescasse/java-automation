package org.example.pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfirmationModal {
    private final ChromeDriver driver;

    public ConfirmationModal(ChromeDriver driver) {
        this.driver = driver;
    }

    public String getTitleText(){
        var title = driver.findElement(By.id("example-modal-sizes-title-lg"));
        return title.getText();
    }
}
