package screendemopage;

import static org.testng.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import screendemopage.*;

public class GooglePage {
	WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;

	@FindBy(xpath = "(//*[@href='https://www.google.co.in/intl/en/about/products?tab=wh'])[1] ")
	WebElement googleApps;

	@FindBy(xpath = "//*[contains(text(),'Maps')]")
	WebElement Maps;

	@FindBy(xpath = "//input[@id='searchboxinput']")
	WebElement searchbox;

	@FindBy(xpath = "//*[contains(text(),'Plot')]")
	WebElement address;

	@FindBy(xpath = "//*[@aria-label='Write a review']")
	WebElement review;

	@FindBy(xpath = "//*[contains(text(),'Sign In')]")
	WebElement signin;

	@FindBy(xpath = "//*[@id='identifierId']")
	WebElement email;

	@FindBy(xpath = "//*[@id='identifierNext']/content")
	WebElement next_id;

	@FindBy(xpath = "(//*[@class='Xb9hP'])[1]")
	WebElement password;

	@FindBy(xpath = "//*[@id='passwordNext']/content")
	WebElement nextpassword;

	@FindBy(xpath = "//*[@aria-label='Five stars']")
	WebElement star;

	@FindBy(xpath = "//*[@class='review-text']")
	WebElement comment;

	@FindBy(xpath = "(//*[contains(text(),'Post')])[2]")
	WebElement post;

	@FindBy(xpath = "//*[contains(text(),'DONE')]")
	WebElement done;

	@FindBy(xpath = "//*[contains(text(),'Ayushi Agrawal')]")
	WebElement ayushi;

	@FindBy(xpath = "(//*[contains(text(),'My workplace')])[2]")
	WebElement validate;

	public GooglePage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void googleApps() {
		googleApps.click();
	}

	public void Maps() {
		Maps.click();

	}

	public void star() {
		star.click();

	}

	public void post() {
		post.click();

	}

	public void ayushi() {
		ayushi.click();

	}

	public void done() {
		done.click();

	}

	public void Searchbox(String search) {
		searchbox.sendKeys(search);

	}

	public void comment(String Comment) {
		comment.sendKeys(Comment);

	}

	public void address(String Address) throws InterruptedException {
		try {
			String Expected = address.getText();
			System.out.println(Expected);
			int a = 1/0;
			if (Expected.contains(Address)) {
				test.log(LogStatus.PASS, "PassStep1", "Address is validated Successfully");
				Thread.sleep(7000);
			} else {
				test.log(LogStatus.FAIL, "PassStep1", "Address is not validated Successfully");
			}
			System.out.println("Address is:" + Expected);
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String errorString = sw.toString();
			test.log(LogStatus.FAIL, "PassStep1", "<p id=\"demo\" hidden>"+errorString+"</p>\n" + 
					"<button onclick=\"alert(document.getElementById('demo').innerText)\">Click me</button>");
		}
	}

	public void review() {
		review.click();
	}

	public void signin() {
		signin.click();
	}

	public void next_id() {
		next_id.click();
	}

	public void nextpassword() {
		nextpassword.click();
	}

	public void email(String Email) {
		email.sendKeys(Email);

	}

	public void password(String Password) {
		password.sendKeys(Password);

	}

	public void Validate(String Comment) {
		String Expected = Comment;
		String actual = validate.getText();
		assertEquals(Expected, actual);
		System.out.println("Validate comment is:" + actual);
		test.log(LogStatus.PASS, "PassStep1", "Comment is validated");
	}

}