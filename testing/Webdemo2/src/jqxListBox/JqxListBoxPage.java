package jqxListBox;



import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JqxListBoxPage {
	WebDriver driver;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "(//a[@href='/jquery-widgets-demo'])[1]")
	WebElement demo;

	@FindBy(xpath = "//*[contains(text(),'jqxListBox')]")
	WebElement jqxListBox;
	
	@FindBy(xpath = "(//a[@href='multipleselection.htm'])[1]")
	WebElement multiple;
	
	@FindBy(id = "jqxScrollBtnDownverticalScrollBarjqxWidget")
	WebElement scrollclick;


	public JqxListBoxPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}


	public void demo() {
		demo.click();

	}

	public void jqxTextArea() {
		jqxListBox.click();

	}

	public void multiple() {
		multiple.click();

	}
	
	public void scrollclick() {
		scrollclick.click();

	}
	
}


