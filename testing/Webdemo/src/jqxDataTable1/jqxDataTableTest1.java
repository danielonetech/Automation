package jqxDataTable1;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utility.ExcelWrite;

public class jqxDataTableTest1 {
	WebDriver driver;
	jqxDataTablePage1 objgo;

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

		jqxDataTablePage1 objgo = new jqxDataTablePage1(driver);
		Thread.sleep(1000);
		objgo.demo();
		Thread.sleep(3000);
		objgo.jqxDataTable();
		Thread.sleep(4000);
		objgo.fluidsize();
		Thread.sleep(4000);
		driver.switchTo().frame("jqxInnerdemoContainer");
		//int j=2;
		objgo.lastarrowclick();
		WebElement TxtBoxContent = driver.findElement(By.xpath("(//*[@class='jqx-grid-pager-number jqx-grid-pager-number-light jqx-rc-all jqx-rc-all-light jqx-fill-state-pressed jqx-fill-state-pressed-light'])[2]"));
		String b=TxtBoxContent.getText();
		int count1=Integer.parseInt(b);
		int k=0;
		objgo.previousarrowclick();
		int j=2;
		for(k=1;k<=count1;k++)
		{
			
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@data-role='row-group' or @role='row']"));
		String quantity = null;
		String product = null;
		int i=1;
		for (WebElement row : rows) {
			System.out.println("TestA");
					WebElement tf = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[3]"));
					System.out.println("TestB");
					product=tf.getText();
					System.out.println(product);
					WebElement tf1 = driver.findElement(By.xpath("//tbody//tr["+i+"]//td[4]"));
					quantity=tf1.getText();
					System.out.println(quantity);
					int pricevalue=Integer.parseInt(quantity);
					System.out.println("test1");
					if(pricevalue>6)
					{
						System.out.println("test2");
					ExcelWrite eat = new ExcelWrite("D://testing//Webdemo//src//testData//jqxDataTable1.xlsx");
					System.out.println("test3");
					eat.setCellData("Sheet1","product",j,product);
					System.out.println("test4");
					eat.setCellData("Sheet1","quantity",j,quantity);
					System.out.println("test5");
					eat.setCellData("Sheet1","testname",j,"Testname");
					System.out.println("test6");
					j++;
					System.out.println("test7");
					}


					int z=1;
					for(int l=0;l<50;l++)
					{
						if(z==2)
							break;
					if(i>=32)
					{
					int stylevalue1 = 0;
					String script = driver.findElement(By.id("jqxScrollAreaDownverticalScrollBartable")).getCssValue("height");
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
					if (stylevalue1 == 0)
					{
						break;
					}
						WebElement arrow = driver.findElement(By.xpath("//*[@id='jqxScrollBtnDownverticalScrollBartable']"));
						arrow.click();
					}
					
					}
					z++;
					
					System.out.println("testN");
				
			i++;
			System.out.println("test8");
		}
		System.out.println("test9");
		objgo.arrowclick();
		
		}
	}

	/*
	 * @AfterClass public void afterMethod() { driver.quit(); }
	 */

}
