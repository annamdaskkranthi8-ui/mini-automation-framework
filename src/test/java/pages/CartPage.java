package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super (driver);
    }

    private By cartItem = By.className("inventory_item_name");
    private By checkoutBtn = By.id("checkout");

    public boolean isProductDisplayedInCart() {
        return driver.findElement(cartItem).isDisplayed();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }
}
