package org.example.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertiesReader {
    private static final Logger LOGGER = Logger.getLogger(PropertiesReader.class.getName());
    private final Properties properties;
    private static PropertiesReader instance;

    private PropertiesReader() {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream(".properties")) {
            properties.load(fis);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load properties file", e);
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
