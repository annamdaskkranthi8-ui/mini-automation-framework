package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.TestData;

public class LoginTest extends BaseTest {

    @Test(
            dataProvider = "loginData",
            dataProviderClass = TestData.class,
            retryAnalyzer = utils.RetryAnalyzer.class
    )
    public void verifyLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.openLoginPage();
        loginPage.login(username, password);

        if (username.equals("locked_outgit_user")) {
            Assert.assertTrue(loginPage.isErrorDisplayed(), "Error message not displayed");
        } else {
            Assert.assertTrue(productsPage.isProductsPageDisplayed(), "Products page not displayed");
        }
    }
}
