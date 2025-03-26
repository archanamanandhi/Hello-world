package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SauceDemo {
	WebDriver driver;
	@Test
	public void launchApp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
			
	}
	@Test
	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//label[text()='Username']/../../div[2]/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//label[text()='Password']/../../div[2]/input")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
	}
	@Test
	public void navigateToMyinfo() {
		driver.findElement(By.linkText("My Info")).click();
		
	}

}
