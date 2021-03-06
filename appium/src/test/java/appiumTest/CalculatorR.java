package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.*;

public class CalculatorR {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "10.0.0");
		capabilities.setCapability("deviceName", "717d00ea");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("ignoreHiddenApiPolicyError", "true");
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("skip", "cleanup");
		capabilities.setCapability("appPackage", "com.coloros.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		// Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the configurations
		// specified in Desired Capabilities
//		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//		driver = new AndroidDriver<MobileElement>(url, capabilities);
//		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		MobileElement clear = (MobileElement) driver.findElement(By.id("com.coloros.calculator:id/clr"));
		clear.click();
		MobileElement two = (MobileElement) driver.findElement(By.id("com.coloros.calculator:id/digit_2"));
		two.click();
		MobileElement plus = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Add"));
		plus.click();
		MobileElement four = (MobileElement) driver.findElement(MobileBy.id("com.coloros.calculator:id/digit_4"));
		four.click();
		MobileElement equalTo = (MobileElement) driver.findElement(MobileBy.AccessibilityId("Equals"));
		equalTo.click();
		MobileElement results = (MobileElement) driver.findElement(MobileBy.id("com.coloros.calculator:id/result"));
		System.out.println("Result ="+results.getText());
		// Check the calculated value on the edit box
		assert results.getText().equals("6") : "Actual value is : " + results.getText()
				+ " did not match with expected value: 6";

	}

	@AfterClass
	public void close() {
		// close the app
		//driver.quit();
	}
}