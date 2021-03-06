package test;

import org.openqa.selenium.*;
 
public class Page {
   private static WebElement element = null;
 
   // enter email
   public static WebElement email(WebDriver driver) {
	   element = driver.findElement(By.xpath("//input[@type='text' and @class='_2zrpKA']"));
      return element;
   }
   
   public static WebElement password(WebDriver driver) {
	   element= driver.findElement(By.xpath("//input[@type='password']"));
      return element;
   }
   
   public static WebElement click(WebDriver driver) {
	   element= driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
      return element;
   }
   
   public static WebElement countinue(WebDriver driver) {
	   element= driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
      return element;
   }
   
   public static WebElement logpsaw(WebDriver driver) {
	   element= driver.findElement(By.xpath("//*[contains(text(),'Login with Pass')]"));
      return element;
   }
   
   public static WebElement search(WebDriver driver) {
	   element= driver.findElement(By.xpath("//input[@name='q']"));
      return element;
   }
   
   public static WebElement click1(WebDriver driver) {
	   element= driver.findElement(By.xpath("(//*[@class='_2aUbKa'])[1]"));
      return element;
   }
   public static WebElement logout(WebDriver driver) {
	   element= driver.findElement(By.xpath("//*[contains(text(),'Logout')]"));
      return element;
   }
   
   public static WebElement finding(WebDriver driver) {
	   element= driver.findElement(By.xpath("(//*[contains(text(),'Redmi Note 5 Pro (Black, 64 GB)')])[1]"));
      return element;
   }
	
}
