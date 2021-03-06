package openmrs;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenmrsTest {
	static WebDriver driver;
	OpenmrsPage objgo;
	private String testname;
	private String relative;
	private String identifier;
	private String address;
	private String dob;
	private String name;
	private String login;

	public OpenmrsTest(String testname,String login, String name, String dob, String address, String relative, String identifier) {
		this.testname = testname;
		this.login = login;
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.relative = relative;
		this.identifier = identifier;
	}

	@BeforeClass
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		Thread.sleep(10000);
	}

	@Test
	public void Google() throws Exception {
		String[] arrSplit1 = login.split(",");
	      System.out.println(arrSplit1[0]);
	      System.out.println(arrSplit1[1]);

	      String[] arrSplit2 = name.split(",");
	      System.out.println(arrSplit2[0]);
	      System.out.println(arrSplit2[1]);

	      String[] arrSplit3 = dob.split(",");
	      System.out.println(arrSplit3[0]);
	      System.out.println(arrSplit3[1]);
	      System.out.println(arrSplit3[2]);



	      String[] arrSplit5 = address.split(",");
	      System.out.println(arrSplit5[0]);
	      System.out.println(arrSplit5[1]);
	      System.out.println(arrSplit5[2]);
	      System.out.println(arrSplit5[3]);

	      System.out.println(arrSplit5[4]);
	      System.out.println(arrSplit5[5]);
	      System.out.println(arrSplit5[6]);


	      String[] arrSplit6 = relative.split(",");
	      System.out.println(arrSplit6[0]);
	      System.out.println(arrSplit6[1]);
	      System.out.println(arrSplit6[2]);
	      System.out.println(arrSplit6[3]);

	      System.out.println(arrSplit6[4]);
	      System.out.println(arrSplit6[5]);



		OpenmrsPage objgo = new OpenmrsPage(driver);




			Thread.sleep(10000);
			objgo.Username(arrSplit1[0]);
			objgo.Password(arrSplit1[1]);
			Thread.sleep(5000);
			objgo.Location();
			objgo.loginbutton();
			objgo.RegisterPatient();
			objgo.GivenName(arrSplit2[0]);
			objgo.FamilyName(arrSplit2[1]);
			Thread.sleep(1000);
			objgo.Gender_slectn();
			objgo.Gender(arrSplit2[2]);
			objgo.BirthdaySlctn();
			objgo.Brthday_date(arrSplit3[0]);
			objgo.Brthday_Month(arrSplit3[1]);
			objgo.Brthday_year(arrSplit3[2]);
			objgo.Address_slctn();
			objgo.Address1(arrSplit5[0]);
			objgo.Address2(arrSplit5[1]);
			objgo.City(arrSplit5[2]);
			objgo.State(arrSplit5[3]);
			objgo.Country(arrSplit5[4]);
			objgo.Postal_code(arrSplit5[5]);
			objgo.Phone_slctn();
			objgo.PhoneNumber(arrSplit5[6]);
			objgo.Relative_Slctn();
			int i=1;
			int j=15;
			objgo.Rltnshp_Type(arrSplit6[0],arrSplit6[1], i, j);
			Thread.sleep(1000);
			objgo.Plus_btn();
			j=j+2;
			i++;
			objgo.Rltnshp_Type(arrSplit6[2],arrSplit6[3], i, j);
			Thread.sleep(1000);
			objgo.Plus_btn();
			j=j+2;
			i++;
			objgo.Rltnshp_Type(arrSplit6[4],arrSplit6[5], i, j);
			/*objgo.Person_Name(arrSplit6[1]);
			Thread.sleep(1000);
			objgo.Plus_btn();
			objgo.Rltnshp_Type(arrSplit6[2]);
			objgo.Person_Name(arrSplit6[3]);
			Thread.sleep(1000);
			objgo.Plus_btn();
			objgo.Rltnshp_Type(arrSplit6[4]);*/
			objgo.Confirm_Btn(); 
			Thread.sleep(1000);
			objgo.confirm(); 
	}

	
	  /*@AfterClass 
	  public void afterMethod() { 
		  driver.quit(); 
		  }*/
	 

}

