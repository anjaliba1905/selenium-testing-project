package miniproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestScripts {

    // ✅ Test 1 (Already working)
	@Test
	public void testWebPage() {

	    WebDriver driver = new ChromeDriver();

	    driver.get("https://www.google.com");

	    String title = driver.getTitle();
	    System.out.println("Page Title: " + title);

	    Assert.assertTrue(title.contains("Google"));

	    // 👇 Add this
	    try {
	        Thread.sleep(3000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    driver.quit();
	}

    // ✅ Test 2 (Add here)
	@Test
	public void testTitleEquals() {

	    WebDriver driver = new ChromeDriver();

	    driver.get("https://www.google.com");

	    // 👇 WAIT UNTIL TITLE LOADS
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.titleContains("Google"));

	    String title = driver.getTitle();
	    System.out.println("Title: " + title);

	    Assert.assertEquals(title, "Google");

	    driver.quit();
	}
    // ✅ Test 3 (Add here)
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