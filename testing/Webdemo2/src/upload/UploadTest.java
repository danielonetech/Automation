package upload;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

		public class UploadTest {
		WebDriver driver;
		UploadPage objgo;
		private String imagename;
		private String imageaddress;
		




		public  UploadTest(String imageaddress, String imagename){
			this.imageaddress =imageaddress;
			this.imagename =imagename;
		    }


	    @BeforeClass
	    public void beforeMethod() throws Exception {
	    	System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
	  	driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.w3schools.com/tags/att_input_accept.asp");
	    Thread.sleep(2000); 
	    }


	@Test
    public void Google()throws  Exception{

		UploadPage objgo= new UploadPage(driver);
		Thread.sleep(5000);
		objgo.Trybutton();
		Thread.sleep(7000);
		String winHandleBefore = driver.getWindowHandle();
		  for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
		  driver.switchTo().frame("iframeResult");
		Thread.sleep(7000);
		objgo.fileupload(imageaddress);
		Thread.sleep(7000);
		objgo.submit();
		Thread.sleep(7000);
		objgo.imagetext(imagename);
		
	}

		 /*@AfterClass
		    public void afterMethod() {
		  	    driver.quit();
		    	}
		}*/
		}


 

