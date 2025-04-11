package tests;

import base.BugLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import java.time.Duration;

public class SearchTests extends BaseTest {
    @Test
    public void testValidSearch() {
        HomePage homePage = new HomePage(driver);
        homePage.search("Hoodie");

        // Wait for search results to appear
        By resultsTitle = By.cssSelector("span.base");  // title of the results page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(resultsTitle));

        Assert.assertTrue(title.getText().toLowerCase().contains("search"));
    }

    @Test
    public void testInvalidSearch() {
        HomePage home = new HomePage(driver);
        home.search("xyz123@@##");
        SearchResultsPage results = new SearchResultsPage(driver);
        Assert.assertTrue(results.getNoResultsText().contains("success"));
    }

}