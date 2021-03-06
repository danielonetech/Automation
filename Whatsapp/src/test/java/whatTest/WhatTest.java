package whatTest;

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

import org.testng.annotations.DataProvider;
import utility.ExcelUtils;
import whatpage.WhatPage;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class WhatTest {

	WebDriver driver;
	WhatPage objgo;

	@BeforeMethod
	public void before(Method m) {
		WhatPage.test = WhatPage.report.startTest(m.getName());
	}

	@BeforeTest
	public void beforeMethod() throws Exception {
		WhatPage.report = new ExtentReports(System.getProperty("user.dir") + "//ExtentReportResults.html");
		System.setProperty("webdriver.chrome.driver", "D:\\Automation1\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://web.whatsapp.com/");
		Thread.sleep(7000);
	}

	@Test /* (dataProvider = "Authentication") */
	public void VideoVerification() throws Exception {
		/* try { */
		WhatPage objgo = new WhatPage(driver);
		Thread.sleep(2000);
		//int a = 2;
		//for (int i = 0; i < a; i++) {
			/*
			 * objgo.searchhimanshu(); Thread.sleep(4000); objgo.himanshuclick();
			 * Thread.sleep(4000); objgo.entermessage(); Thread.sleep(1000); objgo.send();
			 * Thread.sleep(2000); objgo.searchakshay(); Thread.sleep(4000);
			 * objgo.akshayclick(); Thread.sleep(4000); objgo.entermessage();
			 * Thread.sleep(1000); objgo.send(); Thread.sleep(2000); objgo.searchshivam();
			 * Thread.sleep(4000); objgo.shivamclick(); Thread.sleep(4000);
			 * objgo.entermessage(); Thread.sleep(1000); objgo.send();
			 */
			
			Thread.sleep(1000);
			objgo.searchayushi();
			Thread.sleep(4000);
			objgo.ayushiclick();
			Thread.sleep(4000);
			int a = 2;
			for (int i = 1; i < a; i++) {
			objgo.entermessage(i);
			Thread.sleep(1000);
			objgo.send();
			a++;
		}

		/*
		 * } catch (Exception e) { StringWriter sw = new StringWriter(); PrintWriter pw
		 * = new PrintWriter(sw); e.printStackTrace(pw); String errorString =
		 * sw.toString(); WhatPage.test.log(LogStatus.FAIL, "PassStep1",
		 * "<p id=\"demo\" hidden>" + errorString + "</p>\n" +
		 * "<button onclick=\"alert(document.getElementById('demo').innerText)\">Click me</button>"
		 * ); }
		 */

	}

	/*
	 * @DataProvider public Object[][] Authentication() throws Exception {
	 * 
	 * Object[][] testObjArray = ExcelUtils .getTableArray(
	 * "D:\\Automation\\Whatsapp\\src\\test\\resources\\whatsapp.xlsx", "Sheet1");
	 * return (testObjArray); }
	 */

	@AfterMethod
	public void afterMethod() {
		WhatPage.report.endTest(WhatPage.test);

	}

	@AfterTest
	public void afterTest() {
		WhatPage.report.flush();
		driver.quit();

	}

}
