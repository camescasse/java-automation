import org.example.pageObjectModels.upDownForm;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class UpDownFormTests extends BaseTest {

    @Test
    public void upDownForm_clicksDownload_FileDownloads() {
        var form = new upDownForm(driver).open().isFileDownloaded();

        assertThat(form).isTrue();
    }

    @Test
    public void upDownForm_uploadsFile_FormShowsFileName() {
        var fileName = "sample-doc.txt";
        var form = new upDownForm(driver).open().uploadFile(fileName);

        assertThat(form.isUploaded()).isTrue();
    }

}
