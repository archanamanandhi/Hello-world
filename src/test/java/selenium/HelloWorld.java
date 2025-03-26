package selenium;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class HelloWorld {
	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		WebDriver chromedriver=new ChromeDriver();
		chromedriver.get("https://the-internet.herokuapp.com/");
		chromedriver.manage().window().fullscreen();
		System.out.println(chromedriver.getTitle());
	}

}
