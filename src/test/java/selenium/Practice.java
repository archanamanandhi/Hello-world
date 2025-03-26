package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		WebElement link= driver.findElement(By.linkText("Shifting Content"));
		link.click();
		 driver.findElement(By.linkText("Example 1: Menu Element")).click();
		 List<WebElement> links=driver.findElements(By.tagName("li"));
		 for(WebElement eachlink:links) {
			 System.out.println(eachlink.getText());
			 
		 }
		 
		
	}

}
