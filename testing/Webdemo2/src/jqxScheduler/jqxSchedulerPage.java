package jqxScheduler;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class jqxSchedulerPage {
	WebDriver driver;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "(//a[@href='/jquery-widgets-demo'])[1]")
	WebElement demo;

	@FindBy(xpath = "//*[contains(text(),'jqxScheduler')]")
	WebElement jqxScheduler;

	@FindBy(xpath = "//a[@href='scheduler-recurring-appointment.htm']")
	WebElement recurring;

	@FindBy(xpath = "//*[@data-role='input' and @role='textbox']")
	WebElement calendar;

	@FindBy(xpath = "//*[contains(text(),'15') and @id]")
	WebElement date;
	
	@FindBy(xpath = "(//*[@data-date='2019-04-15 12:00:00'])[1]")
	WebElement appointment;
	
	@FindBy(xpath = "//*[@id='createAppointment']")
	WebElement clickappointment;
	
	@FindBy(xpath = "(//input[@type='text' and @role='textbox'])[1]")
	WebElement subject;
	
	@FindBy(xpath = "(//*[@style='height: 100%; width: 22px; left: 357px;'])[2]")
	WebElement time;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td[1]/input")
	WebElement time1;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td[3]/input")
	WebElement time2;
	
	@FindBy(xpath = "//table/tbody/tr[2]/td[9]/input")
	WebElement time3;
	
	@FindBy(xpath = "(//*[@unselectable='on' and @style='background-color: transparent; border: none; float: right; position: relative; width: 4.49735%; height: 23px;'])[1]")
	WebElement timezonedropdown;
	
	@FindBy(xpath = "//*[@style='box-sizing: content-box; left: 0px; top: 185px; position: absolute; width: 13px; height: 13px;']")
	WebElement arrow;
	
	//@FindBy(xpath = "//*[contains(text(),'(UTC+05:30) Chennai, Kolkata, Mumbai, New Delhi') and @style]")
	//WebElement selecttimezonedropdown;
	
	@FindBy(xpath = "(//*[@style='overflow: hidden; outline: none; background-color: transparent; border: none; float: left; width:100%; height: 100%; position: relative;'])[2]")
	WebElement repeatdropdown;
	
	@FindBy(xpath = "//span[text()='Daily']")
	WebElement selectrepeatdaily;
	
	@FindBy(xpath = "(//*[@style='width: 16px; height: 16px;'])[6]")
	WebElement onradio;
	
	@FindBy(xpath = "(//input[@type='textarea'])[5]")
	WebElement endondate;
	
	@FindBy(xpath = "(//*[@style='overflow: hidden; outline: none; background-color: transparent; border: none; float: left; width:100%; height: 100%; position: relative;'])[3]")
	WebElement colordrop;
	
	//@FindBy(xpath = "(//*[@style='overflow: hidden; outline: none; background-color: transparent; border: none; float: left; width:100%; height: 100%; position: relative;'])[3]")
	//WebElement selectcolordrop;
	
	@FindBy(xpath = "//button[text()='Save' and @role='button']")
	WebElement save;
	
	@FindBy(xpath = "//*[@data-type='monthView']")
	WebElement month;
	
	//@FindBy(xpath = "//*[@title='12 PM - 01:00 Daily Status Update']")
	//WebElement createdappointment;
	
	@FindBy(xpath = "//*[@id='editAppointment']")
	WebElement editappointment;
	
	@FindBy(xpath = "//button[@title='Edit Occurrence']")
	WebElement editoccurrence;
	
	@FindBy(xpath = "//*[@role='button' and text()='Delete']")
	WebElement delete;
	

	public jqxSchedulerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void demo() {
		demo.click();

	}

	public void jqxScheduler() {
		jqxScheduler.click();

	}

	public void recurring() {
		recurring.click();

	}

	public void calendar() {
		calendar.click();

	}

	public void date(String date) {
		WebElement TxtBoxContent = driver.findElement(By.xpath("//*[contains(text(),'"+date+"') and @id]"));
		TxtBoxContent.click();

	}
	
	public void appointment(String appointmenttime) {
			WebElement TxtBoxContent = driver.findElement(By.xpath("(//*[@data-date='2019-04-15 "+appointmenttime+":00:00'])[1]"));
			Actions action = new Actions(driver);
			action.contextClick(TxtBoxContent).build().perform();

	}

	public void clickappointment() {
		clickappointment.click();

	}

	public void subject(String sub) {
		subject.sendKeys(sub);

	}

	public void time() {
		time.click();

	}

	public void time1(String time) {
		time1.sendKeys(time);

	}
	
	public void time2() {
		time2.clear();

	}

	public void time3() {
		time3.click();

	}

	public void timezonedropdown() {
		timezonedropdown.click();

	}
	
	public void selecttimezonedropdown(String timezone) {
		WebElement TxtBoxContent = null;
		for(int i=1;i<191;i++)
		{
				arrow.click();
			
		}
		for(int i=1;i<200;i++)
		{
			try
			{
				TxtBoxContent = driver.findElement(By.xpath("//*[contains(text(),'"+timezone+"') and @style]"));
				break;
			}catch(org.openqa.selenium.ElementNotVisibleException e)
			{
				arrow.click();
			}
			catch(org.openqa.selenium.NoSuchElementException e)
			{
				arrow.click();
			}
		}
		
		TxtBoxContent.click();

	}

	public void repeatdropdown() {
		repeatdropdown.click();

	}
	
	public void selectrepeatdaily() {
		selectrepeatdaily.click();

	}

	public void onradio() {
		onradio.click();

	}
	
	public void endondate(String repeatendson) {
		endondate.sendKeys(repeatendson);

	}

	public void colordrop() {
		colordrop.click();

	}
	
	public void selectcolordrop(String color) {
		WebElement TxtBoxContent = driver.findElement(By.xpath("//*[@style='margin-top: 1px; float: left; border-radius: 3px; width: 96%; height: 20px; border: none; background:"+color+"; margin-left: 2%;']"));
		TxtBoxContent.click();

	}

	public void save() {
		save.click();

	}

	public void month() {
		month.click();

	}

	public void createdappointment(String time, String subject) {
		WebElement TxtBoxContent = driver.findElement(By.xpath("//*[@title='12 PM - "+time+":00 "+subject+"']"));
		Actions action = new Actions(driver);
		action.contextClick(TxtBoxContent).build().perform();

	}
	
	public void editappointment() {
		editappointment.click();

	}
	
	public void editoccurrence() {
		editoccurrence.click();

	}
	
	public void delete() {
		delete.click();

	}

}
