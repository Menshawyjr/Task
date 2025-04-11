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
    public void testValidCheckout1() {
        HomePage home = new HomePage(driver);
        // Step 1: Search for a product (valid search)
        home.search("Hoodie");  // Replace with the actual product search term
        driver.findElement(By.cssSelector(".product-item-link")).click();
        ProductPage product = new ProductPage(driver);
        product.addFirstVariantToCart();
        // Step 3: Use ProductPage method to verify the product was added to the cart
        Assert.assertTrue(productPage.isProductAddedToCart(), "The product was not added to the cart.");
        // Step 4: Optionally, verify that the correct product is in the cart
       // Assert.assertTrue(productPage.isProductInCart("Hoodie"), "The correct product is not in the cart.");
        // Step 5: Use ProductPage method to click the basket icon
        productPage.clickBasketIcon();  // Navigate to the cart
//        BasePage base= new BasePage(driver);
//        // Step 6: Proceed to checkout
//        base.waitForElementToBeClickable(proceedToCheckoutButton);
//        click(proceedToCheckoutButton);
//
//        // Step 7: Fill out shipping information (address, etc.)
//        waitForElementToBeClickable(shippingAddressField);
//        type(shippingAddressField, "123 Test Street");
//
//        // Step 8: Fill in payment information (credit card, etc.)
//        waitForElementToBeClickable(paymentMethodField);
//        type(paymentMethodField, "4111111111111111");  // Test card number
//
//        // Step 9: Confirm the order
//        waitForElementToBeClickable(confirmOrderButton);
//        click(confirmOrderButton);
//
//        // Step 10: Validate order confirmation
//        String confirmationText = getText(orderConfirmationMessage);
//        Assert.assertTrue(confirmationText.contains("Thank you for your purchase"));
    }
    @Test
    public void testInvalidCheckout() {
        HomePage home = new HomePage(driver);
        home.search("hoodie");
        driver.findElement(By.cssSelector(".product-item-link")).click();
        ProductPage product = new ProductPage(driver);
        product.addFirstVariantToCart();
        driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a")).click();
     //   productPage.clickBasketIcon();  // Navigate to the cart
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.proceedToCheckout();
        checkout.fillShippingInfo("", "", "", "", "", "", "");
        checkout.continueToPayment();

        WebElement error = driver.findElement(By.cssSelector(".field-error")).isDisplayed()
                ? driver.findElement(By.cssSelector(".field-error")) : null;
        Assert.assertNotNull(error, "Expected validation error not displayed");
    }

    @Test
    public void testValidCheckout() {
        HomePage home = new HomePage(driver);
        home.search("hoodie");
        driver.findElement(By.cssSelector(".product-item-link")).click();
        ProductPage product = new ProductPage(driver);
        product.addFirstVariantToCart();
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.proceedToCheckout();
        checkout.fillShippingInfo("test@mail.com", "John", "Doe", "123 Street", "Toronto", "M1M1M1", "1234567890");
        checkout.continueToPayment();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "Did not reach payment step");
    }
}