package jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By checkoutBtn = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
