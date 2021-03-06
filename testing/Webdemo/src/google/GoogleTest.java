package google;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

		public class GoogleTest {
		WebDriver driver;
		GooglePage objgo;
		private String search;
		private String searchfield;
		private String Address;
		private String Password;
		private String Email;
		private String Comment;




		public  GoogleTest(String search,String searchfield,String Address,String Email,String Password,String Comment){

			this.search =search;
			this.searchfield=searchfield;
			this.Address=Address;
				this.Email=Email;
				this.Password=Password;
				this.Comment=Comment;
		    }


	    @BeforeClass
	    public void beforeMethod() throws Exception {
	    	System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
	  	driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.google.com/");
	    Thread.sleep(2000); 
	    }


	@Test
    public void Google()throws  Exception{


GooglePage objgo= new GooglePage(driver);
Thread.sleep(5000);
objgo.googleApps();
Thread.sleep(7000);
objgo.Maps();
Thread.sleep(5000);
objgo.Searchbox(search);
Thread.sleep(7000);
	String actualTitle= searchfield;
		 for(int i=0;i<10;i++)
		 {
			String tagName = driver.findElement(By.id("sbse"+i)).getText();
			System.out.println(tagName);

		if (tagName.contains(actualTitle)){
	            System.out.println(tagName);
	            Thread.sleep(7000);
	            driver.findElement(By.id("sbse"+i)).click();
	            break;

	        } else {
	            System.out.println("Test Failed");
	        }
		 }
		Thread.sleep(7000);
		objgo.address(Address);
		Thread.sleep(10000);
		objgo.review();
		Thread.sleep(5000);
		
		  String winHandleBefore = driver.getWindowHandle();
		  for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
		Thread.sleep(5000);
		objgo.email(Email);
		objgo.next_id();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		passwordElement.click();
		passwordElement.clear();
		passwordElement.sendKeys(Password);
		System.out.println(Password);
		/*objgo.password(Password);*/
		Thread.sleep(10000);
		objgo.nextpassword();
		Thread.sleep(5000);
		driver.switchTo().window(winHandleBefore);
		driver.switchTo().frame("goog-reviews-write-widget");
		Thread.sleep(5000);
		objgo.star();
		Thread.sleep(2000);
		objgo.comment(Comment);
		Thread.sleep(2000);
		objgo.post();
		Thread.sleep(2000);
		objgo.done();
		//driver.switchTo().parentFrame();
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		WebElement ayushi1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Ayushi Agrawal')]")));
		 ayushi1.click();
		 Thread.sleep(2000);
		 for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
		 Thread.sleep(5000);
		 objgo.Validate(Comment);


	}

		 /*@AfterClass
		    public void afterMethod() {
		  	    driver.quit();
		    	}
		}*/
		}


 

