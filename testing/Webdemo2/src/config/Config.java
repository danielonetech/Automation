package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Config {
	WebDriver driver;
  @Test
  public void configure() throws Exception {
	    System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
	  	driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.goibibo.com/");
	    Thread.sleep(3000); 
		}
}
