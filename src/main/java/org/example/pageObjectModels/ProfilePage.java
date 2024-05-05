package org.example.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class ProfilePage extends PageObject {

    @FindBy(id = "submit")
    private WebElement buttonLogOut;

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn() {

        return buttonLogOut.isDisplayed();
    }

}
