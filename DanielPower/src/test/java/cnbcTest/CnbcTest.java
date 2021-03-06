package cnbcTest;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import cnbcpage.CnbcPage;
import utility.ExcelCompare;
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
	}

	@Test
	public void VideoVerification() throws Exception {
		try {
			String[] sheet1 = ExcelCompare
					.getTableArray("D://testing//DanielPower//src//test//resources//SearchData.xlsx", "Sheet1");
			String[] sheet2 = ExcelCompare
					.getTableArray("D://testing//DanielPower//src//test//resources//SearchData2.xlsx", "Sheet1");
			int i;
			for (i = 0; i < sheet1.length; i++) {
				System.out.println(sheet1[i]);
				String val1 = sheet1[i];
				int a = 1;
				for (int j = 0; j < sheet2.length; j++) {
					System.out.println(sheet2[j]);
					String val2 = sheet2[j];
					if (val1.equals(val2)) {
						CnbcPage.test.log(LogStatus.PASS, "PassStep1",
								"" + sheet2[j] + " is matched and available in both sheet.");
						a++;
					}
				}
				if (a < 2) {
					CnbcPage.test.log(LogStatus.FAIL, "PassStep1", "" + sheet1[i] + " is not available in sheet2.");
					a++;
				}
			}
			for (i = 0; i < sheet2.length; i++) {
				String val1 = sheet2[i];
				int a = 1;
				for (int j = 0; j < sheet1.length; j++) {
					String val2 = sheet1[j];
					if (val1.equals(val2)) {
						CnbcPage.test.log(LogStatus.PASS, "PassStep1",
								"" + sheet1[j] + " is matched and available in both sheet.");
						a++;
					}
				}
				if (a < 2) {
					CnbcPage.test.log(LogStatus.FAIL, "PassStep1", "" + sheet2[i] + " is not available in sheet1.");
					a++;
				}
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
