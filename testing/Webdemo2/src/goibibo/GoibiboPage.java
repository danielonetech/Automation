package goibibo;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
 
public class GoibiboPage {
	WebDriver driver;
 
   // enter email
	@FindBy(xpath="(//*[contains(text(),'Hotels')])[2]")
	WebElement hotelclick;
		
   
	@FindBy(id="gosuggest_inputL")
	WebElement entercity;
   

	@FindBy(xpath="//*[@id='Home']/div[3]/div[1]/div/div[1]/div[3]/div/div[1]/div[1]/div/div/input")
	WebElement checkin;
	
	@FindBy(xpath="//*[@id='srpContainer']/div[1]/div/div/div[2]/div/div[1]/a/i")
	WebElement checkin1;
	
	
	
	@FindBy(xpath="//*[(contains(@class,'DayPicker-Day')) and text()='26']")
	WebElement checkinday;
   
 
	@FindBy(xpath="(//*[contains(@type,'text')])[18]")
	WebElement checkout;
	
	@FindBy(xpath="//*[@id='srpContainer']/div[1]/div/div/div[2]/div/div[2]/a/i")
	WebElement checkout1;
	
	
	@FindBy(xpath="//*[(contains(@class,'DayPicker-Day')) and text()='28']")
	WebElement checkoutday;
	
	
	@FindBy(id="home_textHook")
	WebElement rooms;
	
	
	@FindBy(xpath="*//select[@name='Room(s)']")
	WebElement room;
   

	@FindBy(xpath="*//select[@name='Adult']")
	WebElement adult;
   

	@FindBy(xpath="//*[contains(text(),'Done')]")
	WebElement done;
   
  
	@FindBy(xpath="//*[contains(text(),'Get Set Go')]")
	WebElement getsetgo;
	   

	@FindBy(xpath="//span[text()='3000 to ']")
	WebElement pricerange;
   

	@FindBy(xpath="//span[text()='Service Apartment']")
	WebElement hoteltype;
	
	
	@FindBy(xpath="//span[text()='Room Service']")
	WebElement amenities1;
	
	
	@FindBy(xpath="//span[text()='Power backup']")
	WebElement amenities2;
	
	
	@FindBy(xpath="//span[text()='Swimming Pool']")
	WebElement amenities3;
	
	
	@FindBy(xpath="//*[@id='srpContainer']/div[2]/div[2]/div/div[2]/div/div[5]/div[1]/div/div/section[2]/div[2]/div/div[3]/div[2]/div[2]/button")
	WebElement booknow;
	
	
	@FindBy(xpath="(//*[@type='text'])[1]")
	WebElement checkindate;
	
	
	@FindBy(xpath="(//*[@type='text'])[2]")
	WebElement checkoutdate;
	   
	   
	public GoibiboPage(WebDriver driver){
	this.driver = driver;
	//This initElements method will create all WebElements
	PageFactory.initElements(driver, this);
	}
	
	public void hotelclick(){
		hotelclick.click(); 
	}
	public void entercity(String entercit){
		entercity.sendKeys(entercit);
	}
	public void checkin(){
		checkin.click();
	}  
	
	public void checkin1(){
		checkin1.click();
	}  
	public void checkinday(){
		checkinday.click();
	}
	public void checkout(){
		checkout.click();
	}
	
	public void checkout1(){
		checkout1.click();
	} 
	
	public void checkoutday(){
		checkoutday.click();
	}
	public void rooms(){
		rooms.click();
	}
	public void room(){
		Select rooms = new Select((WebElement) room);
		rooms.selectByVisibleText("1");
	}
	public void adult(){
		Select adults = new Select((WebElement) adult);
		adults.selectByVisibleText("1");
	} 
	public void done(){
		done.click();
	}
	public void getsetgo(){
		getsetgo.click();
	}
	public void pricerange(){
		pricerange.click();
	}
	public void hoteltype(){
		hoteltype.click();
	}
	public void amenities1(){
		amenities1.click();
	}
	public void amenities2(){
		amenities2.click();
	}
	public void amenities3(){
		amenities3.click();
	}
	public void booknow(){
		booknow.click();
	}
	public void checkindate(String actualcheckin){
		String expected=actualcheckin;
		System.out.println(expected);
		String actual = checkindate.getAttribute("value");
		System.out.println(actual);
		assertEquals(actual,expected);
	}
	public void checkoutdate(String actualcheckout){
		String expected=actualcheckout;
		System.out.println(expected);
		String actual=checkoutdate.getAttribute("value");
		System.out.println(actual);
		assertEquals(actual,expected);
	}
	
	public void booking(String name, String checkindate, String checkoutdate, String actualcheckin, String actualcheckout, String title) throws InterruptedException{

		  /*Thread.sleep(3000);*/	
		String checkindate1=checkindate.substring(0, 2);
		System.out.println(checkindate1);
		String checkinmonth1=checkindate.substring(3);
		System.out.println(checkinmonth1);
		String checkoutdate1=checkoutdate.substring(0, 2);
		System.out.println(checkoutdate1);
		String checkoutmonth1=checkoutdate.substring(3);
		System.out.println(checkoutmonth1);
		this.hotelclick();
	        this.entercity(name);
	        Thread.sleep(3000);
	        String actualTitle= title;
			 for(int i=0;i<10;i++)
			 {
				String tagName = driver.findElement(By.id("react-autosuggest-1-suggestion--"+i)).getText();
				System.out.println(tagName);
				if (tagName.contains(actualTitle)){
					driver.findElement(By.id("react-autosuggest-1-suggestion--"+i)).click();
		            System.out.println(tagName);
		            break;
		        } else {
		            System.out.println("Test Failed");
		        }
			 }
	        Thread.sleep(3000);
		    this.checkin();
		    for(int i=0;i<12;i++)
			 {
		    	String x=checkinmonth1;
		    	String monthName = driver.findElement(By.className("DayPicker-Caption")).getText();
		    	if(x.contains(monthName)){
		    driver.findElement(By.xpath("//*[(contains(@class,'DayPicker-Day')) and text()='"+checkindate1+"']")).click();
		    	break;
		    	}
		    	driver.findElement(By.className("DayPicker-NavButton--next")).click();
		    }
		    Thread.sleep(1000); 
		   /* this.checkout();*/
		    Thread.sleep(2000);
		    for(int i=0;i<12;i++)
			 {
		    	String x=checkoutmonth1;
		    	String monthName = driver.findElement(By.className("DayPicker-Caption")).getText();
		    	if(x.contains(monthName)){
		    		driver.findElement(By.xpath("//*[(contains(@class,'DayPicker-Day')) and text()='"+checkoutdate1+"']")).click();
		    	break;
		    	}
		    	driver.findElement(By.className("DayPicker-NavButton--next")).click();
		    }
		    
		    
		    this.rooms();
		    this.room();
		    this.adult();
		    this.done();
		    this.getsetgo();
		    Thread.sleep(4000);
		    try{
		    this.pricerange();
		    Thread.sleep(500);
		    this.hoteltype();
		    Thread.sleep(500);
		    this.amenities1();
		    Thread.sleep(500);
		    this.amenities2();
		    Thread.sleep(500);
		    this.amenities3();
		    Thread.sleep(500);
		    //String winHandleBefore = driver.getWindowHandle();

			// Perform the click operation that opens new window
		    this.booknow();
		    
		    Thread.sleep(3000);

			// Switch to new window opened
			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			this.checkindate(actualcheckin);
			this.checkoutdate(actualcheckout);
		    }catch (NoSuchElementException exception) {
		    	System.out.println("Particular Hotel is not avilable on selected date");
		    }
	}
}