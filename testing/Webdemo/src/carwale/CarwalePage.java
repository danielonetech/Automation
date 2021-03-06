package carwale;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class CarwalePage {
WebDriver driver;


@FindBy(id="drpMake1")
WebElement Carmake1;

@FindBy(id="drpModel1")
WebElement Carmodel1;

@FindBy(id="drpVersion1")
WebElement Carversion1;

@FindBy(id="drpMake2")
WebElement Carmake2;

@FindBy(id="drpModel2")
WebElement Carmodel2;

@FindBy(id="drpVersion2")
WebElement Carversion2;

@FindBy(id="drpMake3")
WebElement Carmake3;

@FindBy(id="drpModel3")
WebElement Carmodel3;

@FindBy(id="drpVersion3")
WebElement Carversion3;

@FindBy(id="btnCompare")
WebElement Compare_Btn;

@FindBy(id="drpMake")
WebElement Carmake4;

@FindBy(id="drpModel")
WebElement Carmodel4;

@FindBy(id="drpVersion")
WebElement Carversion4;

@FindBy(id="btnAddCar")
WebElement AddCar;

@FindBy(xpath="(//*[contains(text(),'1047')])[1]")
WebElement Car1Displacement;

@FindBy(xpath="(//*[contains(text(),'1186')])[1]")
WebElement Car2Displacement;

@FindBy(xpath="(//*[contains(text(),'1198')])[1]")
WebElement Car3Displacement;

@FindBy(xpath="(//*[contains(text(),'1248')])[1]")
WebElement Car4Displacement;

@FindBy(xpath="(//*[contains(text(),'27.28')])[1]")
WebElement Car1ARAI;
@FindBy(xpath="(//*[contains(text(),'24.95')])[1]")
WebElement Car2ARAI;
@FindBy(xpath="(//*[contains(text(),'16.47')])[1]")
WebElement Car3ARAI;
@FindBy(xpath="(//*[contains(text(),'20')])[8]")
WebElement Car4ARAI;

@FindBy(id="tab_Features")
WebElement Features;

@FindBy(id="tab_Specifications")
WebElement Specifications;

@FindBy(xpath="(//*[contains(text(),'75000')])[1]")
WebElement Car1Warr;

@FindBy(xpath="(//*[contains(text(),'Unlimited')])[1]")
WebElement Car2Warr;

@FindBy(xpath="(//*[contains(text(),'Unlimited')])[2]")
WebElement Car3Warr;

@FindBy(xpath="(//*[contains(text(),'100000')])[1]")
WebElement Car4Warr;

@FindBy(xpath="(//*[contains(text(),'242')])[3]")
WebElement Car1boot;

@FindBy(xpath="//*[contains(text(),'256')]")
WebElement Car2boot;

@FindBy(xpath="//*[contains(text(),'295')]")
WebElement Car3boot;

@FindBy(xpath="(//*[contains(text(),'280')])[2]")
WebElement Car4boot; 




	   public CarwalePage(WebDriver driver){
	        this.driver = driver;
	        //This initElements method will create all WebElements
	       PageFactory.initElements(driver, this);

	    }
	   public void Carmake1(String make){
		   Select make1 = new Select((WebElement) Carmake1);
		   make1.selectByVisibleText(make);
	    }

	   public void Carmodel1(String carmodel1){
		   Select model1 = new Select((WebElement) Carmodel1);
		   model1.selectByVisibleText(carmodel1);
	    }
	   public void Carversion1(String carversion1){
		   Select version1 = new Select((WebElement) Carversion1);
		   version1.selectByVisibleText(carversion1);
	    }

	   public void Carmake2(String carmake2){
		   Select make2 = new Select((WebElement) Carmake2);
		   make2.selectByVisibleText(carmake2);
	    }

	   public void Carmodel2(String carmodel2){
		   Select model2 = new Select((WebElement) Carmodel2);
		   model2.selectByVisibleText(carmodel2);
	    }
	   public void Carversion2(String carversion2){
		   Select version2 = new Select((WebElement) Carversion2);
		   version2.selectByVisibleText(carversion2);
	    }

	   public void Carmake3(String carmake3){
		   Select make3 = new Select((WebElement) Carmake3);
		   make3.selectByVisibleText(carmake3);
	    }

	   public void Carmodel3(String carmodel3){
		   Select model3 = new Select((WebElement) Carmodel3);
		   model3.selectByVisibleText(carmodel3);
	    }
	   public void Carversion3(String carversion3){
		   Select version3 = new Select((WebElement) Carversion3);
		   version3.selectByVisibleText(carversion3);
	    }

	   public void Compare_Btn(){
		   Compare_Btn.click();
	    }

	   public void Features(){
		   Features.click();
	    }

	   public void Specifications(){
		   Specifications.click();
	    }

	   public void Carmake4(String carmake4){
		   Select make4 = new Select((WebElement) Carmake4);
		   make4.selectByVisibleText(carmake4);
	    }

	   public void Carmodel4(String carmodel4){
		   Select model4 = new Select((WebElement) Carmodel4);
		   model4.selectByVisibleText(carmodel4);
	    }
	   public void Carversion4(String carversion4){
		   Select version4 = new Select((WebElement) Carversion4);
		   version4.selectByVisibleText(carversion4);
	    }

	   public void AddCar(){
		   AddCar.click();
	    }
	   public void Car1Displacement(String CarDisplacement1){
		   String Expected = CarDisplacement1;  
		String actual = Car1Displacement.getText();
		assertEquals(Expected, actual);
		System.out.println("DisplacementCar1:"+actual);
 }

	   public void Car4Displacement(String CarDisplacement4){
		   String Expected = CarDisplacement4;		
		String actual = Car4Displacement.getText();	
		assertEquals(Expected, actual);
		System.out.println("DisplacementCar2:"+actual);
 }

	   public void Car2Displacement(String CarDisplacement2){
		   String Expected = CarDisplacement2; 
		String actual = Car2Displacement.getText();
		assertEquals(Expected, actual);
		System.out.println("DisplacementCar3:"+actual);
 }

	   public void Car3Displacement(String CarDisplacement3){
		   String Expected = CarDisplacement3;
		String actual = Car3Displacement.getText();
		assertEquals(Expected, actual);
		System.out.println("DisplacementCar4:"+actual);
 }
	   public void Car1ARAI(String CarMileage1){
		   String Expected = CarMileage1;  
		String actual = Car1ARAI.getText();
		assertEquals(Expected, actual);
		System.out.println("MileagetCar1:"+actual);
 }

	   public void Car2ARAI(String CarMileage2){
		   String Expected = CarMileage2;		
		String actual = Car2ARAI.getText();	
		assertEquals(Expected, actual);
		System.out.println("MileagetCar2:"+actual);
 }

	   public void Car3ARAI(String Car2ARAI3){
		   String Expected = Car2ARAI3; 
		String actual = Car3ARAI.getText();
		assertEquals(Expected, actual);
		System.out.println("MileagetCar3:"+actual);
 }

	   public void Car4ARAI(String CarArai4){
		   String Expected = CarArai4;
		String actual = Car4ARAI.getText();
		assertEquals(Expected, actual);
		System.out.println("MileagetCar4:"+actual);
 }

	   public void Car1Warr(String CarWarr1){
		   String Expected = CarWarr1;  
		String actual = Car1Warr.getText();
		assertEquals(Expected, actual);
		System.out.println("WarrantyCar1:"+actual);
 }

	   public void Car2Warr(String CarWarr2){
		   String Expected = CarWarr2;		
		String actual = Car2Warr.getText();	
		assertEquals(Expected, actual);
		System.out.println("WarrantyCar2:"+actual);
 }

	   public void Car3Warr(String CarWarr3){
		   String Expected = CarWarr3; 
		String actual = Car3Warr.getText();
		assertEquals(Expected, actual);
		System.out.println("WarrantyCar3:"+actual);
 }

	   public void Car4Warr(String CarWarr4){
		   String Expected = CarWarr4;
		String actual = Car4Warr.getText();
		assertEquals(Expected, actual);
		System.out.println("WarrantyCar4:"+actual);
 }

	   public void Car1boot(String Carboot1){
		   String Expected = Carboot1;  
		String actual = Car1boot.getText();
		assertEquals(Expected, actual);
		System.out.println("Bootspacecar1:"+actual);
 }

	   public void Car2boot(String Carboot2){
		   String Expected = Carboot2;		
		String actual = Car2boot.getText();	
		assertEquals(Expected, actual);
		System.out.println("Bootspacecar2:"+actual);
 }

	   public void Car3boot(String Carboot3){
		   String Expected = Carboot3; 
		String actual = Car3boot.getText();
		assertEquals(Expected, actual);
		System.out.println("Bootspacecar3:"+actual);
 }

	   public void Car4boot(String Carboot4){
		   String Expected = Carboot4;
		String actual = Car4boot.getText();
		assertEquals(Expected, actual);
		System.out.println("Bootspacecar4:"+actual);
 }
} 