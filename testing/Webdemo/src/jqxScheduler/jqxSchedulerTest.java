package jqxScheduler;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.ExcelWrite;

public class jqxSchedulerTest {
	WebDriver driver;
	jqxSchedulerPage objgo;
	private String color;
	private String repeatendson;
	private String timezone;
	private String repeat;
	private String subject;
	private String time;
	private String appointmenttime;
	private String date;

	public jqxSchedulerTest(String testCase, String date,
			String appointmenttime, String subject, String time,
			String timezone, String repeat, String repeatendson, String color) {
		this.date = date;
		this.appointmenttime = appointmenttime;
		this.subject = subject;
		this.time = time;
		this.timezone = timezone;
		this.repeat = repeat;
		this.repeatendson = repeatendson;
		this.color = color;
	}

	@BeforeClass
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.jqwidgets.com/");
		Thread.sleep(10000);
	}

	@Test
	public void Google() throws Exception {

		jqxSchedulerPage objgo = new jqxSchedulerPage(driver);
		Thread.sleep(1000);
		objgo.demo();
		Thread.sleep(4000);
		objgo.jqxScheduler();
		Thread.sleep(4000);
		objgo.recurring();
		Thread.sleep(1000);
		driver.switchTo().frame("jqxInnerdemoContainer");
		objgo.calendar();
		Thread.sleep(4000);
		objgo.date(date);
		Thread.sleep(4000);
		objgo.appointment(appointmenttime);
		Thread.sleep(1000);
		objgo.clickappointment();
		Thread.sleep(1000);
		objgo.subject(subject);
		Thread.sleep(1000);
		objgo.time();
		Thread.sleep(1000);
		objgo.time1(time);
		Thread.sleep(1000);
		objgo.time2();
		Thread.sleep(1000);
		objgo.time();
		Thread.sleep(1000);
		objgo.timezonedropdown();
		Thread.sleep(1000);
		objgo.selecttimezonedropdown(timezone);
		Thread.sleep(1000);
		objgo.repeatdropdown();
		Thread.sleep(1000);
		objgo.selectrepeatdaily();
		Thread.sleep(1000);
		objgo.onradio();
		Thread.sleep(1000);
		objgo.endondate(repeatendson);
		Thread.sleep(1000);
		objgo.colordrop();
		Thread.sleep(1000);
		objgo.selectcolordrop(color);
		Thread.sleep(1000);
		objgo.save();
		Thread.sleep(1000);
		objgo.month();
		Thread.sleep(1000);
		objgo.createdappointment(time,subject);
		Thread.sleep(1000);
		objgo.editappointment();
		Thread.sleep(1000);
		objgo.editoccurrence();
		Thread.sleep(1000);
		objgo.delete();
	}

	/*
	 * @AfterClass public void afterMethod() { driver.quit(); }
	 */

}
