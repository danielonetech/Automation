package Gmailtest.emailSent;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.*;
import page.EmailPage;

public class email {
	WebDriver driver;
	EmailPage obj;

	@Given("Login page is opened for Gmail")
	public void gmail_login_page_is_opened() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "D:\\Automation1\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(
				"https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	}

	@When("Enter email as {string}")
	public void i_enter_email_as(String string) {
		// Write code here that turns the phrase above into concrete actions
		obj = new EmailPage(driver);
		obj.enteremail(string);
	}

	@When("Click on Next button")
	public void i_click_on_Next_button() {
		// Write code here that turns the phrase above into concrete actions
		obj.nextemail();
	}

	@Then("Password Screen should open")
	public void password_Screen_should_open() {
		// Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")));
	}

	@When("Enter password as {string}")
	public void enter_password_as(String string) {
		// Write code here that turns the phrase above into concrete actions
		obj.enterpassword(string);
	}

	// input[@type=\"password\"]|(//*[@jsname=\"YRMmle\"])[1]|//div[@id=\"password\"]
	@When("Click on Next Pwd_button")
	public void click_on_Next_button() {
		// Write code here that turns the phrase above into concrete actions
		obj.nextpassword();
	}

	@Then("Gmail Inbox should open and Compose button should be present")
	public void gmail_Inbox_should_open() {
		// Write code here that turns the phrase above into concrete actions
		obj.checkCompose();
	}

	@When("Click on compose button")
	public void click_on_compose_button() {
		// Write code here that turns the phrase above into concrete actions
		obj.clickCompose();
	}

	@When("Enter recipients name as {string}")
	public void enter_recipients_name_as(String string) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		obj.recipient(string);
	}

	@When("Enter Subject as {string}")
	public void enter_Subject_as(String a) {
		// Write code here that turns the phrase above into concrete actions
		obj.subject(a);
	}

	@When("Enter Message Body as {string}")
	public void enter_Message_Body_as(String a) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		obj.message(a);
	}

	@When("Attach attachment")
	public void attach_attachment() throws IOException, InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		obj.attachment();
	}

	@When("Click Send button")
	public void click_Send_button() {
		// Write code here that turns the phrase above into concrete actions
		obj.sendEmail();
	}

	@Then("Email should be sent out.")
	public void email_should_be_sent_out() {
		// Write code here that turns the phrase above into concrete actions
		obj.checkEmail();
	}
}
