package org.example.pageObjectModels;

import org.openqa.selenium.chrome.ChromeDriver;

public abstract class PageObject {
    protected final ChromeDriver driver;

    public PageObject(ChromeDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }
}
