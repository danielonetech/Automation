package jqxDataTable;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class jqxDataTablePage {
	WebDriver driver;
	String b;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "(//a[@href='/jquery-widgets-demo'])[1]")
	WebElement demo;

	@FindBy(xpath = "//*[contains(text(),'jqxDataTable')]")
	WebElement jqxDataTable;
	
	@FindBy(xpath = "(//*[text()='Grouping'])[1]")
	WebElement grouping;
	
	@FindBy(xpath = "(//*[text()='Grouping'])[2]")
	WebElement grouping1;
	
	@FindBy(xpath = "(//*[@title='next'])[2]")
	WebElement arrowclick;
	
	@FindBy(xpath = "(//*[@title='last'])[2]")
	WebElement nextarrowclick;
	
	@FindBy(xpath = "(//*[@title='first'])[2]")
	WebElement previousarrowclick;
	
	@FindBy(xpath = "(//*[@class='jqx-grid-pager-number jqx-grid-pager-number-light jqx-rc-all jqx-rc-all-light jqx-fill-state-pressed jqx-fill-state-pressed-light'])[2]")
	WebElement count;


	public jqxDataTablePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void demo() {
		demo.click();

	}

	public void jqxDataTable() {
		jqxDataTable.click();

	}

	public void grouping() {
		grouping.click();

	}
	
	public void grouping1() {
		grouping1.click();

	}
	
	public void arrowclick() {
		arrowclick.click();

	}
	
	public void nextarrowclick() {
		nextarrowclick.click();

	}
	
	public void previousarrowclick() {
		previousarrowclick.click();

	}
	
	public void count() {
		b=count.getText();
		System.out.println(b);
	}
	
}
