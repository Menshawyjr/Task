package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductPage;

public class CheckoutTests extends BaseTest {
    @Test
    public void testAddedtoCart() {
        HomePage home = new HomePage(driver);
        // Step 1: Search for a product (valid search)
        home.search("Hoodie");  // Replace with the actual product search term
        driver.findElement(By.cssSelector(".product-item-link")).click();
        ProductPage product = new ProductPage(driver);
        product.addFirstVariantToCart();
        // Step 3: Use ProductPage method to verify the product was added to the cart
        Assert.assertTrue(productPage.isProductAddedToCart(), "The product was not added to the cart.");
        productPage.clickBasketIcon();  // Navigate to the cart
    }
}