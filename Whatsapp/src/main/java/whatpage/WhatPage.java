package whatpage;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WhatPage {
	public static ExtentTest test;
	public static ExtentReports report;
	WebDriver driver;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "//*[@contenteditable='true']")
	WebElement search;

	@FindBy(xpath = "//*[@title='Himanshu Roommate Tcs']")
	WebElement himanshuclick;
	
	@FindBy(xpath = "//*[@title='Akshay Roommate Tcs']")
	WebElement akshayclick;
	
	@FindBy(xpath = "//*[@title='Shivam Roommate Tcs']")
	WebElement shivamclick;
	
	@FindBy(xpath = "(//*[@title='Ayushi Lucky'])[2]")
	WebElement ayushiclick;

	@FindBy(xpath = "(//*[@contenteditable='true'])[2]")
	WebElement entermessage;

	@FindBy(xpath = "//*[@class='_3M-N-']")
	WebElement send;

	

	public WhatPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void searchhimanshu() {
		search.sendKeys("himanshu roommate tcs");
		test.log(LogStatus.PASS, "Searching",  " Search successfully");
	}

	public void himanshuclick() {
		himanshuclick.click();
		test.log(LogStatus.PASS, "Clicking on Search Result", "Search result clicked successfully");
	}
	
	public void searchakshay() {
		search.sendKeys("akshay roommate tcs");
		test.log(LogStatus.PASS, "Searching",  " Search successfully");
	}

	public void akshayclick() {
		akshayclick.click();
		test.log(LogStatus.PASS, "Clicking on Search Result", "Search result clicked successfully");
	}
	
	public void searchshivam() {
		search.sendKeys("shivam roommate tcs");
		test.log(LogStatus.PASS, "Searching",  " Search successfully");
	}

	public void shivamclick() {
		shivamclick.click();
		test.log(LogStatus.PASS, "Clicking on Search Result", "Search result clicked successfully");
	}
	
	public void searchayushi() {
		search.sendKeys("ayushi lucky");
		test.log(LogStatus.PASS, "Searching",  " Search successfully");
	}

	public void ayushiclick() {
		ayushiclick.click();
		test.log(LogStatus.PASS, "Clicking on Search Result", "Search result clicked successfully");
	}
	public void entermessage(int i) {
		entermessage.sendKeys("I love you baby "+i+"th time.We will live toghether till "+i+"th time");
		test.log(LogStatus.PASS, "Enter Message", " Message entered successfully");
		i++;
	}


	public void send() {
		entermessage.sendKeys(Keys.ENTER);
		test.log(LogStatus.PASS, "Send Message",  " Message send successfully");

	}

	

}
