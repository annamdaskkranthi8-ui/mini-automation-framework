package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.TestData;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void verifyLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.openLoginPage();
        loginPage.login(username, password);

        Assert.assertTrue(productsPage.isProductsPageDisplayed());
        Assert.assertTrue(productsPage.getProductsCount() > 0);
    }
}
