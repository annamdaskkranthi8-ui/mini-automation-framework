package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckoutFlow() {
      LoginPage loginPage = new LoginPage(driver);
      ProductsPage productsPage = new ProductsPage(driver);
      CartPage cartPage = new CartPage(driver);
      CheckoutPage checkoutPage = new CheckoutPage(driver);

      loginPage.openLoginPage();
      loginPage.login("standard_user", "secret_sauce");

      productsPage.addProductToCart();
      productsPage.openCart();

      cartPage.clickCheckout();

      try {
          driver.switchTo().alert().accept();
      } catch (Exception  e)  {

      }

      checkoutPage.enterCheckoutDetails("John", "Doe", "500001");
      checkoutPage.finishOrder();

      Assert.assertTrue(checkoutPage.isOrderSuccessful());

    }

}

