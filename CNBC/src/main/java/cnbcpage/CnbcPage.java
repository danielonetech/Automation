package cnbcpage;

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

public class CnbcPage {
	public static ExtentTest test;
	public static ExtentReports report;
	WebDriver driver;

	public HSSFCell cell = null;
	public HSSFWorkbook workbook = null;

	@FindBy(xpath = "(//img[@alt='logo'])[1]")
	WebElement homepage;

	@FindBy(xpath = "//*[@href='https://www.cnbc.com/top-video/']")
	WebElement topvideo;

	@FindBy(xpath = "(//*[@class='headline'])[1]")
	WebElement getvideotitle;

	@FindBy(xpath = "//*[@id='video-title']")
	WebElement videotitle;

	@FindBy(xpath = "//*[@class='ClipPlayer-clipPlayerIntroTitle']")
	WebElement videotitle1;

	@FindBy(xpath = "//*[@class='cnbcIconPause']")
	WebElement pause;

	@FindBy(xpath = "(//*[@aria-label='Pause'])[2]")
	WebElement pause1;

	@FindBy(xpath = "//video[@src]")
	WebElement videoloadtime;

	@FindBy(xpath = "//*[@id='social_tools_video-reaction5-icon']")
	WebElement share;

	@FindBy(xpath = "//*[@id='social-buttons-reaction4']")
	WebElement share1;

	@FindBy(xpath = "(//*[@class='gig-simpleShareUI-button'])[1]")
	WebElement shareicon;

	@FindBy(xpath = "//*[@class='gig-simpleShareUI-closeButton']")
	WebElement close;

	public CnbcPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);

	}

	public void homepage() {
		if (homepage.isDisplayed()) {
			test.log(LogStatus.PASS, "PassStep1", "Home Page loaded Successfully");
		} else {
			test.log(LogStatus.FAIL, "PassStep1", "Home Page is not loaded");
		}
	}

	public void topvideo() {
		topvideo.click();

	}
	
	String hname;
	public void getvideotitlepre() throws InterruptedException {
		hname = getvideotitle.getText();
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		long start = System.currentTimeMillis();
		getvideotitle.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//video[@src]")));
		long finish = System.currentTimeMillis();
		long totalTime = finish - start;
		test.log(LogStatus.PASS, "PassStep2", "Total Time for Video load - " + totalTime + "");
		// System.out.println("Total Time for Video load - "+totalTime);
		Thread.sleep(15000);
	}

	public void getvideotitlepost() throws InterruptedException {
		String hname1 = videotitle.getText();
		StringBuilder builder = new StringBuilder(hname1);
		builder.deleteCharAt(hname1.length() - 1);
		builder.deleteCharAt(hname1.length() - 2);
		builder.deleteCharAt(hname1.length() - 3);
		System.out.println(hname + " " + builder.toString());
		if (hname.contains(builder.toString())) {
			test.log(LogStatus.PASS, "PassStep3", "Video Content is matched");
		} else {
			test.log(LogStatus.FAIL, "PassStep3", "Video Content is not matched");
		}
	}

	public void getvideotitlepost1() throws InterruptedException {
		String hname1 = videotitle1.getText();
		StringBuilder builder = new StringBuilder(hname1);
		builder.deleteCharAt(hname1.length() - 1);
		builder.deleteCharAt(hname1.length() - 2);
		builder.deleteCharAt(hname1.length() - 3);
		System.out.println(hname + " " + builder.toString());
		if (hname.contains(builder.toString())) {
			test.log(LogStatus.PASS, "PassStep3", "Video Content is matched");
		} else {
			test.log(LogStatus.FAIL, "PassStep3", "Video Content is not matched");
		}
	}

	public void pause() {
		pause.click();

	}

	public void pause1() {
		pause1.click();

	}

	public void share() {
		share.click();

	}

	public void share1() {
		share1.click();

	}

	public void shareicon() {
		for (int i = 1; i < 9; i++) {
			WebElement s = driver.findElement(By.xpath("(//*[@class='gig-simpleShareUI-button'])[" + i + "]"));
			String s1 = s.getText();
			if (s.isDisplayed()) {
				test.log(LogStatus.PASS, "PassStep4", "" + s1 + " Icon is present.");
			} else {
				test.log(LogStatus.FAIL, "PassStep4", "" + s1 + " Icon are present.");
			}
		}

	}

	public void shareicon1() {
		for (int i = 1; i < 7; i++) {
			WebElement s = driver.findElement(By.xpath("(//*[@class='gig-simpleShareUI-button-inner'])[" + i + "]"));
			String s1 = s.getText();
			if (s.isDisplayed()) {
				test.log(LogStatus.PASS, "PassStep4", "" + s1 + " Icon is present.");
			} else {
				test.log(LogStatus.FAIL, "PassStep4", "" + s1 + " Icon are present.");
			}
		}

	}

	public void close() {
		close.click();

	}
}
