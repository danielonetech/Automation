package page;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailPage {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(xpath = "//input[@type=\"email\"]")
	WebElement enteremail;

	@FindBy(xpath = "//*[@id=\"next\"]|//*[@id=\"identifierNext\"]")
	WebElement nextemail;

	@FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
	WebElement enterpassword;
	
	@FindBy(xpath = "//*[@id=\"passwordNext\"]|//*[@id=\"submit\"]")
	WebElement nextpassword;
	
	@FindBy(xpath = "//*[text()='Compose']")
	WebElement compose;
	
	@FindBy(xpath = "//*[@name=\"to\"]")
	WebElement recipient;
	
	@FindBy(xpath = "//*[@name=\"subjectbox\"]")
	WebElement subject;
	
	@FindBy(xpath = "//*[@role=\"textbox\"]")
	WebElement message;
	
	@FindBy(xpath = "//*[@command=\"Files\"]")
	WebElement attachment;
	
	@FindBy(xpath = "//*[text()='Send']")
	WebElement sendEmail;
	
	public EmailPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void enteremail(String b) {
		enteremail.sendKeys(b);
	}

	public void nextemail() {
		nextemail.click();
	}
	
	public void enterpassword(String b) {
		enterpassword.sendKeys(b);
	}
	
	public void nextpassword() {
		nextpassword.click();
		System.out.println("Logged in");
	}
	
	public void checkCompose() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Compose']")));
		System.out.println("Gmail is open");
	}
	
	public void clickCompose() {
		compose.click();
		System.out.println("Email window is open for sending message");
	}
	
	public void recipient(String a) throws InterruptedException {
		Thread.sleep(10000);
		recipient.sendKeys(a);
		System.out.println(a);
	}
	
	public void subject(String a){
		subject.sendKeys(a);
	}
	
	public void message(String a) throws InterruptedException{
		message.sendKeys(a);
	}
	
	public void attachment() throws InterruptedException, IOException {
		attachment.click();
		Thread.sleep(10000);
		Runtime.getRuntime().exec("D:\\Automation\\EmailSent\\src\\main\\java\\AttachmentScript\\Attachment.exe");
	}
	
	public void sendEmail() {
		sendEmail.click();
	}
	
	public void checkEmail() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Message sent.']")));
		System.out.println("Email sent Successfully");
	}
}
