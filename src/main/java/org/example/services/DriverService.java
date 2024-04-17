package org.example.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverService {
    private static DriverService instance;

    public static DriverService getInstance() {
        if (instance == null) {
            instance = new DriverService();
        }
        return instance;
    }

    public WebDriver getDriver() {
        var browser = PropertiesReader.getInstance().getProperty("BROWSER");
        if (browser == null) browser = "";
        else browser = browser.toLowerCase();

        var headlessValue = PropertiesReader.getInstance().getProperty("HEADLESS");
        boolean isHeadless = headlessValue == null || headlessValue.isEmpty() || Boolean.parseBoolean(headlessValue);

        return switch (browser) {
            case "firefox" -> isHeadless ?
                    new FirefoxDriver(new FirefoxOptions().addArguments("--headless")) :
                    new FirefoxDriver();
            case "edge" -> isHeadless ?
                    new EdgeDriver(new EdgeOptions().addArguments("--headless=new")) :
                    new EdgeDriver();
            default -> isHeadless ?
                    new ChromeDriver(new ChromeOptions().addArguments("--headless=new")) :
                    new ChromeDriver();
        };
    }

}
