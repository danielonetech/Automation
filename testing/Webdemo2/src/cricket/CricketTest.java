package cricket;



import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

		public class CricketTest {
		WebDriver driver;
		CricketPage objgo;
		private String search;
		




		public  CricketTest(String search){
			this.search =search;
		    }


	    @BeforeClass
	    public void beforeMethod() throws Exception {
	    	System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
	  	driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.google.com");
	    Thread.sleep(2000); 
	    }


	@Test
    public void Google()throws  Exception{

		CricketPage objgo= new CricketPage(driver);
		Thread.sleep(5000);
		objgo.Search_field(search);
		Actions action = new Actions(driver);
	    action.sendKeys(Keys.ENTER).build().perform();
	    Thread.sleep(5000);
	    objgo.link();
	    Thread.sleep(5000);
	    objgo.australia();
	    Thread.sleep(5000);
	    objgo.detail();
	}

		 @AfterClass
		    public void afterMethod() {
		  	    driver.quit();
		    	}
		}
		
