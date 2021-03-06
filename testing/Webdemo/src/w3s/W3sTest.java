package w3s;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

		public class W3sTest {
		WebDriver driver;
		W3sPage objgo;
		private String search;
		private String link;
		private String name;
		




		public  W3sTest(String search, String link, String name){
			this.search =search;
			this.link =link;
			this.name=name;
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

		W3sPage objgo= new W3sPage(driver);
		Thread.sleep(5000);
		objgo.Search_field(search);
		Actions action = new Actions(driver);
	    action.sendKeys(Keys.ENTER).build().perform();
	    objgo.link();
	    objgo.Try_btn();
	    Thread.sleep(7000);
		String winHandleBefore = driver.getWindowHandle();
		  for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
		  Thread.sleep(7000);
		driver.switchTo().frame("iframeResult");
		Thread.sleep(7000);
		objgo.tryit();
		driver.switchTo().alert().sendKeys(name);
		driver.switchTo().alert().accept();
		Thread.sleep(7000);
		objgo.text(name);
	}

		 @AfterClass
		    public void afterMethod() {
		  	    driver.quit();
		    	}
		}
		