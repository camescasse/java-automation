package org.example.pageObjectModels;

import org.example.services.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class PageObject {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final String host;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.host = PropertiesReader.getInstance().getProperty("HOST");
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

}
