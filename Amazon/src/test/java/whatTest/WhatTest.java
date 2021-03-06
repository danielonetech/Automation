package whatTest;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import whatpage.WhatPage;

public class WhatTest {

	WebDriver driver;
	WhatPage objgo;

	@BeforeTest
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation1\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/gp/goldbox");
		Thread.sleep(7000);
	}

	@Test
	public void VideoVerification() throws Exception {
		WhatPage objgo = new WhatPage(driver);
		Thread.sleep(2000);
		objgo.searchhimanshu();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

}
