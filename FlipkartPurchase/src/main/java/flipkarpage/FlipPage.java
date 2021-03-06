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


	@FindBy(xpath = "//img[@title='Flipkart']")
	WebElement homepage;

	/*
	 * @FindBy(xpath = "//*[@href='/account/login?ret=/']") WebElement login;
	 */

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement entermobile;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement clicklogin;
	
	@FindBy(xpath = "//*[contains(text(),'CONTINUE')]")
	WebElement continu;
	
	@FindBy(xpath = "//*[contains(text(),'Login with Password')]")
	WebElement logpasw;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement searchbaricon;
	
	@FindBy(xpath = "//*[@class='LM6RPg']")
	WebElement searching;
	
	@FindBy(xpath = "//*[contains(text(),'Price -- Low to High')]")
	WebElement sort;
	
	@FindBy(xpath = "//*[@data-id='MOBEBY3WJBHTTFHU']")
	WebElement selectdevice;
	
	@FindBy(xpath = "//*[@class='_1vC4OE _3qQ9m1']")
	WebElement pricefetch;
	
	@FindBy(xpath = "//*[@type='button']")
	WebElement buynow;
	
	@FindBy(xpath = "//*[contains(text(),'Order Summary')]")
	WebElement delieverypage;
	
	@FindBy(xpath = "//*[contains(text(),'CONTINUE')]")
	WebElement continupayment;
	
	@FindBy(xpath = "//*[contains(text(),'Credit / Debit / ATM Card')]")
	WebElement paymentpage;
	
	@FindBy(xpath = "(//*[@class='_6ATDKp'])[4]")
	WebElement netbanking;
	
	@FindBy(xpath = "//*[contains(text(),'HDFC Bank')]")
	WebElement hdfcbank;
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement paynow;
	
	@FindBy(xpath = "//*[@name='fldLoginUserId']")
	WebElement customerid;
	
	@FindBy(xpath = "//*[@alt='continue']")
	WebElement nextcontinue;
	
	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement customerpswd;
	
	@FindBy(xpath = "//img[@src='/gif/login.gif']")
	WebElement login;
	
	@FindBy(xpath = "//tr[4]//td[2]//span")
	WebElement errormessage;
	
	@FindBy(xpath = "(//*[@class='_3wU53n'])[1]")
	WebElement deviceveri;
	
	

	public FlipPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	/*
	 * public void login() { login.click();
	 * 
	 * }
	 */

	public void entermobile(String Userid) {
		entermobile.sendKeys(Userid);

	}

	public void password(String Userid) {
		password.sendKeys(Userid);

	}

	public void clicklogin() {
		clicklogin.click();

	}
	
	public void continu() {
		continu.click();

	}
	public void logpasw() {
		logpasw.click();

	}

	
	public void searchbaricon() {
		if (searchbaricon.isDisplayed()) {
			test.log(LogStatus.PASS, "PassStep2", "Search Bar loaded Successfully");
		} else {
			test.log(LogStatus.FAIL, "PassStep2", "Search Bar is not loaded");
		}

	}
	
	public void searching(String devicename) {
		searching.sendKeys(devicename);

	}
	
	public void searchbarclick() {
		searchbaricon.click();
	}
	
	public void sort(String searchcontent) {
		String uname=deviceveri.getText();
		System.out.println(uname);
		if (searchcontent.contains(uname)) {
			FlipPage.test.log(LogStatus.PASS, "PassStep3", "Expected product is loaded Successfully");
		} else {
			FlipPage.test.log(LogStatus.FAIL, "PassStep3", "Expected product is not loaded Successfully");
		}
		sort.click();

	}
	
	public void selectdevice() {
		selectdevice.click();

	}
	
	public void pricefetch() {
		String price=pricefetch.getText();
		String price1=price.substring(1);
		test.log(LogStatus.PASS, "PassStep4", price1);
	}
	
	public void buynow() {
		buynow.click();

	}
	
	public void delieverypage() {
		if (delieverypage.isDisplayed()) {
			test.log(LogStatus.PASS, "PassStep5", "Delievery Page is loaded Successfully");
		} else {
			test.log(LogStatus.FAIL, "PassStep5", "Delievery Page is not loaded");
		}

	}
	
	public void continupayment() {
		continupayment.click();

	}
	
	public void paymentpage() {
		if (paymentpage.isDisplayed()) {
			test.log(LogStatus.PASS, "PassStep6", "Payment Page is loaded Successfully");
		} else {
			test.log(LogStatus.FAIL, "PassStep6", "Payment Page is not loaded");
		}

	}
	
	public void netbanking() {
		netbanking.click();

	}
	
	public void hdfcbank() {
		hdfcbank.click();

	}
	
	public void paynow() {
		paynow.click();

	}
	
	public void customerid(String customer) {
		customerid.sendKeys(customer);

	}
	
	public void nextcontinue() {
		nextcontinue.click();

	}
	
	public void errormessage() {
		String text=errormessage.getText();
		test.log(LogStatus.INFO, "PassStep6", text);
	}
	
	public void customerpswd(String pswd) {
		customerpswd.sendKeys(pswd);

	}
	
	public void login() {
		login.click();

	}

	


}
