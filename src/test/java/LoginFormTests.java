import org.example.models.User;
import org.example.pageObjectModels.LoginForm;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class LoginFormTests extends BaseTest {

    @Test
    public void login_validCredentials_logsUserIn() {
        var form = new LoginForm(driver);
        var user = new User("jmendoza", "Juan123!");
        form.open().login(user);

        assertThat(form.isLoggedIn()).isTrue();
    }

}