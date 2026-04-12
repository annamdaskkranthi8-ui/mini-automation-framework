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
    public void enterUsername(String user ) { getElement(username).sendKeys(user);
    }
    public void enterPassword(String pass) { getElement(password).sendKeys(pass);
    }
    public void clickLogin() {
        getElement(loginButton).click();
    }
    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public boolean isErrorDisplayed() {
        try {
            waitForVisibility(By.xpath("//h3[@data-test='error']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
