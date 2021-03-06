package jqxDataTable;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.ExcelWrite;

public class jqxDataTableTest {
	WebDriver driver;
	jqxDataTablePage objgo;

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

		jqxDataTablePage objgo = new jqxDataTablePage(driver);
		Thread.sleep(1000);
		objgo.demo();
		Thread.sleep(4000);
		objgo.jqxDataTable();
		Thread.sleep(4000);
		objgo.grouping();
		Thread.sleep(1000);
		objgo.grouping1();
		Thread.sleep(4000);
		driver.switchTo().frame("jqxInnerdemoContainer");
		int j=2;
		objgo.nextarrowclick();
		WebElement TxtBoxContent = driver.findElement(By.xpath("(//*[@class='jqx-grid-pager-number jqx-grid-pager-number-light jqx-rc-all jqx-rc-all-light jqx-fill-state-pressed jqx-fill-state-pressed-light'])[2]"));
		String b=TxtBoxContent.getText();
		int count1=Integer.parseInt(b);
		int k=0;
		objgo.previousarrowclick();
		for(k=1;k<count1;k++)
		{
		List<WebElement> rows = driver.findElements(By.xpath("//tr[@data-role='row-group' or @role='row']"));
		int i=0;
		String supplier = null;
		String supplierstring = null;
		String product = null;
		String price = null;
		for (WebElement row : rows) {
				try {
					WebElement tf = driver.findElement(By.xpath("//tr[@data-role='row-group' and @id='row"+i+"dataTable']"));
					tf.isDisplayed();
					supplier=tf.getText();
					supplierstring=supplier.substring(15);
				} catch (org.openqa.selenium.NoSuchElementException e) {
					WebElement tf = driver.findElement(By.xpath("//*[@id='row"+i+"dataTable']//td[2]"));
					product=tf.getText();
					WebElement tf1 = driver.findElement(By.xpath("//*[@id='row"+i+"dataTable']//td[4]"));
					price=tf1.getText();
					double pricevalue=Double.parseDouble(price.substring(1));
					if(pricevalue>10.00)
					{
					ExcelWrite eat = new ExcelWrite("D://testing//Webdemo//src//testData//jqxDataTable.xlsx");
					eat.setCellData("Sheet1","supplier",j,supplierstring);
					eat.setCellData("Sheet1","product",j,product);
			        eat.setCellData("Sheet1","price",j,price);
			        eat.setCellData("Sheet1","TestCase",j,"TestCase"+j+"");
			        j++;
					}
				}
				
			i++;
		}
		
		objgo.arrowclick();
		}
		
	}

	/*
	 * @AfterClass public void afterMethod() { driver.quit(); }
	 */

}
