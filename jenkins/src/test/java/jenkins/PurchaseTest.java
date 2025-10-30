package jenkins;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ScreenshotListener.class)

public class PurchaseTest extends BaseTest {

    @Test(groups = {"Regression"})
    public void verifyPurchaseFlow() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        HomePage home = new HomePage(driver);
        home.addFirstProductToCart();
        home.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.completeCheckout("John", "Doe", "12345");

        Assert.assertEquals(checkout.getSuccessMessage(), "Thank you for your order!");
    }
}
