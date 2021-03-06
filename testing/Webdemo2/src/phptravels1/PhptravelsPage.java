package phptravels1;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.ExcelWrite;

public class PhptravelsPage {
	WebDriver driver;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "(//li[@id='li_myaccount'])[2]/a")
	WebElement MyAccount;

	@FindBy(xpath = "(//*[contains(text(),' Login')])[2]")
	WebElement login;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	WebElement email;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Login')]")
	WebElement LoginButton;


	  @FindBy(xpath="//*[@href='https://www.phptravels.net/invoice?id=1555&sessid=2341']")
	  WebElement Invoice1;
	 

	@FindBy(xpath = "//a[@href='https://www.phptravels.net/invoice?id=1554&sessid=9830']")
	WebElement Invoice2;
	

	@FindBy(xpath = "//*[contains(text(),'USD $55')]")
	WebElement value1;

	@FindBy(xpath = "//*[contains(text(),'USD $165')]")
	WebElement value2;

	public PhptravelsPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}
	
	public PhptravelsPage() {
	}

	public void MyAccount() {
		MyAccount.click();

	}

	public void login() {
		login.click();

	}

	public void email(String Email) {
		email.sendKeys(Email);

	}

	public void password(String Password) {
		password.sendKeys(Password);

	}

	public void loginButton() {
		LoginButton.click();

	}

	public void invoice1(String bookingid, String hotelname) {
		String tagName = driver.findElement(By.xpath("(//*[text()='"+hotelname+"'])[1]")).getText();
		String id = driver.findElement(By.xpath("//*[text()=' "+bookingid+"']")).getText();
		/*System.out.println(tagName);
		System.out.println(id);
		System.out.println(hotelname);
		System.out.println(bookingid);*/
		if(tagName.contains(hotelname))
		 {
			//System.out.println("True");
			 if(id.contains(bookingid)) 
			 {
				 //System.out.println("False");
		 
		//System.out.println(bookingid);
		this.Invoice1.click();
		//driver.findElement(
				//By.xpath("//*[@href='https://www.phptravels.net/invoice?id=1555&sessid=2341' and //*[contains(text(),'Hurghada')]]")).click();
		 }
		 }

	}

	public void invoice2(String bookingid, String hotelname) {
		/*driver.findElement(
				By.xpath("//*[@href='https://www.phptravels.net/invoice?id=1554&sessid=9830' and //*[contains(text(),'Hurghada')]]")).click();
*/
		String tagName = driver.findElement(By.xpath("(//*[text()='"+hotelname+"'])[2]")).getText();
		String id = driver.findElement(By.xpath("//*[text()=' "+bookingid+"']")).getText();
		if(tagName.contains(hotelname))
		 {
			 if(id.contains(bookingid)) 
			 {
		 
		//System.out.println(bookingid);
		this.Invoice2.click();
		//driver.findElement(
				//By.xpath("//*[@href='https://www.phptravels.net/invoice?id=1555&sessid=2341' and //*[contains(text(),'Hurghada')]]")).click();
		 }
		 }
	}

	public void switchhandler() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

	}

	public void value1(String expected) throws Exception {
		String actual = value1.getText();
		System.out.println(expected);
		System.out.println(actual);
		ExcelWrite eat = new ExcelWrite(
				"D://testing//Webdemo//src//testData//Phptravels1.xlsx");
		if (actual.contains(expected)) {
			eat.setCellData("Sheet1", "result", 2, "PASS");
			System.out.println("Value is validated Successfully. Value is "
					+ expected);

		} else {
			eat.setCellData("Sheet1", "result", 2, "FAIL");
			System.out.println("Test1 Failed");

		}
	}

	public void value2(String expected) throws Exception {
		String actual = value2.getText();
		System.out.println(expected);
		System.out.println(actual);
		ExcelWrite eat = new ExcelWrite(
				"D://testing//Webdemo//src//testData//Phptravels1.xlsx");
		if (actual.contains(expected)) {

			eat.setCellData("Sheet1", "result", 3, "PASS");
			System.out.println("Value is validated Successfully. Value is "
					+ expected);

		} else {
			eat.setCellData("Sheet1", "result", 3, "FAIL");
			System.out.println("Test1 Failed");

		}

	}

}
