package jqxDataTable1;



import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class jqxDataTablePage1 {
	WebDriver driver;
	String b;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "(//a[@href='/jquery-widgets-demo'])[1]")
	WebElement demo;

	@FindBy(xpath = "//*[contains(text(),'jqxDataTable')]")
	WebElement jqxDataTable;
	
	@FindBy(xpath = "(//*[text()='Fluid Size'])[1]")
	WebElement fluidsize;
	
	@FindBy(xpath = "(//*[@title='last'])[2]")
	WebElement lastarrowclick;
	
	@FindBy(xpath = "(//*[@title='first'])[2]")
	WebElement previousarrowclick;
	
	@FindBy(xpath = "(//*[@title='next'])[2]")
	WebElement arrowclick;
	



	public jqxDataTablePage1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void demo() {
		demo.click();

	}

	public void jqxDataTable() {
		jqxDataTable.click();

	}

	public void fluidsize() {
		fluidsize.click();

	}
	
	public void lastarrowclick() {
		lastarrowclick.click();

	}
	
	public void previousarrowclick() {
		previousarrowclick.click();

	}
	
	public void arrowclick() {
		arrowclick.click();

	}
	
}
