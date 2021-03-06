package search;

import java.lang.reflect.Method;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.DataProvider;
import utility.ExcelUtils;

public class SearchTest {

	WebDriver driver;
	SearchPage objgo;
	public static ExtentTest test;
	public static ExtentReports report;

	@BeforeMethod
	public void before(Method m) {
		test = report.startTest(m.getName());
	}

	@BeforeTest
	public void beforeMethod() throws Exception {
		report = new ExtentReports(System.getProperty("user.dir") + "//ExtentReportResults.html");
		System.setProperty("webdriver.chrome.driver", "D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
	}

	@Test(dataProvider = "Authentication")
	public void Registration_data(String test1, String searchdata) throws Exception {
		SearchPage objgo = new SearchPage(driver);
		objgo.search(searchdata);
		Actions action = new Actions(driver);
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		if (driver.getPageSource().contains("cricket score")) {
			test.log(LogStatus.PASS, "PassStep1", "Navigated to the specified URL1");
		} else {
			test.log(LogStatus.FAIL, "FailStep1", "Test Failed1");

		}
	}

	@Test
	public void test1() throws Exception {
		if (driver.getPageSource().contains("cricket score?")) {
			test.log(LogStatus.PASS, "PassStep2", "Navigated to the specified URL1");
		} else {
			test.log(LogStatus.FAIL, "FailStep2", "Test Failed2");

		}
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils
				.getTableArray("D://testing//GoogleSearch//src//test//resources//SearchData.xlsx", "Sheet1");
		return (testObjArray);
	}

	@AfterMethod
	public void afterMethod() {
		report.endTest(test);

	}

	@AfterTest
	public void afterTest() {
		report.flush();
		driver.quit();

	}

}
