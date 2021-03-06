package test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

public class NewTest {
	public WebDriver driver = null;
	  

  @BeforeTest
  public void f() throws InterruptedException{
	  System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
	  driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.flipkart.com/");
      Thread.sleep(2000);
  }
  
  
  
  @Test
  public void maincode1() throws AWTException, InterruptedException, IOException {
	 
      
	  if(driver.getPageSource().contains("Forgot?"))
      {
          Page.email(driver).sendKeys("8475864264");
          Page.password(driver).sendKeys("@Feb2019");
          Page.click(driver).click();
      }
      else
      {
    	  Page.email(driver).sendKeys("8475864264");
    	  Page.countinue(driver).click();
    	  Thread.sleep(1000);
    	  Page.logpsaw(driver).click();
    	  Page.password(driver).sendKeys("@Feb2019");
    	  Page.click(driver).click();
    	}
      Thread.sleep(5000);
      
  }
  
  @Test(dependsOnMethods={"maincode1"})
  public void maincode2() throws AWTException, InterruptedException, IOException {
	//Search the Mobile device
      Page.search(driver).sendKeys("redmi note 5 pro");
      Thread.sleep(2000);
      Actions action = new Actions(driver);
 
      action.sendKeys(Keys.ENTER).build().perform();
      Thread.sleep(5000);
      //Condition to check device is present or not
      if(driver.getPageSource().contains("Redmi Note 5 Pro (Black, 64 GB)?"))
      {
    	 System.out.println("Model Is available.");

      }
      else
      {
    	  System.out.println("Model not available.");
      }
  }
  
  @Test(dependsOnMethods={"maincode2", "maincode1"})
  public void maincode3() throws AWTException, InterruptedException, IOException {
	//Logout
      Page.click1(driver).click();
      Page.click1(driver).click();
	  Thread.sleep(1000);
	  Page.logout(driver).click();
	  Thread.sleep(1000);
  }
  
  
  
  /*@AfterTest
  public void end(){
	  //Close the Browser.
      driver.quit();
  }*/
}
