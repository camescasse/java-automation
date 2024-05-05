package org.example.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class ConfirmationModal extends PageObject {

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement title;

    public ConfirmationModal(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return title.getText();
    }

}
