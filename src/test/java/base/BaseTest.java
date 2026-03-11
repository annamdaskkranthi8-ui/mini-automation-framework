package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.DriverFactory;
import utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.ITestResult;
import utils.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    protected static WebDriver driver;
    private static final Logger log = LogManager.getLogger(BaseTest.class);


    @BeforeMethod
    public void setUp() {

        String browser = ConfigReader.getProperty("browser");
        log.info("Launching browser: "+ browser);
        DriverFactory.initDriver(browser);

        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();

        log.info("Browser launched and maximized");
    }
    public static WebDriver getDriver() {
        return driver;
    }


    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            log.error("test failed: " + result.getName());
            ScreenshotUtil.captureScreenshot(driver, result.getName());
        }

        DriverFactory.quitDriver();
        log.info("Browser closed");
    }

}
