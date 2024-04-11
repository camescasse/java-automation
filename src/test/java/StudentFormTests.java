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
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void studentForm_inputsRequiredValues_createsUser() throws InterruptedException {
        var form = new StudentForm(driver);
        form.open()
            .setName("Eric", "Camescasse")
            .setGender("Male")
            .setMobile("8095980728")
            .submit();

        var modal = new ConfirmationModal(driver);

        assertThat(modal.getTitleText()).isEqualTo("Thanks for submitting the form");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
