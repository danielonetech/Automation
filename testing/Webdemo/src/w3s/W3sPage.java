package w3s;



import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class W3sPage {
WebDriver driver;




@FindBy(xpath="//input[@type='text']")
WebElement Search_field;

@FindBy(xpath="(//*[contains(@href,'https://www.w3schools.com/jsref/met_win_prompt.asp')])[1]")
WebElement link;

@FindBy(xpath="(//*[contains(text(),'Try it Yourself')])[1]")
WebElement Try_btn;

@FindBy(xpath="//button[text()='Try it']")
WebElement tryit;

@FindBy(xpath="//*[contains(@id,'demo')]")
WebElement text;



	   public W3sPage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	       PageFactory.initElements(driver, this);

	    }
	   public void Search_field(String search){
		   Search_field.sendKeys(search);
	    }

	   public void link(){
		   link.click();

	    }
	   public void Try_btn(){
		   Try_btn.click();

	    }
	   public void tryit(){
		   tryit.click();

	    }
	   public void text(String Address){
		   String Expected = text.getText();	
			if (Expected.contains(Address)){
	            System.out.println("Name is validated Successfully. Result is "+Expected);
	        } else {
	            System.out.println("Test1 Failed");
	        }

	    }
} 

