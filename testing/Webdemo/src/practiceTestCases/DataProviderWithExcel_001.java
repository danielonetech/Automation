package practiceTestCases;

		import java.awt.AWTException;
		import java.io.IOException;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.testng.annotations.BeforeTest;
		import org.testng.annotations.Test;
		import org.testng.annotations.DataProvider;
		import test1.Page1;
		import utility.ExcelUtilsSame;

		public class DataProviderWithExcel_001 {
	

		WebDriver driver;

	    @BeforeTest

	    public void beforeMethod() throws Exception {

	    	System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
	  	  driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://www.flipkart.com/");
	        Thread.sleep(2000); 

		}

	@Test(dataProvider="Authentication")

    public void Registration_data(String sUserName,String sPassword,String devicename)throws  Exception{

		 if(driver.getPageSource().contains("Forgot?"))
	      {
	          Page1.email(driver).sendKeys(sUserName);
	          Page1.password(driver).sendKeys(sPassword);
	          Page1.click(driver).click();
	      }
	      else
	      {
	    	  Page1.email(driver).sendKeys(sUserName);
	    	  Page1.countinue(driver).click();
	    	  Thread.sleep(2000);
	    	  Page1.logpsaw(driver).click();
	    	  Page1.password(driver).sendKeys(sPassword);
	    	  Page1.click(driver).click();
	    	}
	      Thread.sleep(5000);

		}
	
	@Test(dependsOnMethods={"Registration_data"}, dataProvider="Authentication")
	  public void maincode2(String sUserName,String sPassword,String devicename) throws AWTException, InterruptedException, IOException {
		//Search the Mobile device
	      Page1.search(driver).sendKeys(devicename);
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
	  
	  @Test(dependsOnMethods={"maincode2", "Registration_data"})
	  public void maincode3() throws AWTException, InterruptedException, IOException {
		//Logout
	      Page1.click1(driver).click();
	      Page1.click1(driver).click();
		  Thread.sleep(1000);
		  /*Page1.logout(driver).click();*/
		  Thread.sleep(1000);
	  }

	  @DataProvider
		public Object[][] Authentication() throws Exception{
			 
	        Object[][] testObjArray = ExcelUtilsSame.getTableArray("D://testing//Webdemo//src//testData//TestData.xlsx","Sheet1");

	        return (testObjArray);
	}

   /* @AfterTest

    public void afterMethod() {

  	    driver.quit();

    	}*/

}