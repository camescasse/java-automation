package org.example.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader instance;
    private final Properties properties;

    private PropertiesReader() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(".properties")) {
            properties.load(fis);
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
        var property = properties.getProperty("BROWSER");

        return switch (property) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            default -> throw new Exception("Invalid BROWSER value. Check the .properties file");
        };
    }

}
