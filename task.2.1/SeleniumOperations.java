package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

public class SeleniumOperations {

    public static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // ---------- FIRST WEBSITE ----------
    public static void officeworks_registration_page(String url) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\joyal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        sleep(3);

        driver.findElement(By.id("firstname")).sendKeys("Farah");
        driver.findElement(By.id("lastname")).sendKeys("Alhabib");
        driver.findElement(By.id("email")).sendKeys("fara7alhabib@gmail.com");
        driver.findElement(By.id("password")).sendKeys("12345678");
        driver.findElement(By.id("confirmPassword")).sendKeys("12345678");

        driver.findElement(By.xpath("//button[contains(text(),'Create account')]")).click();

        sleep(2);

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("officeworks.png");
            FileHandler.copy(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sleep(2);
        driver.close();
    }



    // ---------- SECOND WEBSITE ----------
    public static void demoqa_form(String url) {

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\joyal\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get(url);
        sleep(3);

        driver.findElement(By.id("firstName")).sendKeys("Farah");
        driver.findElement(By.id("lastName")).sendKeys("Alhabib");
        driver.findElement(By.id("userEmail")).sendKeys("fara7alhabib@gmail.com");

        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.findElement(By.id("userNumber")).sendKeys("0400000000");

        sleep(2);

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("demoqa.png");
            FileHandler.copy(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        sleep(2);
        driver.close();
    }



    // ---------- MAIN ----------
    public static void main(String[] args) {

        officeworks_registration_page(
                "https://www.officeworks.com.au/app/identity/create-account"
        );

        demoqa_form(
                "https://demoqa.com/automation-practice-form"
        );
    }
}