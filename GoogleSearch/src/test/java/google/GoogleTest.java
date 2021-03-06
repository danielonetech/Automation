package google;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import googleMain.GooglePage;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {
	WebDriver driver;
	GooglePage objgo;
	/*
	 * public static ExtentTest test; public static ExtentReports report;
	 */
	private String search;
	private String searchfield;
	private String Address;
	private String Password;
	private String Email;
	private String Comment;

	public GoogleTest(String tc, String search, String searchfield, String Address, String Email, String Password,
			String Comment) {

		this.search = search;
		this.searchfield = searchfield;
		this.Address = Address;
		this.Email = Email;
		this.Password = Password;
		this.Comment = Comment;
	}
	
	@BeforeMethod
	public void before(Method m) {
		GooglePage.test = GooglePage.report.startTest(m.getName());
	}

	@BeforeTest
	public void beforeMethod() throws Exception {
		GooglePage.report = new ExtentReports(System.getProperty("user.dir") + "//ExtentReportResults.html");
		System.setProperty("webdriver.chrome.driver", "D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
	}

	@Test
	public void Google() throws Exception {
try {
		GooglePage objgo = new GooglePage(driver);
		Thread.sleep(5000);
		objgo.googleApps();
		Thread.sleep(7000);
		objgo.Maps();
		Thread.sleep(5000);
		objgo.Searchbox(search);
		Thread.sleep(7000);
		GooglePage.test.log(LogStatus.PASS, "PassStep1", "Google Function working fine.");
}catch(org.openqa.selenium.NoSuchElementException e)
{
	GooglePage.test.log(LogStatus.FAIL, "PassStep1", "Google Function terminated from the middle.");
}

	}

	@Test
	public void Google1() throws Exception {
		try {
		String actualTitle = searchfield;
		for (int i = 0; i < 10; i++) {
			String tagName = driver.findElement(By.id("sbse" + i)).getText();
			System.out.println(tagName);

			if (tagName.contains(actualTitle)) {
				GooglePage.test.log(LogStatus.PASS, "PassStep1", "Search Content Found");
				Thread.sleep(7000);
				driver.findElement(By.id("sbse" + i)).click();
				break;

			} else {
				GooglePage.test.log(LogStatus.FAIL, "PassStep1", "Search Content Not Found");
			}
		}
		}catch(org.openqa.selenium.NoSuchElementException e)
		{
			GooglePage.test.log(LogStatus.FAIL, "PassStep1", "Google1 Function terminated from the middle.");
		}

	}

	@Test
	public void Google2() throws Exception {
		try {
		GooglePage objgo = new GooglePage(driver);
		Thread.sleep(7000);
		objgo.address(Address);
		Thread.sleep(10000);
		objgo.review();
		Thread.sleep(5000);

		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		objgo.email(Email);
		objgo.next_id();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement passwordElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		passwordElement.click();
		passwordElement.clear();
		passwordElement.sendKeys(Password);
		System.out.println(Password);
		Thread.sleep(10000);
		objgo.nextpassword();
		Thread.sleep(5000);
		driver.switchTo().window(winHandleBefore);
		driver.switchTo().frame("goog-reviews-write-widget");
		Thread.sleep(5000);
		objgo.star();
		Thread.sleep(2000);
	
		}catch(org.openqa.selenium.NoSuchElementException e)
		{
			GooglePage.test.log(LogStatus.FAIL, "PassStep1", "Google2 Function terminated from the middle.");
		}}

	@Test
	public void Google3() throws Exception {
		try
		{
		GooglePage objgo = new GooglePage(driver);
		Thread.sleep(2000);
		objgo.comment(Comment);
		Thread.sleep(2000);
		objgo.post();
		Thread.sleep(2000);
		objgo.done();
		
		WebElement ayushi1 = driver.findElement(By.xpath("//*[contains(text(),'Ayushi Agrawal')]"));
		ayushi1.click();
		Thread.sleep(2000);
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		objgo.Validate(Comment);
		}catch(org.openqa.selenium.NoSuchElementException e)
		{
			GooglePage.test.log(LogStatus.FAIL, "PassStep1", "Google3 Function terminated from the middle.");
		}
	}
	
	@AfterMethod
	public void afterMethod() {
		GooglePage.report.endTest(GooglePage.test);

	}

	@AfterTest
	public void afterTest() {
		GooglePage.report.flush();
		//driver.quit();
	}

}
