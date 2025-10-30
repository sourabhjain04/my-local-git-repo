package jenkins;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenLoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce", true},
            {"locked_out_user", "secret_sauce", false},
            {"problem_user", "secret_sauce", true},
            {"invalid", "wrong", false}
        };
    }

    @Test(dataProvider = "loginData", groups = {"Regression"})
    public void testMultipleLogins(String user, String pass, boolean expectedSuccess) {
        LoginPage login = new LoginPage(driver);
        login.login(user, pass);
        boolean success = driver.getCurrentUrl().contains("inventory");
        Assert.assertEquals(success, expectedSuccess, "Login validation failed for: " + user);
    }
}
