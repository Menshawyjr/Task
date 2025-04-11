package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {
    private final By results = By.cssSelector(".product-item");
    private final By noResultsMsg = By.cssSelector(".message.notice");

    public SearchResultsPage(WebDriver driver) { super(driver); }

    public boolean hasResults() {
        return driver.findElements(results).size() > 0;
    }

    public String getNoResultsText() {
        return getText(noResultsMsg);
    }
}
