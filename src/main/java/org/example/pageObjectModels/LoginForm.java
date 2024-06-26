package org.example.pageObjectModels;

import org.example.models.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public final class LoginForm extends PageObject {

    private final String url;

    @FindBy(id = "userName")
    private WebElement inputUserName;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(id = "login")
    private WebElement buttonLogin;

    public LoginForm(WebDriver driver) {
        super(driver);
        this.url = host + "/login";
    }

    public LoginForm open() {
        driver.get(url);

        return this;
    }

    public void login(User user) {
        inputUserName.sendKeys(user.userName());
        inputPassword.sendKeys(user.password());

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", buttonLogin);
        buttonLogin.click();
    }

}
