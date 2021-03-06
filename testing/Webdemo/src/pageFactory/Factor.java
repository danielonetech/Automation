package pageFactory;

		import java.awt.AWTException;
import java.io.IOException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.FactoryPage;


		 public class Factor {
			 public String sTestCaseName;
			 public int iTestCaseRow;
		 
			 private String sUserName = "";
			 private String sPassword = "";
			 private String devicename = "";
		 
			 FactoryPage objLogin;
			 WebDriver driver;
		public Factor(String sUserName,String sPassword,String devicename) {
			this.sUserName = sUserName;
			this.sPassword = sPassword;
			this.devicename = devicename;
		}
	
		
	    @BeforeClass
	    public void beforeMethod() throws Exception {
	    System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
	  	driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.flipkart.com/");
	    Thread.sleep(2000); 
		}
	    
	 
	    @Test
	public void Registration_data()throws  Exception{
	    	
		objLogin = new FactoryPage(driver);
		 if(driver.getPageSource().contains("Forgot?"))
	      {
			
			 objLogin.loginToGuru1(sUserName, sPassword);
	      }
	      else
	      {
	    	 
	    	 objLogin.loginToGuru2(sUserName, sPassword);
	    	}
	      Thread.sleep(5000);
		}
	
	@Test(dependsOnMethods={"Registration_data"})
	public void maincode2() throws AWTException, InterruptedException, IOException {
		//Search the Mobile device
		objLogin = new FactoryPage(driver);
		objLogin.deviceCheck(devicename);
		Actions action = new Actions(driver);
	    action.sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(5000);
	      //Condition to check device is present or not
	      if(driver.getPageSource().contains("Redmi Note 5 Pro (Black, 64 GB)"))
	      {
	    	 System.out.println("Model Is available.");

	      }
	      else
	      {
	    	  System.out.println("Model not available.");
	      }
	  }
	@Test(dependsOnMethods={"maincode2", "Registration_data"})
	public void maincode3() throws InterruptedException{
		//Logout
		objLogin = new FactoryPage(driver);
		objLogin.logout();
		Thread.sleep(1000);
	  }

   @AfterClass
    public void afterMethod() {
  	    driver.quit();
    	}
  
}