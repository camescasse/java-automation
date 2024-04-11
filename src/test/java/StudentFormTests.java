import org.example.pageObjectModels.ConfirmationModal;
import org.example.pageObjectModels.StudentForm;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class StudentFormTests extends BaseTests {

    @Test
    public void studentForm_inputsRequiredValues_createsUser() throws InterruptedException {
        new StudentForm(driver)
                .open()
                .setName("Eric", "Camescasse")
                .setGender("Male")
                .setMobile("8095980728")
                .submit();

        var modal = new ConfirmationModal(driver);

        assertThat(modal.getTitleText()).isEqualTo("Thanks for submitting the form");
    }
}
