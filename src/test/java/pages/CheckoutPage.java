package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
        private By firstName = By.id("first-name");
        private By lastName = By.id("last-name");
        private By postalCode = By.id("postal-code");
        private By continueBtn = By.id("continue");
        private By finishBtn = By.id("finish");
        private By successMsg = By.className("complete-header");

        public void enterCheckoutDetails(String fName, String lName, String zip) {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(fName);
            driver.findElement(lastName).sendKeys(lName);
            driver.findElement(postalCode).sendKeys(zip);
            driver.findElement(continueBtn).click();
        }
        public void finishOrder() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(finishBtn));
            driver.findElement(finishBtn).click();
        }

        public boolean isOrderSuccessful() {
            return driver.findElement(successMsg).isDisplayed();
        }


    }
