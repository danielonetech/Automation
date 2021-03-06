package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class ChromeAmazon {

	WebDriver driver1;
	// WebDriver driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// Set up desired capabilities and pass the Android app-activity and app-package
		// to Appium

		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "10.0.0");
		capabilities.setCapability("deviceName", "717d00ea");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("ignoreHiddenApiPolicyError", "true");
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("skip", "cleanup");
		capabilities.setCapability("appPackage", "com.android.chrome");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.IntentDispatcher");
//		 capabilities.setCapability("autoWebview", "true");
//		capabilities.setCapability("unicodeKeyboard", "false");
//		capabilities.setCapability("resetKeyboard", "true");

//		 Create RemoteWebDriver instance and connect to the Appium server
//		 It will launch the Calculator App in Android Device using the configurations
//		 specified in Desired Capabilities
//		URL url = new URL("http://127.0.0.1:4723/wd/hub");
//	    driver = new AndroidDriver<MobileElement>(url, capabilities);
//		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//      driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}

	@Test
	public void testCal() throws Exception {
		driver1 = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// It will directly open the required URL
		driver1.get("https://www.amazon.in/");

		// Alternative : It is manually process. First click Tab. open new Tab then
		// search the URL
		// like we do manually.
		// WebElement newTab
		// =driver1.findElement(By.id("com.android.chrome:id/tab_switcher_button"));
		// newTab.click();
		// MobileElement newTab1 = (MobileElement)
		// driver1.findElement(MobileBy.AccessibilityId("New tab"));
		// newTab1.click();
		// MobileElement search = (MobileElement)
		// driver1.findElement(By.id("com.android.chrome:id/search_box_text"));
		// search.click();
		// MobileElement text = (MobileElement)
		// driver1.findElement(MobileBy.id("com.android.chrome:id/url_bar"));
		// text.sendKeys("www.amazon.in");
		// ((RemoteWebDriver) driver1).executeScript("mobile:performEditorAction",
		// ImmutableMap.of("action","search"));
		// driver.hideKeyboard();

		// Change the View
		// Set<String> contextNames = ((AppiumDriver) driver1).getContextHandles();
		// for (String contextName : contextNames) {
		// System.out.println(contextName); //prints out something like NATIVE_APP \n
		// WEBVIEW_1
		// if(contextName.contains("WEBVIEW"))
		// ((AppiumDriver) driver1).context(contextName);
		// System.out.println("Switched to WebView");
		// }
		
	//	driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver1.findElement(MobileBy.AccessibilityId("Clear search keywords")).click();
		Actions action = new Actions(driver1);
		action.sendKeys("Luminous Audie 1200mm").perform();
		((PressesKey) driver1).pressKey(new KeyEvent(AndroidKey.ENTER));
		WebDriverWait wait=new WebDriverWait(driver1, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("	\r\n"
				+ "//android.view.View[@content-desc=\"Sponsored Luminous Audie 1200mm 70-Watt Ceiling Fan (Mirage White) 4.1 out of 5 stars 655\"]/android.view.View[2]")));
		driver1.findElement(By.xpath("	\r\n"
				+ "//android.view.View[@content-desc=\"Sponsored Luminous Audie 1200mm 70-Watt Ceiling Fan (Mirage White) 4.1 out of 5 stars 655\"]/android.view.View[2]"))
				.click();
	//	driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//WebDriverWait wait=new WebDriverWait(driver1, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@content-desc=\"Visit the Luminous Store\"]/android.widget.TextView")));
		// Scroll Function
		MobileElement scroll = (MobileElement) driver1
				.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
						+ ".scrollIntoView(new UiSelector().resourceIdMatches(\"add-to-cart-button\").text(\"Add to Cart\"))"));
		scroll.click();
		System.out.println("Cart is Open");
// Switching between app
//		driver.startActivity(new Activity(amazonAppPackageName, amazonAppActivityName));
//		WebElement AmSearch = driver.findElement(By.xpath("//*[text()=\"What are you looking for?\"]"));
//		AmSearch.clear();
//		AmSearch.sendKeys("Room Heater");
//		driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action","search"));

	}

	@AfterClass
	public void close() {
		// close the app
		//driver1.quit();
	}
}