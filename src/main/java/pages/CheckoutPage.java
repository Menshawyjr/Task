package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {
    private final By proceedToCheckoutBtn = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button/span");
    private final By emailField = By.id("customer-email");
    private final By firstName = By.name("firstname");
    private final By lastName = By.name("lastname");
    private final By street = By.name("street[0]");
    private final By city = By.name("city");
    private final By zip = By.name("postcode");
    private final By phone = By.name("telephone");
    private final By region = By.name("region_id");
    private final By country = By.name("country_id");
    private final By nextBtn = By.cssSelector("button.continue");

    public CheckoutPage(WebDriver driver) { super(driver); }

    public void proceedToCheckout() {
        click(proceedToCheckoutBtn);
    }

    public void fillShippingInfo(String email, String fname, String lname, String addr, String cityName, String postal, String phoneNum) {
        waitForElement(emailField);
        type(emailField, email);
        type(firstName, fname);
        type(lastName, lname);
        type(street, addr);
        type(city, cityName);
        type(zip, postal);
        type(phone, phoneNum);
    }

    public void continueToPayment() {
        click(nextBtn);
    }
}