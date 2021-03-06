package cnbcTest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cnbcpage.CnbcPage;
import org.testng.annotations.DataProvider;
import utility.ExcelUtils;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class CnbcTest {

	WebDriver driver;
	CnbcPage objgo;
	Screen s = new Screen();

	@BeforeMethod
	public void before(Method m) {
		CnbcPage.test = CnbcPage.report.startTest(m.getName());
	}

	@BeforeTest
	public void beforeMethod() throws Exception {
		CnbcPage.report = new ExtentReports(System.getProperty("user.dir") + "//ExtentReportResults.html");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation1\\chromedriver\\chromedriver.exe");
		//for head less automation
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--headless", "--disable-gpu",
		 * "--window-size=1920,1200","--ignore-certificate-errors");
		 */
		//add options as argument to ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cnbc.com/world/?region=world");
		Thread.sleep(10000);
	}
	
	

	@Test(dataProvider = "Authentication")
	public void VideoVerification(String tcname) throws Exception {
		try {
			CnbcPage objgo = new CnbcPage(driver);
			objgo.homepage();
			Thread.sleep(2000);
			s.hover("Capture.PNG");
			Thread.sleep(1000);
			objgo.topvideo();
			Thread.sleep(15000);
			objgo.getvideotitlepre();
			try {
				WebElement s = driver.findElement(By.xpath("//*[@id='video-title']"));
				if (s.isDisplayed()) {
					objgo.getvideotitlepost();
					Thread.sleep(3000);
					objgo.pause();
					Thread.sleep(2000);
					objgo.share();
					Thread.sleep(2000);
					objgo.shareicon();
					Thread.sleep(1000);
					objgo.close();
				}

			} catch (Exception e) {
				objgo.getvideotitlepost1();
				Thread.sleep(3000);
				objgo.pause1();
				Thread.sleep(2000);
				objgo.share1();
				Thread.sleep(2000);
				objgo.shareicon1();
				Thread.sleep(1000);
				objgo.close();
			}

		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String errorString = sw.toString();
			CnbcPage.test.log(LogStatus.FAIL, "PassStep1", "<p id=\"demo\" hidden>" + errorString + "</p>\n"
					+ "<button onclick=\"alert(document.getElementById('demo').innerText)\">Click me</button>");
		}

	}

	@DataProvider
	public Object[][] Authentication() throws Exception {

		Object[][] testObjArray = ExcelUtils.getTableArray("D:\\Automation\\CNBC\\src\\test\\resources\\SearchData.xlsx",
				"Sheet1");
		return (testObjArray);
	}

	@AfterMethod
	public void afterMethod() {
		CnbcPage.report.endTest(CnbcPage.test);

	}

	@AfterTest
	public void afterTest() {
		CnbcPage.report.flush();
		// driver.quit();

	}

}
