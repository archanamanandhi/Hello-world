package selenium;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.Wait;

import org.apache.logging.log4j.core.lookup.MainMapLookup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class Juiceshop {
	
public static void main(String[] args) throws InterruptedException {
	 //WebDriverManager.chromedriver().driverVersion("latest").setup();
	WebDriver driver=new ChromeDriver();
	driver.get("https://juice-shop.herokuapp.com/#/login");
//	driver.get("https://juice-shop.herokuapp.com/#/register");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement dismissButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Dismiss']")));
	dismissButton.click();
	WebElement cookies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Me want it!']")));
	cookies.click();

	
	
	//register
	
//	driver.findElement(By.id("emailControl")).sendKeys("arcman29@gmail.com");
//	
//	driver.findElement(By.id("passwordControl")).sendKeys("12345");
//	driver.findElement(By.id("repeatPasswordControl")).sendKeys("12345");
//	WebElement dropdown=driver.findElement(By.xpath("//div[@id='mat-select-value-1']/span"));
//	dropdown.click();
//	
//	driver.findElement(By.xpath("//span[text()=' Your eldest siblings middle name? ']")).click();
//	driver.findElement(By.id("securityAnswerControl")).sendKeys("mc");
//	
//	WebElement register=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='registerButton'][@type='submit']")));
//	((JavascriptExecutor)driver).executeScript("arguments[0].click();", register);
//	
	//login
	
	
	
WebElement email=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
email.sendKeys("arcman123@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
	driver.findElement(By.xpath("//span[@class='mat-button-wrapper'][text()=' Log in ']")).click();
	
Actions action=new Actions(driver);
//adding items in 1st page
JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement item1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Add to Basket']")));
js.executeScript("arguments[0].click();", item1);
WebElement item2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Eggfruit Juice (500ml)']/../../../div[2]/button/span/span")));
js.executeScript("arguments[0].click();", item2);

WebElement nextpage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mat-paginator-range-actions']/button[2]")));
//((JavascriptExecutor)driver).executeScript("arguments[0].click();", nextpage);
js.executeScript("arguments[0].click();", nextpage);

//adding items in 2nd page
Thread.sleep(2000);

WebElement item3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' OWASP Juice Shop CTF Girlie-Shirt ']/../../../div[2]/button/span/span")));
item3.click();
//action.moveToElement(item3).click().perform();
WebElement item4=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' OWASP Juice Shop Hoodie']/../../../div[2]/button/span/span")));
item4.click();
//js.executeScript("arguments[0].click();", item4);
Thread.sleep(2000);
WebElement nextpage1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Next page']")));

js.executeScript("arguments[0].click();", nextpage1);
driver.close();	
	
	
	
}

}
