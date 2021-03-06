package jxtextarea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class JxtextareaTest {
	static WebDriver driver;
	JxtextareaPage objgo;

	@BeforeClass
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.jqwidgets.com/");
		Thread.sleep(10000);
	}

	@Test
	public void Google() throws Exception {
		String sCurrentLine;
		BufferedReader br = new BufferedReader(new FileReader(
				"D://testing//Webdemo//src//testData//Jxtextarea.txt"));

		JxtextareaPage objgo = new JxtextareaPage(driver);
		Thread.sleep(4000);
		objgo.demo();
		Thread.sleep(4000);
		objgo.jqxTextArea();
		Thread.sleep(4000);
		objgo.multiple();
		Thread.sleep(4000);
		driver.switchTo().frame("jqxInnerdemoContainer");
		while ((sCurrentLine = br.readLine()) != null) {
			System.out.println(sCurrentLine);
			String[] arrSplit1 = sCurrentLine.split(",");
			int l = arrSplit1.length;
			for(int i=0;i<l;i++)
			{
			objgo.country(arrSplit1[i]);
			Thread.sleep(4000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
			}
		}
		br.close();
	}

	/*
	 * @AfterClass public void afterMethod() { driver.quit(); }
	 */

}
