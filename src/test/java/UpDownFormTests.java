import org.example.pageObjectModels.upDownForm;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class UpDownFormTests extends BaseTest {

    @Test
    public void upDownForm_clicksDownload_FileDownloads() {
        var upDownForm = new upDownForm(driver).open().isFileDownloaded();

        assertThat(upDownForm).isTrue();
    }

}
