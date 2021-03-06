package upload;


import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class UploadPage {
WebDriver driver;

@FindBy(xpath="//*[contains(text(),'Try it Yourself')]")
WebElement Try_btn;

@FindBy(xpath="//input[@name='pic']")
WebElement choose_file;

@FindBy(xpath="//input[@type='submit']")
WebElement submit; 

@FindBy(xpath="//*[contains(text(),'pic=')]")
WebElement image; 



	   public UploadPage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	       PageFactory.initElements(driver, this);

	    }
	   public void Trybutton(){
		   Try_btn.click();
	    }

	   public void fileupload(String imageaddress){
		   choose_file.sendKeys(imageaddress);

	    }
	   public void submit(){
		   submit.click();

	    }
	   public void imagetext(String Address) throws InterruptedException{
		   String Expected = image.getText();	
		if (Expected.contains(Address)){
			String s = Expected.substring(4);
            System.out.println("Address is validated Successfully. Image Name is "+s);
            Thread.sleep(7000);
        } else {
            System.out.println("Test1 Failed");
        }
 }
} 
