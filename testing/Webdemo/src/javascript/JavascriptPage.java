package javascript;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExcelWrite;

public class JavascriptPage {
	WebDriver driver;
	
	

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "//input[@name='uid']")
	WebElement userid;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@name='btnLogin']")
	WebElement login;

	@FindBy(xpath = "//a[@href='addcustomerpage.php']")
	WebElement newcustomer;

	@FindBy(xpath = "//input[@name='name']")
	WebElement customername;

	@FindBy(xpath = "//input[@value='m']")
	WebElement genderm;

	@FindBy(xpath = "//input[@value='f']")
	WebElement genderf;

	@FindBy(xpath = "//input[@id='dob']")
	WebElement dob;

	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement address;

	@FindBy(xpath = "//input[@name='city']")
	WebElement city;

	@FindBy(xpath = "//input[@name='state']")
	WebElement state;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pin;

	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement mnumber;

	@FindBy(xpath = "//input[@name='emailid']")
	WebElement newemail;

	@FindBy(xpath = "//input[@name='password']")
	WebElement newpassword;

	@FindBy(xpath = "//input[@name='sub']")
	WebElement submit;
	
	@FindBy(xpath = "//*[@id='customer']/tbody/tr[4]/td[2]")
	WebElement getcustomerid;
	
	
		

	public JavascriptPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void userid(String Userid) {
		userid.sendKeys(Userid);

	}

	public void password(String Password) {
		password.sendKeys(Password);

	}

	public void login1() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		JavascriptPage nw = new JavascriptPage(driver);
		js1.executeScript("arguments[0].click();", nw.login);

	}

	public void newcustomer() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", newcustomer);

	}

	public void customername(String Customername) {
		customername.sendKeys(Customername);

	}

	public void genderm() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", genderm);

	}

	public void genderf() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", genderf);

	}

	public void dob(String Dob) {
		dob.sendKeys(Dob);

	}

	public void address(String Address) {
		address.sendKeys(Address);

	}

	public void city(String City) {
		city.sendKeys(City);

	}

	public void state(String State) {
		state.sendKeys(State);

	}

	public void pin(String Pin) {
		pin.sendKeys(Pin);

	}

	public void mnumber(String Mnumber) {
		mnumber.sendKeys(Mnumber);

	}

	public void newemail(String Newemail) {
		newemail.sendKeys(Newemail);

	}

	public void newpassword(String Newpassword) {
		newpassword.sendKeys(Newpassword);

	}

	public void submit() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submit);

	}

	public void getcustomerid() throws Exception {
		String actual = getcustomerid.getText();
		ExcelWrite eat = new ExcelWrite(
				"D://testing//Webdemo//src//testData//Javascript.xlsx");

		eat.setCellData("Sheet1", "customerid", 2, actual);

	}

}
