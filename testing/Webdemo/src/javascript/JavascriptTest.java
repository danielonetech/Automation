package javascript;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptTest {
	WebDriver driver;
	JavascriptPage objgo;
	private String email;
	private String password;
	private String customer;
	private String customerid;

	public JavascriptTest(String testname, String email, String password,String customer, String customerid) {
		this.email = email;
		this.password = password;
		this.customer = customer;
		this.customerid = customerid;
	}

	@BeforeClass
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/");
		Thread.sleep(10000);
	}

	@Test
	public void Google() throws Exception {
		JavascriptPage objgo = new JavascriptPage(driver);
		String[] arrSplit1 = customer.split(",");
		objgo.userid(email);
		Thread.sleep(1000);
		objgo.password(password);
		objgo.login1();
		Thread.sleep(3000);
		objgo.newcustomer();
		Thread.sleep(5000);
		objgo.customername(arrSplit1[0]);
		Thread.sleep(1000);
		objgo.genderm();
		objgo.dob(arrSplit1[2]);
		Thread.sleep(1000);
		objgo.address(arrSplit1[3]);
		Thread.sleep(1000);
		objgo.city(arrSplit1[4]);
		Thread.sleep(1000);
		objgo.state(arrSplit1[5]);
		Thread.sleep(1000);
		objgo.pin(arrSplit1[6]);
		Thread.sleep(1000);
		objgo.mnumber(arrSplit1[7]);
		Thread.sleep(1000);
		objgo.newemail(arrSplit1[8]);
		Thread.sleep(1000);
		objgo.newpassword(arrSplit1[9]);
		Thread.sleep(1000);
		objgo.submit();
		Thread.sleep(3000);
		objgo.getcustomerid();
	}

	/*@AfterClass
	public void afterMethod() {
		driver.quit();
	}*/

}
