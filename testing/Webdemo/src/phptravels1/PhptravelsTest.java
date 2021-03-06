package phptravels1;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PhptravelsTest {
	static WebDriver driver;
	PhptravelsPage objgo;
	private String email;
	private String password;
	private String booingid;
	private String value;
	private String hotelname;
	private String test;
	private String testname;

	public PhptravelsTest(String testname,String email, String password, String hotelname,String booingid, String value, String test) {
		this.testname = testname;
		this.email = email;
		this.password = password;
		this.hotelname = hotelname;
		this.booingid = booingid;
		this.value = value;
		this.test = test;
	}

	@BeforeClass
	public void beforeMethod() throws Exception {
		if(testname.equals("TestCase1"))
		{
		System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");
		Thread.sleep(10000);
		}
	}

	@Test
	public void Google() throws Exception {
		System.out.println(booingid);
		/*System.out.println(email);
		System.out.println(password);
		System.out.println(hotelname);
		System.out.println(booingid);
		System.out.println(value);*/
		PhptravelsPage objgo = new PhptravelsPage(driver);

		//String numberAsString = Integer.toString(1555);
		
		if (testname.equals("TestCase1")) 
		{
			//System.out.println("Booking Id is (if)" + booingid);
			Thread.sleep(10000);
			objgo.MyAccount();
			objgo.login();
			Thread.sleep(5000);
			objgo.email(email);
			objgo.password(password);
			Thread.sleep(2000);
			objgo.loginButton();
			Thread.sleep(70000);
			objgo.invoice1(booingid, hotelname);
			String winHandleBefore = driver.getWindowHandle();
			objgo.switchhandler();
			Thread.sleep(7000);
			objgo.value1(value);
			driver.close();
			// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);
		} else {
			//System.out.println("Booking Id is (else)" + booingid);
			objgo.invoice2(booingid, hotelname);
			objgo.switchhandler();
			Thread.sleep(5000);
			objgo.value2(value);
		}
	}

	
	  @AfterSuite 
	  public void afterMethod() { 
		  driver.quit(); 
		  }
	 

}
