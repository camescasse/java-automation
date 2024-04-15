import org.example.services.DriverService;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverService.getInstance().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
