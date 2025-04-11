package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage extends pages.BasePage {
    private final By sizeOption = By.cssSelector(".swatch-option.text");
    private final By colorOption = By.cssSelector(".swatch-option.color");
    private final By addToCartBtn = By.id("product-addtocart-button");
    private final By cartCount = By.cssSelector("span.count"); // This is the cart count element
    private final By cartProductList = By.cssSelector("div.cart-items"); // The list of products in the cart (you may need to adjust this based on the actual HTML)

    private final By basketIcon = By.className("counter-number");  // The class of the "My Cart" button
    private final By confirmationMessage = By.cssSelector("div.message-success.success");  // The success message (change if necessary)

    public ProductPage(WebDriver driver) { super(driver); }

    public void addFirstVariantToCart() {
        click(sizeOption);
        click(colorOption);
        click(addToCartBtn);
    }
    public void clickBasketIcon() {
        waitForElementToBeClickable(basketIcon);  // Wait until the basket icon is clickable
        click(basketIcon);  // Click on the basket icon to go to the cart page
    }
    public boolean isProductAddedToCart() {
        try {
            // Wait for the confirmation message that shows the product was added to the cart
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage));

            return true;  // If the confirmation message appears, the product is added
        } catch (Exception e) {
            return false;  // Return false if the confirmation message is not found
        }
    }
    public boolean isProductInCart(String productName) {
        waitForElement(cartProductList);  // Wait for the product list to appear
        return driver.findElement(cartProductList).getText().contains(productName);
    }

}