package jenkins;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(groups = {"Smoke"})
    public void verifyLogout() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        HomePage home = new HomePage(driver);
        home.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"), "Logout Failed!");
    }
}
