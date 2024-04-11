package org.example.pageObjectModels;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends PageObject {

    @FindBy(id = "submit")
    private WebElement buttonLogOut;

    public ProfilePage(ChromeDriver driver) {
        super(driver);
    }

    public boolean isLoggedIn() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogOut));

        return buttonLogOut.isDisplayed();
    }

}
