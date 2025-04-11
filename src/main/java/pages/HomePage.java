package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private final By searchBox = By.id("search");
    private final By searchIcon = By.cssSelector("button[title='Search']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String query) {
        waitForElement(searchBox);           // Ensure search box is visible
        type(searchBox, query);
        waitForElement(searchIcon);          // Ensure icon is visible
        click(searchIcon);
    }
}