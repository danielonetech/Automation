package pageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class FactoryPage {
	WebDriver driver;
 
   // enter email
	@FindBy(xpath="//input[@type='text' and @class='_2zrpKA']")
	WebElement email;
		
   
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
   

	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement click;
   
 
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement countinue;
   

	@FindBy(xpath="//*[contains(text(),'Login with Pass')]")
	WebElement logpsaw;
   

	@FindBy(xpath="//input[@name='q']")
	WebElement search;
   
  
	@FindBy(xpath="(//*[@class='_2aUbKa'])[1]")
	WebElement click1;
	   

	@FindBy(xpath="//*[contains(text(),'Logout')]")
	WebElement logout;
   

	@FindBy(xpath="(//*[contains(text(),'Redmi Note 5 Pro (Black, 64 GB)')])[1]")
	WebElement finding;
	   
	   
	   public FactoryPage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	        PageFactory.initElements(driver, this);

	    }
	   public void setUserName(String strUserName){
		   email.sendKeys(strUserName); 
	    }

	    //Set password in password textbox

	    public void setPassword(String strPassword){
	    	password.sendKeys(strPassword);

	    }

	    //Click on login button

	    public void clickLogin(){
	    	click.click();

	    }  
	    public void clickConti(){
	    	countinue.click();

	    }
	    public void clicklogpsaw(){
	    	logpsaw.click();

	    }
	    public void search(String devicename){
	    	search.sendKeys(devicename);

	    } 
	    public void clickLogout(){
	    	click1.click();

	    }
	    public void Logout(){
	    	logout.click();

	    }
	    public void loginToGuru1(String strUserName,String strPasword){

	        //Fill user name
	        this.setUserName(strUserName);

	        //Fill password
	        this.setPassword(strPasword);

	        //Click Login button
	        this.clickLogin();           

	    }
	    public void loginToGuru2(String strUserName,String strPasword) throws InterruptedException{

	        //Fill user name
	        this.setUserName(strUserName);
	        this.clickConti();
	        WebDriverWait wait=new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[contains(text(),'Login with Pass')]")));
	        Thread.sleep(2000); 
	        this.clicklogpsaw();

	        //Fill password
	        this.setPassword(strPasword);

	        //Click Login button
	        this.clickLogin();           

	    }
	    public void deviceCheck(String devicename) throws InterruptedException{

	        //Fill user name
	        this.search(devicename);
	        Thread.sleep(2000); 
	        
	    }
	    public void logout() throws InterruptedException{

	        //Fill user name
	        this.clickLogout();
	        this.clickLogout();
	        Thread.sleep(1000);
	        this.Logout();
	        Thread.sleep(1000);
	    }
}
