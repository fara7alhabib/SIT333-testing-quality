package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StemGameSeleniumTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty(
            "webdriver.chrome.driver",
            "C:\\Users\\joyal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"
        );

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://localhost:8080/login");
    }

    @Test
    public void testLoginPage() throws InterruptedException {

        WebElement username = driver.findElement(By.xpath("(//input)[1]"));
        username.sendKeys("farah");

        WebElement password = driver.findElement(By.xpath("(//input)[2]"));
        password.sendKeys("123");

        WebElement dob = driver.findElement(By.xpath("(//input)[3]"));
        dob.sendKeys("01/01/2000");

        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        Thread.sleep(2000);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}