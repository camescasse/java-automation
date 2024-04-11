package org.example.pageObjectModels;

import org.example.models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginForm extends PageObject {

    @FindBy(id = "userName")
    private WebElement inputUserName;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login")
    private WebElement buttonLogin;

    @FindBy(id = "submit")
    private WebElement buttonLogOut;


    public LoginForm(ChromeDriver driver) {
        super(driver);
    }

    public LoginForm open() {
        driver.get("https://demoqa.com/login");
        wait.until(ExpectedConditions.elementToBeClickable(inputUserName));

        return this;
    }

    public void login(User user) {
        inputUserName.sendKeys(user.userName());
        inputPassword.sendKeys(user.password());

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonLogin);
        buttonLogin.click();
    }

    public boolean isLoggedIn() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogOut));

        return buttonLogOut.isDisplayed();
    }
}
