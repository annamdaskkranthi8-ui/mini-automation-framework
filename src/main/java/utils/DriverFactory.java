package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;
import java.util.HashMap;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {

        WebDriver localDriver;

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-notifications");
            options.addArguments("--disable-sav-password-bubble");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-password-manager-reauthentication");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("cresdentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);

            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            options.setExperimentalOption("useAutomationExtension", false);

            localDriver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {

            localDriver = new EdgeDriver();

        } else {
            throw new RuntimeException("Browser not supported");
        }

        driver.set(localDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}