package jenkins;


import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"Smoke"})
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login Failed!");
    }

    @Test(groups = {"Regression"})
    public void invalidLoginTest() {
        LoginPage login = new LoginPage(driver);
        login.login("wrong_user", "wrong_pass");
        Assert.assertTrue(login.getErrorMessage().contains("Epic sadface"), "Error message not displayed!");
    }
}
