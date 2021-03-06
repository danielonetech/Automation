package flipkartTest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import flipkarpage.FlipPage;
import org.testng.annotations.DataProvider;
import utility.ExcelUtils;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class FlipTest {

	WebDriver driver;
	FlipPage objgo;
	Screen s = new Screen();

	@BeforeMethod
	public void before(Method m) {
		FlipPage.test = FlipPage.report.startTest(m.getName());
	}

	@BeforeTest
	public void beforeMethod() throws Exception {
		FlipPage.report = new ExtentReports(System.getProperty("user.dir") + "//ExtentReportResults.html");
		System.setProperty("webdriver.chrome.driver", "D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
	}

	@Test(dataProvider = "Authentication")
	public void LogIn(String tcname, String title, String mobile, String password, String name, String checkname)
			throws Exception {
		try {
			FlipPage objgo = new FlipPage(driver);
			objgo.cross();
			Thread.sleep(1000);
			if (s.find("Logo.PNG") != null) {
				FlipPage.test.log(LogStatus.PASS, "PassStep1", "Home Page loaded Successfully");
			} else {
				FlipPage.test.log(LogStatus.FAIL, "PassStep1", "Home Page is not loaded Successfully");
			}

			// objgo.homepage();
			Thread.sleep(1000);
			objgo.login();
			Thread.sleep(1000);
			if (driver.getPageSource().contains("Forgot?")) {
				objgo.entermobile(mobile);
				Thread.sleep(1000);
				objgo.password(password);
				Thread.sleep(1000);
				objgo.clicklogin();
			} else {
				objgo.entermobile(mobile);
				Thread.sleep(1000);
				objgo.continu();
				Thread.sleep(1000);
				objgo.logpasw();
				Thread.sleep(1000);
				objgo.password(password);
				Thread.sleep(1000);
				objgo.clicklogin();
			}
			Thread.sleep(4000);
			objgo.username(name);
			Thread.sleep(3000);
			objgo.myprofile();
			Thread.sleep(4000);
			objgo.edit();
			Thread.sleep(1000);
			objgo.name(checkname);
			Thread.sleep(1000);
			objgo.save();
			Thread.sleep(1000);
			objgo.namevrify(checkname);
			Thread.sleep(1000);
			objgo.logout();
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String errorString = sw.toString();
			FlipPage.test.log(LogStatus.FAIL, "PassStep1", "<p id=\"demo\" hidden>" + errorString + "</p>\n"
					+ "<button onclick=\"alert(document.getElementById('demo').innerText)\">Click me</button>");
		}

	}

	@DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils
				.getTableArray("D://testing//FlipkartName//src//test//resources//SearchData.xlsx", "Sheet1");
		return (testObjArray);
	}

	@AfterMethod
	public void afterMethod() {
		FlipPage.report.endTest(FlipPage.test);

	}

	@AfterTest
	public void afterTest() {
		FlipPage.report.flush();
		// driver.quit();

	}

}
