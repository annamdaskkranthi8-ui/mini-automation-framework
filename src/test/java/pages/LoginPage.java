package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");

    public void openLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }
    public void enterUsername(String user ) {
        driver.findElement(username).sendKeys(user);
    }
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

}
