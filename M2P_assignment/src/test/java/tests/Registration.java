package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


 
public class Registration {
	
	WebDriver driver = new ChromeDriver() ;
	
	@BeforeMethod

	public void Setup() throws InterruptedException {
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	
	}
	
	@Test
	
	public void Registered() throws InterruptedException {
		
		
		
		driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
		Thread.sleep(2000);
		
		
		//check box fro male and female
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
		Thread.sleep(2000);
		
		//first name
		driver.findElement(By.id("FirstName")).sendKeys("John");
		Thread.sleep(2000);
		
		// last name
		driver.findElement(By.id("LastName")).sendKeys("Shea");
		Thread.sleep(2000);
		 
		//email
		driver.findElement(By.id("Email")).sendKeys("user@example.com");
		Thread.sleep(2000);
		
		//password
		driver.findElement(By.id("Password")).sendKeys("John@1234");
		Thread.sleep(2000);
		
		//confirm password
		driver.findElement(By.id("ConfirmPassword")).sendKeys("John@1234");
		Thread.sleep(2000);
		
		// register button
		driver.findElement(By.id("register-button")).click();
		
		
		
		//search for product
		driver.findElement(By.id("small-searchterms")).sendKeys("Laptop");
				
		//click search button
		driver.findElement(By.xpath("//input[@value='Search']")).click();
				
		//click on first appearing product and adding it into cart		
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
				
		}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
