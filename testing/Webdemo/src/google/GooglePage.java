package google;



import static org.testng.Assert.assertEquals;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class GooglePage {
WebDriver driver;


@FindBy(xpath="(//*[@href='https://www.google.co.in/intl/en/about/products?tab=wh'])[1] ")
WebElement googleApps;

@FindBy(xpath="//*[contains(text(),'Maps')]")
WebElement Maps;


@FindBy(xpath="//input[@id='searchboxinput']")
WebElement searchbox;

@FindBy(xpath="//*[contains(text(),'Plot')]")
WebElement address;

@FindBy(xpath="//*[@src='//www.gstatic.com/images/icons/material/system_gm/1x/rate_review_gm_blue_18dp.png']")
WebElement review;

@FindBy(xpath="//*[contains(text(),'Sign In')]")
WebElement signin;

@FindBy(xpath="//*[@id='identifierId']")
WebElement email;

@FindBy(xpath="//*[@id='identifierNext']/content")
WebElement next_id;

@FindBy(xpath="(//*[@class='Xb9hP'])[1]")
WebElement password;

@FindBy(xpath="//*[@id='passwordNext']/content")
WebElement nextpassword; 

@FindBy(xpath="//*[@jstcache='22']")
WebElement star;

@FindBy(xpath="//*[@class='review-text']")
WebElement comment;

@FindBy(xpath="(//*[contains(text(),'Post')])[2]")
WebElement post;

@FindBy(xpath="//*[contains(text(),'DONE')]")
WebElement done;

@FindBy(xpath="//*[contains(text(),'Ayushi Agrawal')]")
WebElement ayushi;

@FindBy(xpath="(//*[contains(text(),'My workplace')])[2]")
WebElement validate; 








	   public GooglePage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	       PageFactory.initElements(driver, this);

	    }
	   public void googleApps(){
		   googleApps.click();
	    }

	   public void Maps(){
		   Maps.click();

	    }
	   public void star(){
		   star.click();

	    }

	   public void post(){
		   post.click();

	    }

	   public void ayushi(){
		   ayushi.click();

	    }
	   public void done(){
		   done.click();

	    }

	   public void Searchbox(String search){
		   searchbox.sendKeys(search);

	    }
	   public void comment(String Comment){
		   comment.sendKeys(Comment);

	    }

	   public void address(String Address) throws InterruptedException{
		   String Expected = address.getText();	
		   System.out.println(Expected);
		if (Expected.contains(Address)){
            System.out.println("Address is validated Successfully");
            Thread.sleep(7000);

        } else {
            System.out.println("Test1 Failed");
        }
		System.out.println("Address is:"+Expected);
 }
	   public void review(){
		   review.click();	   
	    }

	   public void signin(){
		   signin.click();
		     }

	   public void next_id(){
		   next_id.click();
		     }

	   public void nextpassword(){
		   nextpassword.click();
		     }

		     public void email(String Email){
		    	 email.sendKeys(Email);

			    }

		     public void password(String Password){
		    	 password.sendKeys(Password);

			    }
		     public void Validate(String Comment){
				   String Expected = Comment;
				String actual = validate.getText();
				assertEquals(Expected, actual);
				System.out.println("Validate comment is:"+actual);
		 }


} 