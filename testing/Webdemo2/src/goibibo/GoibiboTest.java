package goibibo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import goibibo.GoibiboPage;


		 public class GoibiboTest {
		GoibiboPage objLogin;
		WebDriver driver;
		private String name= "";
		private String checkindate= "";
		private String checkoutdate= "";
		private String actualcheckin= "";
		private String actualcheckout= "";
		private String title;
		
		public GoibiboTest(String name,String checkindate,String checkoutdate,String actualcheckin,String actualcheckout,String title) {
			this.name = name;
			this.checkindate = checkindate;
			this.checkoutdate = checkoutdate;
			this.actualcheckin = actualcheckin;
			this.actualcheckout = actualcheckout;
			this.title=title;
		}
		
	    @BeforeClass
	    public void beforeMethod() throws Exception {
	    	System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
		  	driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://www.goibibo.com/");
		    Thread.sleep(3000); 
		}
	    
	 
	    @Test
	    public void Registration_data()throws  Exception{
		objLogin = new GoibiboPage(driver);
		objLogin.booking(name,checkindate, checkoutdate,actualcheckin,actualcheckout,title);
	    }
	

	  /*@AfterClass
	    public void afterMethod() {
  	    driver.quit();
    	}*/
  
}