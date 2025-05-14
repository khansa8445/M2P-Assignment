package tests;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Demo {
    
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    public void setUp() throws InterruptedException {
        
        //  Handle Alert
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("alertButton"));
        alertButton.click();
        
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        if (alertText.equals("You clicked a button")) {
            System.out.println(" Alert text is correct.");
        }
        alert.accept();

        //  Switch to iframe 
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        WebElement heading = driver.findElement(By.id("sampleHeading"));
        String headingText = heading.getText();
        if (headingText.equals("This is a sample page")) {
            System.out.println("iFrame heading text is correct.");
        }
        driver.switchTo().defaultContent();
        
        
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        Demo demoTest = new Demo();
        demoTest.setUp();
    }
}
