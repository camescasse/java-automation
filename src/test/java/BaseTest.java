import org.example.services.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = PropertiesReader.getInstance().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
