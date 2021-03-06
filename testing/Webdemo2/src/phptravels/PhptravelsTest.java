package phptravels;




import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

		public class PhptravelsTest {
		WebDriver driver;
		PhptravelsPage objgo;
		private String email;
		private String password;
		private String booingid;
		private String value;
		private String email2;
		private String password2;
		private String booingid2;
		private String value2;
		




		public  PhptravelsTest(String email, String password, String booingid, String value,String email2, String password2, String booingid2, String value2){
			this.email = email;
			this.password = password;
			this.booingid = booingid;
			this.value = value;
			this.email2 = email2;
			this.password2 = password2;
			this.booingid2 = booingid2;
			this.value2 = value2;
		    }


	    @BeforeSuite
	    public void beforeMethod() throws Exception {
	    	System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
	  	driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.phptravels.net/");
	    Thread.sleep(2000); 
	    }


	    @Test
	    public void Google()throws  Exception{
		PhptravelsPage objgo= new PhptravelsPage(driver);
		Thread.sleep(10000);
		objgo.MyAccount();
		objgo.login();
	    Thread.sleep(5000);
	    objgo.email(email);
	    objgo.password(password);
	    Thread.sleep(2000);
	    objgo.loginButton();
	    Thread.sleep(5000);
	    objgo.invoice1();
	    String winHandleBefore = driver.getWindowHandle();
	    objgo.switchhandler();
		Thread.sleep(7000);
		objgo.value1(value);
		driver.close();
		// Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);
		objgo.invoice2();		
		objgo.switchhandler();
		Thread.sleep(5000);
		objgo.value2(value2);
	    }

		 @AfterClass
		    public void afterMethod() {
		  	    driver.quit();
		    	}
		
		}
		

