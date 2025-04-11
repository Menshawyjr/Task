package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class log {
    WebDriver driver ;

    @Test
    public void f() {
        String baseUrl = "https://www.toolsqa.com/";
        System.out.println("Launching Google Chrome browser");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        String testTitle = "Free QA Automation Tools For Everyone";
        String originalTitle = driver.getTitle();
        Assert.assertEquals(originalTitle, testTitle);
    }

}
