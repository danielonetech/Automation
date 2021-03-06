package jxgrid;

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

public class JxgridTest {
	static WebDriver driver;
	JxgridPage objgo;

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
		JxgridPage objgo = new JxgridPage(driver);
		Thread.sleep(4000);
		objgo.demo();
		Thread.sleep(4000);
		objgo.jqxGrid();
		Thread.sleep(4000);
		objgo.create();
		Thread.sleep(4000);
		driver.switchTo().frame("jqxInnerdemoContainer");
		objgo.addmultiple();
		Thread.sleep(5000);
		int k = 0;
		List<WebElement> rows = driver.findElements(By.xpath("//*[@role='row']"));
		for (WebElement row : rows) {
			List<WebElement> columns = row.findElements(By.xpath("//*[@columnindex='5']"));
			objgo.row();
			for (WebElement column : columns) {
				if (k < 8) {
					String value = column.getText();
					String sub = value.substring(1);
					float result = Float.parseFloat(sub);
					System.out.println(result);
					int i = 30;
					if (result > i) {
						objgo.delete();
						driver.findElement(By.xpath("//*[@id='row" + k + "grid']")).click();
						break;
					} else {
						// System.out.println("else");
						Actions action = new Actions(driver);
						action.sendKeys(Keys.DOWN).build().perform();
					}
				}
				k++;
			}
			break;
		}
		int x = 0;
		for (x = k; x < 15; x++) {
			if (x < 9) {
				WebElement value1 = driver.findElement(By.xpath("//*[@id='row" + x + "grid']/div[6]"));
				String valu = value1.getText();
				String su = valu.substring(1);
				float resul = Float.parseFloat(su);
				System.out.println(resul);
				int i = 30;
				if (resul > i) {
					objgo.delete();
					driver.findElement(By.xpath("//*[@id='row" + x + "grid']")).click();
					x--;
				} else {
					Actions action = new Actions(driver);
					action.sendKeys(Keys.DOWN).build().perform();
				}
			} else {
				int l = 8;
				int z = 0;
				int stylevalue1 = 0;
				for (z = 8; z < 20; z++) {
					String script = driver.findElement(By.id("jqxScrollAreaDownverticalScrollBargrid")).getCssValue("height");
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
					if (stylevalue1 >= 0) {
						WebElement value1 = driver.findElement(By.xpath("//*[@id='row" + l + "grid']/div[6]"));
						String valu = value1.getText();
						String su = valu.substring(1);
						float resul = Float.parseFloat(su);
						System.out.println(resul);
						int i = 30;
						if (resul > i) {
							objgo.delete();
							driver.findElement(By.xpath("//*[@id='row" + l + "grid']")).click();
							String script1 = driver.findElement(By.id("jqxScrollAreaDownverticalScrollBargrid")).getCssValue("height");
							int stylvalue1 = script1.length();
							String stylevalu1 = null;
							if (stylvalue1 == 4) {
								stylevalu1 = script1.substring(0, 2);
							}
							if (stylvalue1 == 5) {
								stylevalu1 = script1.substring(0, 3);
							}
							if (stylvalue1 == 3) {
								stylevalu1 = script1.substring(0, 1);
							}
							int stylevalue2 = 0;
							stylevalue2 = Integer.parseInt(stylevalu1);
							System.out.println("style value 2"+stylevalue2);
							System.out.println("style value 1"+stylevalue1);
							while (stylevalue2 > stylevalue1) {
								Actions action = new Actions(driver);
								action.sendKeys(Keys.DOWN).build().perform();
								stylevalue2--;
							}
						} else {
							// System.out.println("else");
							Actions action = new Actions(driver);
							action.sendKeys(Keys.DOWN).build().perform();
						}

					}
					if (stylevalue1 == 0) {
						break;
					}
				}
				if (stylevalue1 == 0) {
					break;
				}
			}
		}
	}

	/*
	 * @AfterClass public void afterMethod() 
	 * { 
	 * driver.quit(); 
	 * }
	 */

}
