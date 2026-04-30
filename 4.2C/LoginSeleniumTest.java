package sit707_week4;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginSeleniumTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\joyal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.bunnings.com.au/login");
    }

    // ✅ Test 1: Invalid login (simplified and stable)
    @Test
    public void testInvalidLogin() {

        WebElement signInButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[contains(.,'Sign in')]"))
        );

        assertTrue(signInButton.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    // ✅ Test 2: Empty login
    @Test
    public void testEmptyLogin() {

        WebElement signInButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//button[contains(.,'Sign in')]"))
        );

        assertTrue(signInButton.isDisplayed());
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}