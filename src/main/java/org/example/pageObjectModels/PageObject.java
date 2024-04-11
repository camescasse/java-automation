package org.example.pageObjectModels;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class PageObject {
    protected final ChromeDriver driver;
    protected final WebDriverWait wait;

    public PageObject(ChromeDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }
}
