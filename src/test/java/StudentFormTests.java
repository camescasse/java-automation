import org.example.pageObjectModels.ConfirmationModal;
import org.example.pageObjectModels.StudentForm;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class StudentFormTests {

    private ChromeDriver driver;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        Thread.sleep(500);
    }

    @Test
    public void studentForm_inputsRequiredValues_createsUser() {
        var form = new StudentForm(driver);
        form.setName("Eric", "Camescasse");
        form.setGender("Male");
        form.setMobile("8095980728");
        form.submit();

        var modal = new ConfirmationModal(driver);

        assertThat(modal.getTitleText()).isEqualTo("Thanks for submitting the form");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
