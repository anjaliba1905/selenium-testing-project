package miniproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestScripts {

    //  Common method to create driver 
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        return new ChromeDriver(options);
    }
    //  Test 1
    @Test
    public void testWebPage() {

        WebDriver driver = createDriver();

        driver.get("https://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Google"));

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.contains("Google"));

        driver.quit();
    }
    //  Test 2
    @Test
    public void testTitleEquals() {

        WebDriver driver = createDriver();

        driver.get("https://www.google.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Google"));

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertEquals(title, "Google");

        driver.quit();
    }
    // Test 3 (API Test)
    @Test
    public void testStatusCode() throws Exception {

        java.net.URL url = new java.net.URL("https://www.google.com");
        java.net.HttpURLConnection connection =
                (java.net.HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.connect();

        int code = connection.getResponseCode();
        System.out.println("Status Code: " + code);

        Assert.assertEquals(code, 200);
    }
}