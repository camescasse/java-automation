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
        var browser = properties.getProperty("BROWSER");
        var headless = properties.getProperty("HEADLESS");

        if (browser != null && (browser.equals("chrome") || browser.equals("firefox") || browser.equals("edge"))) {
            if (headless.equals("true") || headless.equals("false")) {
                if (browser.equals("chrome") && headless.equals("true")) {
                    var driverOptions = new ChromeOptions();
                    driverOptions.addArguments("--headless");
                    return new ChromeDriver(driverOptions);
                } else if (browser.equals("chrome")) {
                    return new ChromeDriver();
                } else if (browser.equals("firefox") && headless.equals("true")) {
                    var driverOptions = new FirefoxOptions();
                    driverOptions.addArguments("--headless");
                    return new FirefoxDriver(driverOptions);
                } else if (browser.equals("firefox")) {
                    return new FirefoxDriver();
                } else if (headless.equals("true")) {
                    var driverOptions = new EdgeOptions();
                    driverOptions.addArguments("--headless");
                    return new EdgeDriver(driverOptions);
                } else {
                    return new EdgeDriver();
                }
            } else {
                throw new Exception("Invalid HEADLESS value. Check the .properties file");
            }
        } else {
            throw new Exception("Invalid BROWSER value. Check the .properties file");
        }
    }

}
