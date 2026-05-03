package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationSeleniumTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\joyal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void testValidRegistration() {

        // Open your local HTML file
        driver.get("file:///C:/Users/joyal/OneDrive/Desktop/SIT333/7.1P-resources/webservice1/src/main/resources/register.html");

        driver.findElement(By.name("fname")).sendKeys("Farah");
        driver.findElement(By.name("lname")).sendKeys("Ali");
        driver.findElement(By.name("email")).sendKeys("farah@gmail.com");
        driver.findElement(By.name("dob")).sendKeys("2000-01-01");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // No assert needed, just test flow
    }
    @Test
    public void testInvalidRegistration() {

        driver.get("file:///C:/Users/joyal/OneDrive/Desktop/SIT333/7.1P-resources/webservice1/src/main/resources/register.html");

        // Leave fields empty or wrong
        driver.findElement(By.name("fname")).sendKeys("");
        driver.findElement(By.name("lname")).sendKeys("");
        driver.findElement(By.name("email")).sendKeys("farahgmail.com"); // invalid
        driver.findElement(By.name("dob")).sendKeys("");

        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}