package tests;

import base.BugLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ProductPage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    protected ProductPage productPage;  // Add ProductPage object

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup(); // Automatically handles driver version
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com");
        productPage = new ProductPage(driver);  // Initialize ProductPage
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String title = "Test Failure: " + result.getMethod().getMethodName();
            String severity = "High"; // You can later customize severity per test
            String expected = "Test should pass without exceptions.";
            String actual = result.getThrowable() != null ? result.getThrowable().toString() : "Unknown Failure";
            String steps = "1. Launch browser\n2. Navigate to homepage\n3. Execute test: " + result.getMethod().getMethodName();

            BugLogger.logBug(title, severity, expected, actual, steps);
        }

        if (driver != null) {
            driver.quit();
        }
    }

}
