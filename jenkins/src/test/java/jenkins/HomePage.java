package jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By firstProduct = By.cssSelector(".inventory_item:first-of-type .btn_inventory");
    By cartIcon = By.className("shopping_cart_link");
    By menuBtn = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void addFirstProductToCart() {
        driver.findElement(firstProduct).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }

    public void logout() {
        driver.findElement(menuBtn).click();
        driver.findElement(logoutLink).click();
    }
}
