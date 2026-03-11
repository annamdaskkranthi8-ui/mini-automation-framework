package tests;

import base.BaseTest;
import org.testng.Assert;
import  org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;

public class CartTest extends BaseTest {

    @Test
    public void verifyAddToCart() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.openLoginPage();
        loginPage.login("standard_user", "secret_sauce");

        productsPage.addProductToCart();
        productsPage.openCart();

        Assert.assertTrue(cartPage.isProductDisplayedInCart());

    }


}
