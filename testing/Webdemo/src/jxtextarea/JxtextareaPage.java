package jxtextarea;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JxtextareaPage {
	WebDriver driver;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "(//a[@href='/jquery-widgets-demo'])[1]")
	WebElement demo;

	@FindBy(xpath = "//*[contains(text(),'jqxTextArea')]")
	WebElement jqxTextArea;

	@FindBy(xpath = "(//a[@href='javascript-textarea-multiple-items.htm'])[1]")
	WebElement multiple;
	
	@FindBy(xpath= "//*[@id='jqxTextAreaTextArea']")
	WebElement country;


	public JxtextareaPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}


	public void demo() {
		demo.click();

	}

	public void jqxTextArea() {
		jqxTextArea.click();

	}

	public void multiple() {
		multiple.click();

	}
	public void country(String name) {
		country.sendKeys(name);

	}
	
}

