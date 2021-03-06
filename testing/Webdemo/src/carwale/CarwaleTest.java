package carwale;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

		public class CarwaleTest {
		WebDriver driver;
		CarwalePage objCar;
		private String car1;
		private String car2;
		private String car3;
		private String car4;



		public  CarwaleTest(String car1,String car2,String car3,String car4){
				this.car1=car1;
				this.car2=car2;
				this.car3=car3;
				this.car4=car4;
		    }


	    @BeforeClass
	    public void beforeMethod() throws Exception {
		    System.setProperty("webdriver.chrome.driver","D:\\testing\\chromedriver1\\chromedriver.exe");
		  	driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get("https://www.carwale.com/comparecars/");
		    Thread.sleep(2000); 
	    }


	@Test
    public void CarCompare()throws  Exception{
		String[] arrSplit1 = car1.split(",");
	      System.out.println(arrSplit1[0]);
	      System.out.println(arrSplit1[1]);
	      System.out.println(arrSplit1[2]);
	      System.out.println(arrSplit1[3]);
	      System.out.println(arrSplit1[4]);
	      System.out.println(arrSplit1[5]);
	      System.out.println(arrSplit1[6]);

		String[] arrSplit2 = car2.split(",");
		System.out.println(arrSplit2[0]);
	      System.out.println(arrSplit2[1]);
	      System.out.println(arrSplit2[2]);
	      System.out.println(arrSplit2[3]);
	      System.out.println(arrSplit2[4]);
	      System.out.println(arrSplit2[5]);
	      System.out.println(arrSplit2[6]);

		String[] arrSplit3 = car3.split(",");
		System.out.println(arrSplit3[0]);
	      System.out.println(arrSplit3[1]);
	      System.out.println(arrSplit3[2]);
	      System.out.println(arrSplit3[3]);
	      System.out.println(arrSplit3[4]);
	      System.out.println(arrSplit3[5]);
	      System.out.println(arrSplit3[6]);


		String[] arrSplit4 = car4.split(",");
			System.out.println(arrSplit4[0]);
		      System.out.println(arrSplit4[1]);
		      System.out.println(arrSplit4[2]);
		      System.out.println(arrSplit4[3]);
		      System.out.println(arrSplit4[4]);
		      System.out.println(arrSplit4[5]);
		      System.out.println(arrSplit4[6]);

CarwalePage objCar= new CarwalePage(driver);
objCar.Carmake1(arrSplit1[0]);
Thread.sleep(3000); 
objCar.Carmodel1(arrSplit1[1]);
Thread.sleep(3000); 
objCar.Carversion1(arrSplit1[2]);


objCar.Carmake2(arrSplit2[0]);
Thread.sleep(3000); 
objCar.Carmodel2(arrSplit2[1]);
Thread.sleep(3000); 
objCar.Carversion2(arrSplit2[2]);
Thread.sleep(3000); 

objCar.Carmake3(arrSplit3[0]);
Thread.sleep(5000); 
objCar.Carmodel3(arrSplit3[1]);
Thread.sleep(5000); 
objCar.Carversion3(arrSplit3[2]);
Thread.sleep(5000);

objCar.Compare_Btn();
Thread.sleep(5000);
objCar.Carmake4(arrSplit4[0]);
Thread.sleep(5000); 
objCar.Carmodel4(arrSplit4[1]);
Thread.sleep(5000); 
objCar.Carversion4(arrSplit4[2]);
Thread.sleep(5000);
objCar.AddCar();
Thread.sleep(5000);
objCar.Car1Displacement(arrSplit1[3]);
Thread.sleep(2000);
objCar.Car2Displacement(arrSplit2[3]);
Thread.sleep(2000);

objCar.Car3Displacement(arrSplit3[3]);
Thread.sleep(2000);
objCar.Car4Displacement(arrSplit4[3]);
Thread.sleep(2000);

objCar.Car1ARAI(arrSplit1[4]);
Thread.sleep(2000);
objCar.Car2ARAI(arrSplit2[4]);

objCar.Car3ARAI(arrSplit3[4]);
objCar.Car4ARAI(arrSplit4[4]);
objCar.Features();
Thread.sleep(2000);
objCar.Car1Warr(arrSplit1[5]);
objCar.Car2Warr(arrSplit2[5]);
objCar.Car3Warr(arrSplit3[5]);
objCar.Car4Warr(arrSplit4[5]);
Thread.sleep(2000);
objCar.Specifications();
Thread.sleep(2000);
objCar.Car1boot(arrSplit1[6]);
objCar.Car2boot(arrSplit2[6]);
objCar.Car3boot(arrSplit3[6]);
objCar.Car4boot(arrSplit4[6]);




	}







		 /*@AfterClass
		    public void afterMethod() {
		  	    driver.quit();
		    	}
		}*/
		}
