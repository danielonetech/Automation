package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.*;

public class CalculatorV {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "8.1.0");
		capabilities.setCapability("deviceName", "EEYHRC8TZDT8Q4CU");
		capabilities.setCapability("platformName", "Android");
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appPackage", "com.android.bbkcalculator");
		capabilities.setCapability("appActivity", "com.android.bbkcalculator.Calculator");
		//Create RemoteWebDriver instance and connect to the Appium server
		// It will launch the Calculator App in Android Device using the configurations
		// specified in Desired Capabilities
		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		// capabilities);
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, capabilities);
	}

	@Test
	public void testCal() throws Exception {
		// locate the Text on the calculator by using By.name()
		MobileElement two = (MobileElement) driver.findElement(MobileBy.id("com.android.bbkcalculator:id/digit2"));
		two.click();
		MobileElement plus = (MobileElement) driver.findElement(MobileBy.id("com.android.bbkcalculator:id/plus"));
		plus.click();
		MobileElement four = (MobileElement) driver.findElement(MobileBy.id("com.android.bbkcalculator:id/digit4"));
		four.click();
		MobileElement equalTo = (MobileElement) driver.findElement(MobileBy.id("com.android.bbkcalculator:id/equal"));
		equalTo.click();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// locate the edit box of the calculator by using By.tagName()
		MobileElement results = (MobileElement) driver
				.findElement(MobileBy.id("com.android.bbkcalculator:id/input_edit"));
		// Check the calculated value on the edit box
		assert results.getText().equals("6") : "Actual value is : " + results.getText()
				+ " did not match with expected value: 6";

	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}
}