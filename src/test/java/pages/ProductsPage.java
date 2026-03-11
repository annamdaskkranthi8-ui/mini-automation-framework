package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    private By productsTitle = By.className("title");
    private By productItems = By.className("inventory_item");

    private By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon =  By.className("shopping_cart_link");

    public boolean isProductsPageDisplayed() {
        return driver.findElement(productsTitle).isDisplayed();
    }

    public int getProductsCount() {
        return driver.findElements(productItems).size();
    }

    public void addProductToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}
