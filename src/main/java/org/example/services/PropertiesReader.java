package org.example.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader instance;
    private final Properties properties;

    private PropertiesReader() {
        properties = new Properties();
        try (FileInputStream stream = new FileInputStream(".properties")) {
            properties.load(stream);
        } catch (IOException e) {
            System.err.println(".properties file not found");
        }
    }

    public static PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public WebDriver getDriver() throws Exception {
        var browser = properties.getProperty("BROWSER").toLowerCase();
        var headless = properties.getProperty("HEADLESS").toLowerCase();

        validateBrowser(browser);
        validateHeadless(headless);

        return switch (browser) {
            case "chrome" -> headless.equals("true") ?
                    new ChromeDriver(new ChromeOptions().addArguments("--headless")) :
                    new ChromeDriver();
            case "firefox" -> headless.equals("true") ?
                    new FirefoxDriver(new FirefoxOptions().addArguments("--headless")) :
                    new FirefoxDriver();
            case "edge" -> headless.equals("true") ?
                    new EdgeDriver(new EdgeOptions().addArguments("--headless")) :
                    new EdgeDriver();
            default -> throw new Exception("Unsupported browser: " + browser);
        };
    }

    private void validateBrowser(String browser) throws Exception {
        if (browser == null || !(browser.equals("chrome") || browser.equals("firefox") || browser.equals("edge"))) {
            throw new Exception("Invalid BROWSER value. Check the .properties file");
        }
    }

    private void validateHeadless(String headless) throws Exception {
        if (headless == null || !(headless.equals("true") || headless.equals("false"))) {
            throw new Exception("Invalid HEADLESS value. Check the .properties file");
        }
    }

}
