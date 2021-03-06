package jqxListBox;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqxListBoxTest {
	static WebDriver driver;
	JqxListBoxPage objgo;

	@BeforeClass
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.jqwidgets.com/");
		Thread.sleep(10000);
	}

	@Test
	public void Google() throws Exception {

		JqxListBoxPage objgo = new JqxListBoxPage(driver);
		Thread.sleep(1000);
		objgo.demo();
		Thread.sleep(4000);
		objgo.jqxTextArea();
		Thread.sleep(4000);
		objgo.multiple();
		Thread.sleep(4000);
		driver.switchTo().frame("jqxInnerdemoContainer");
		List<WebElement> rows = driver.findElements(By.xpath("//*[@role='option']"));
		int i = 1;
		int j=0;
		boolean checkresultGrid = false;
		
		for (WebElement row : rows) {
			if(i<=10)
			{
			if (i % 2 != 0) {
				try {
					WebElement tf = driver.findElement(By.xpath("//*[@aria-selected='true' and @id='listitem"+ j + "jqxWidget']"));
					tf.isDisplayed();
					checkresultGrid = true;
				} catch (org.openqa.selenium.NoSuchElementException e) {
					checkresultGrid = false;
				}

				if (checkresultGrid == true) {
				} 
				else {
					row.click();
				}
			}

			if (i % 2 == 0) {
				try {
					WebElement tf = driver.findElement(By.xpath("//*[@aria-selected='true' and @id='listitem"+ j + "jqxWidget']"));
					tf.isDisplayed();
					checkresultGrid = true;
				} catch (org.openqa.selenium.NoSuchElementException e) {
					checkresultGrid = false;
				}

				if (checkresultGrid == true) {
					row.click();
				}
			}
			i++;
			j++;
		}
		}		
		
		while(i>10)
		{
			j=9;
			objgo.scrollclick();
			objgo.scrollclick();
			objgo.scrollclick();
		if (i % 2 != 0) {
			try {
				WebElement tf = driver.findElement(By.xpath("//*[@aria-selected='true' and @id='listitem"+ j + "jqxWidget']"));
				tf.isDisplayed();
				checkresultGrid = true;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				checkresultGrid = false;
			}

			if (checkresultGrid == true) {
			} 
			else {
				driver.findElement(By.xpath("//*[@id='listitem"+ j + "jqxWidget']")).click();
			}
		}

		if (i % 2 == 0) {
			try {
				WebElement tf = driver.findElement(By.xpath("//*[@aria-selected='true' and @id='listitem"+ j + "jqxWidget']"));
				tf.isDisplayed();
				checkresultGrid = true;
			} catch (org.openqa.selenium.NoSuchElementException e) {
				checkresultGrid = false;
			}

			if (checkresultGrid == true) {
				driver.findElement(By.xpath("//*[@id='listitem"+ j + "jqxWidget']")).click();
			}
		}
		
		int stylevalue1 = 0;
		String script = driver.findElement(By.id("jqxScrollAreaDownverticalScrollBarjqxWidget")).getCssValue("height");
		int stylevalue = script.length();
		String stylevalu = null;
		if (stylevalue == 4) {
			stylevalu = script.substring(0, 2);
		}
		if (stylevalue == 5) {
			stylevalu = script.substring(0, 3);
		}
		if (stylevalue == 3) {
			stylevalu = script.substring(0, 1);
		}
		stylevalue1 = Integer.parseInt(stylevalu);
		if (stylevalue1 < 5)
		{
			break;
		}
		i++;
	}
		
		
		
		
		
		
		
		
		
		
	}

	/*
	 * @AfterClass public void afterMethod() { driver.quit(); }
	 */

}
