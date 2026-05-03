package web.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginServiceTest {

    private WebDriver driver;

    private final String driverPath =
            "C:\\Users\\joyal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";

    private final String loginPagePath =
            "file:///C:/Users/joyal/OneDrive/Desktop/SIT333/7.1P-resources/pages/login.html";

    private void sleep(long sec) {
        try { Thread.sleep(sec * 1000); } catch (Exception e) {}
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(loginPagePath);
        sleep(2);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void login(String user, String pass, String dob) {

        // Username
        WebElement e = driver.findElement(By.id("username"));
        e.clear();
        e.sendKeys(user);

        // Password
        e = driver.findElement(By.id("passwd"));
        e.clear();
        e.sendKeys(pass);

        // 🔥 FIX: Set date using JavaScript (guaranteed to work)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('dob').value='" + dob + "';");

        // Submit
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        sleep(2);
    }

    @Test
    public void testSuccess() {
        login("farah", "farah_pass", "2003-07-13");
        Assert.assertEquals("success", driver.getTitle());
    }

    @Test
    public void testFailWrongUser() {
        login("wrong", "farah_pass", "2003-07-13");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testFailWrongPass() {
        login("farah", "wrong", "2003-07-13");
        Assert.assertEquals("fail", driver.getTitle());
    }

    @Test
    public void testFailWrongDob() {
        login("farah", "farah_pass", "2000-01-01");
        Assert.assertEquals("fail", driver.getTitle());
    }
}