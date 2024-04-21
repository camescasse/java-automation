import org.example.models.User;
import org.example.pageObjectModels.NavBar;
import org.example.pageObjectModels.ProfilePage;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class LoginFormTests extends BaseTest {

    @Test
    public void login_validCredentials_logsUserIn() {
        var navbar = new NavBar(driver);
        var user = new User("jmendoza", "Juan123!");
        var loginPage = navbar.goBookStore().login();
        loginPage.login(user);

        var profile = new ProfilePage(driver);

        assertThat(profile.isLoggedIn()).isTrue();
    }

}