package jenkins;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zip = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void completeCheckout(String fn, String ln, String zp) {
        driver.findElement(firstName).sendKeys(fn);
        driver.findElement(lastName).sendKeys(ln);
        driver.findElement(zip).sendKeys(zp);
        driver.findElement(continueBtn).click();
        driver.findElement(finishBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMsg).getText();
    }
}
