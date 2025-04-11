package tests;

import base.BugLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SecurityTests extends BaseTest {

    @Test
    public void testSqlInjectionSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.search("' OR '1'='1");

        String pageSource = driver.getPageSource();
        if (pageSource.contains("SQL syntax") || pageSource.toLowerCase().contains("database error")) {
            BugLogger.logBug(
                    "Possible SQL Injection Vulnerability",
                    "High",
                    "App should handle SQL input safely",
                    "SQL error or DB keyword found in response",
                    "Steps:\n1. Go to homepage\n2. Search with: ' OR '1'='1"
            );
        }

        Assert.assertFalse(pageSource.contains("SQL syntax"), "Potential SQL injection vulnerability detected.");
    }

    @Test
    public void testXssSearch() {
        HomePage homePage = new HomePage(driver);
        String xssPayload = "<script>alert('XSS')</script>";
        homePage.search(xssPayload);

        String pageSource = driver.getPageSource();
        if (pageSource.contains(xssPayload)) {
            BugLogger.logBug(
                    "Possible XSS Vulnerability",
                    "High",
                    "App should sanitize inputs to prevent script injection",
                    "Raw script tag found in page source",
                    "Steps:\n1. Go to homepage\n2. Search with: <script>alert('XSS')</script>"
            );
        }

        Assert.assertFalse(pageSource.contains(xssPayload), "Potential XSS vulnerability.");
    }
}
