package tests;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class HeroApp {

    WebDriver driver = new ChromeDriver();

    public void setUp() throws InterruptedException {

        
        driver.get("https://the-internet.herokuapp.com/windows");
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindows = driver.getWindowHandles();
        for (String win : allWindows) {
            if (!win.equals(mainWindow)) {
                driver.switchTo().window(win);
                break;
            }
        }

        if (driver.getTitle().contains("New Window")) {
            System.out.println(" New window title is correct.");
        }

        driver.close(); 
        driver.switchTo().window(mainWindow);

        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long initialScroll = (long) js.executeScript("return window.pageYOffset;");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        
        long finalScroll = (long) js.executeScript("return window.pageYOffset;");

        if (finalScroll > initialScroll) {
            System.out.println("Scrolled to the bottom of the page successfully.");
        }

        driver.quit(); 
    }

    public static void main(String[] args) throws InterruptedException {
        HeroApp obj = new HeroApp();
        obj.setUp();
    }
}
