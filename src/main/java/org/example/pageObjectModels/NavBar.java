package org.example.pageObjectModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar extends PageObject {

    @FindBy(xpath = "//div[text()=\"Elements\"]")
    private WebElement headerElements;

    @FindBy(xpath = "//div[text()=\"Forms\"]")
    private WebElement headerForms;

    @FindBy(xpath = "//div[text()=\"Alerts, Frame & Windows\"]")
    private WebElement headerAlertsFrameWindows;

    @FindBy(xpath = "//div[text()=\"Widgets\"]")
    private WebElement headerWidgets;

    @FindBy(xpath = "//div[text()=\"Interactions\"]")
    private WebElement headerInteractions;

    @FindBy(xpath = "//div[text()=\"Book Store Application\"]")
    private WebElement headerBookStore;

    @FindBy(xpath = "//span[text()=\"Login\"]")
    private WebElement spanLogin;


    public NavBar(WebDriver driver) {
        super(driver);
        var url = host + "/forms";
        driver.get(url);
        headerForms.click();
    }

    public NavBar goBookStore() {
        headerBookStore.click();

        return this;
    }

    public LoginForm login() {
        spanLogin.click();

        return new LoginForm(driver);
    }

}
