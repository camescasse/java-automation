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

    public WebDriver getDriver() {
//        var browser = properties.getProperty("BROWSER");
//        if (browser == null) browser = "";
//        else browser = browser.toLowerCase();
//
//        var headlessValue = properties.getProperty("HEADLESS");
//        boolean isHeadless = headlessValue == null || headlessValue.isEmpty() || Boolean.parseBoolean(headlessValue);
//
//        return switch (browser) {
//            case "firefox" -> isHeadless ?
//                    new FirefoxDriver(new FirefoxOptions().addArguments("--headless")) :
//                    new FirefoxDriver();
//            case "edge" -> isHeadless ?
//                    new EdgeDriver(new EdgeOptions().addArguments("--headless")) :
//                    new EdgeDriver();
//            default -> isHeadless ?
//                    new ChromeDriver(new ChromeOptions().addArguments("--headless")) :
//                    new ChromeDriver();
//        };
        return new ChromeDriver();
    }

}
