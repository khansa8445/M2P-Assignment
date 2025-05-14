package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Set;

public class SeleniumAutomationTasks {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        
        driver.get("https://www.selenium.dev/");
        String title = driver.getTitle();
        if (title.contains("Selenium")) {
            System.out.println(" Selenium website loaded successfully.");
        }

        
        WebElement downloadsLink = driver.findElement(By.xpath("//nav//a[normalize-space()='Downloads']"));
        downloadsLink.click();
        wait.until(ExpectedConditions.urlContains("/downloads"));
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/downloads")) {
            System.out.println(" Downloads page URL is correct.");
        }

       
        //driver.quit();
    }
}
