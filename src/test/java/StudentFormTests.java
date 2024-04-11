import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class StudentFormTests {

    private ChromeDriver driver;
    JavascriptExecutor executor;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        executor = driver;
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @Test
    public void studentForm_inputsRequiredValues_createsUser() throws InterruptedException {

        var inputFirstName = driver.findElement(By.id("firstName"));
        inputFirstName.sendKeys("Eric");
        var inputLastName = driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
        inputLastName.sendKeys("Camescasse");
        var radioMaleGender = driver.findElement(By.xpath("//label[text()=\"Male\"]/.."));
        radioMaleGender.click();
        var inputMobile = driver.findElement(By.id("userNumber"));
        inputMobile.sendKeys("8095980728");
        var buttonSubmit = driver.findElement(By.id("submit"));
        executor.executeScript("arguments[0].scrollIntoView(true);", buttonSubmit);
        buttonSubmit.click();
        Thread.sleep(1000);

        var titleForm = driver.findElement(By.xpath("//div[@id=\"example-modal-sizes-title-lg\"]"));
        assertThat(titleForm.getText()).isEqualTo("Thanks for submitting the form");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
