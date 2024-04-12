package org.example.pageObjectModels;

import org.example.models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class LoginForm extends PageObject {

    @FindBy(id = "userName")
    private WebElement inputUserName;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login")
    private WebElement buttonLogin;

    public LoginForm(WebDriver driver) {
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

}
