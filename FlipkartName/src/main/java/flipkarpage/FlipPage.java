package flipkarpage;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FlipPage {
	public static ExtentTest test;
	public static ExtentReports report;
	WebDriver driver;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "//*[@class='_2AkmmA _29YdH8']")
	WebElement cross;

	@FindBy(xpath = "//img[@title='Flipkart']")
	WebElement homepage;

	@FindBy(xpath = "//*[@href='/account/login?ret=/']")
	WebElement login;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement entermobile;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement clicklogin;

	@FindBy(xpath = "(//*[@class='_2aUbKa'])[1]")
	WebElement username;

	@FindBy(xpath = "//*[contains(text(),'My Profile')]")
	WebElement myprofile;

	@FindBy(xpath = "(//*[contains(text(),'Edit')])[1]")
	WebElement edit;

	@FindBy(xpath = "//*[@name='lastName']")
	WebElement name;
	
	@FindBy(xpath = "//*[@class='CS1pHo']")
	WebElement namepick;

	@FindBy(xpath = "(//*[@type='submit'])[2]")
	WebElement save;

	@FindBy(xpath = "//*[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath = "//*[contains(text(),'CONTINUE')]")
	WebElement continu;
	
	@FindBy(xpath = "//*[contains(text(),'Login with Password')]")
	WebElement logpasw;

	public FlipPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	public void continu() {
		continu.click();

	}
	public void logpasw() {
		logpasw.click();

	}

	public void cross() {
		cross.click();

	}

	public void homepage() {
		String hname = homepage.getText();
		System.out.println(hname);
		if (hname.contains("fasd")) {
			test.log(LogStatus.PASS, "PassStep1", "Home Page loaded Successfully");
		} else {
			test.log(LogStatus.FAIL, "PassStep1", "Home Page is not loaded");
		}

	}

	public void login() {
		login.click();

	}

	public void entermobile(String Userid) {
		entermobile.sendKeys(Userid);

	}

	public void password(String Userid) {
		password.sendKeys(Userid);

	}

	public void clicklogin() {
		clicklogin.click();

	}

	public void username(String Userid) {
		String uname=username.getText();
		System.out.println(uname);
		if (uname.contains(Userid)) {
			test.log(LogStatus.PASS, "PassStep2", "User Name is correct");
		} else {
			test.log(LogStatus.FAIL, "PassStep2", "User Name is not correct");
		}
		username.click();
		username.click();

	}

	public void myprofile() {
		myprofile.click();

	}

	public void edit() {
		edit.click();

	}

	public void name(String lastname) {
		name.clear();
		name.sendKeys(lastname);

	}

	public void save() {
		save.click();

	}
	
	public void namevrify(String lastname) {
		String lname=namepick.getText();
		System.out.println("haha "+lname);
		if (lname.contains(lastname)) {
			test.log(LogStatus.PASS, "PassStep3", "User Name updated correctly");
		} else {
			test.log(LogStatus.FAIL, "PassStep3", "User Name is not updated correctly");
		}
	}

	public void logout() {
		logout.click();

	}
}
