package jxgrid;




import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.ExcelWrite;

public class JxgridPage {
	WebDriver driver;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "(//a[@href='/jquery-widgets-demo'])[1]")
	WebElement demo;

	@FindBy(xpath = "//*[contains(text(),'jqxGrid')]")
	WebElement jqxGrid;

	@FindBy(xpath = "(//a[@href='createremoveupdatedata.htm'])[1]")
	WebElement create;


	  @FindBy(xpath="//input[@value='Add Multiple New Rows']")
	  WebElement addmultiple;


	@FindBy(xpath= "//*[@id='deleterowbutton']")
	WebElement delete;
	
	@FindBy(xpath= "//*[@id='jqxScrollBtnDownverticalScrollBargrid']")
	WebElement scrollclick;
	
	@FindBy(xpath= "//*[@id='row0grid']")
	WebElement row;
	
	@FindBy(xpath= "//*[@id='row0grid']/div[6]")
	WebElement totalvalue;


	public JxgridPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}


	public void demo() {
		demo.click();

	}

	public void jqxGrid() {
		jqxGrid.click();

	}

	public void create() {
		create.click();

	}

	public void addmultiple() {
		addmultiple.click();

	}
	public void delete() {
		delete.click();

	}
	public void scrollclick() {
		scrollclick.click();

	}
	public void row() {
		row.click();

	}
	public void totalvalue() {
		String value=totalvalue.getText();
       // System.out.println(value);
        String sub =value.substring(1);
        //System.out.println(sub);
        float result = Float.parseFloat(sub);
        System.out.println(result);
        int i=30;
        if(result>i)
        {
       	 System.out.println("if");
       	 this.delete();
        }
        else
        {
       	 System.out.println("else");
    		Actions action = new Actions(driver);
    		action.sendKeys(Keys.DOWN).	build().perform();
        }

	}

}
