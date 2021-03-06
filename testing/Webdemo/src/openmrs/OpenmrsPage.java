package openmrs;



import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utility.ExcelWrite;

public class OpenmrsPage {
	WebDriver driver;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(id = "username")
	WebElement Username;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "Inpatient Ward")
	WebElement Location;


	  @FindBy(id="loginButton")
	  WebElement loginbutton;


	@FindBy(id= "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
	WebElement RegisterPatient;


	@FindBy(name = "givenName")
	WebElement GivenName;

	@FindBy(name = "familyName")
	WebElement FamilyName;

	@FindBy(id = "genderLabel")
	WebElement Gender_slectn;

	@FindBy(id = "gender-field")
	WebElement Gender;

	@FindBy(id = "birthdateLabel")
	WebElement BirthdaySlctn;

	@FindBy(id = "birthdateDay-field")
	WebElement Brthday_date;

	@FindBy(id = "birthdateMonth-field")
	WebElement Brthday_Month;

	@FindBy(id = "birthdateYear-field")
	WebElement Brthday_year;

	@FindBy(xpath = "//span[text()='Address']")
	WebElement Address_slctn;

	@FindBy(id = "address1")
	WebElement Address1;

	@FindBy(id = "address2")
	WebElement Address2;

	@FindBy(id = "cityVillage")
	WebElement City;

	@FindBy(id = "stateProvince")
	WebElement State;

	@FindBy(id = "country")
	WebElement Country;

	@FindBy(id = "postalCode")
	WebElement Postal_code;


	@FindBy(xpath = "//span[text()='Phone Number']")
	WebElement Phone_slctn;

	@FindBy(name = "phoneNumber")
	WebElement PhoneNumber;

	@FindBy(xpath = "//span[text()='Relatives']")
	WebElement Relative_Slctn;

	@FindBy(id = "relationship_type")
	WebElement Rltnshp_Type;

	@FindBy(xpath = "(//input[@type='text'])[15]")
	WebElement Person_Name;

	@FindBy(id = "confirmation_label")
	WebElement Confirm_Btn;

	@FindBy(xpath = "//*[@id='null']/div/div/p[3]/a[1]/i")
	WebElement Plus_btn;
	
	@FindBy(id = "submit")
	WebElement confirm;


	public OpenmrsPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void Username(String login) {
		Username.sendKeys(login);

	}

	public void Location() {
		Location.click();

	}

	public void Plus_btn() {
		Plus_btn.click();

	}

	public void Relative_Slctn() {
		Relative_Slctn.click();

	}

	public void Password(String login) {
		Password.sendKeys(login);

	}
	public void RegisterPatient() {
		RegisterPatient.click();

	}
	public void Phone_slctn() {
		Phone_slctn.click();

	}
	public void loginbutton() {
		loginbutton.click();
	}

	public void GivenName(String name) {
		GivenName.sendKeys(name);

	}
	public void Gender(String gender) {
		 Select gender1 = new Select((WebElement) Gender);
		 gender1.selectByVisibleText(gender);


	}

	public void FamilyName(String name) {
		FamilyName.sendKeys(name);

	}

	public void Gender_slectn() {
		Gender_slectn.click();

	}

	public void Confirm_Btn() {
		Confirm_Btn.click();

	}
	public void BirthdaySlctn() {
		BirthdaySlctn.click();

	}

	public void Brthday_date(String dob) {
		Brthday_date.sendKeys(dob);

	}
	public void Brthday_Month(String dob) {
		Select month = new Select((WebElement) Brthday_Month);
		month.selectByVisibleText(dob);

	}
	public void Brthday_year(String dob) {
		Brthday_year.sendKeys(dob);

	}

	public void Address_slctn() {
		Address_slctn.click();

	}

	public void Address1(String address) {
		Address1.sendKeys(address);

	}

	public void Address2(String address) {
		Address2.sendKeys(address);

	}
	public void City(String address) {
		City.sendKeys(address);

	}

	public void State(String address) {
		State.sendKeys(address);

	}
	public void Country(String address) {
		Country.sendKeys(address);

	}
	public void Postal_code(String address) {
		Postal_code.sendKeys(address);

	}
	public void PhoneNumber(String address) {
		PhoneNumber.sendKeys(address);

	}
	public void Rltnshp_Type(String relative, String name, int i, int j) throws InterruptedException {

			  driver.findElement(By.xpath("(//*[@id='relationship_type'])["+i+"]")).sendKeys(relative);
			  Thread.sleep(1000);
			  driver.findElement(By.xpath("(//*[@type='text'])["+j+"]")).sendKeys(name);

	}

	public void Person_Name(String relative) {
		Person_Name.sendKeys(relative);

	}
	
	public void confirm() {
		confirm.click();

	}

}

