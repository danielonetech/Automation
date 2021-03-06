package combo;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExcelWrite;

public class ComboPage {
	WebDriver driver;

	@FindBy(id = "fname")
	WebElement fname;

	@FindBy(id = "lname")
	WebElement lname;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "sdate")
	WebElement sdate;

	@FindBy(xpath = "//button[@name='Save']")
	WebElement save;

	public ComboPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void fname(String search) {
		fname.clear();
		fname.sendKeys(search);
	}
	
	public void lname(String search) {
		lname.clear();
		lname.sendKeys(search);
	}
	
	public void email(String search) {
		email.clear();
		email.sendKeys(search);
	}
	
	public void sdate(String search) {
		sdate.clear();
		sdate.sendKeys(search);
	}

	public void save() {
		save.click();
	}
		
}
