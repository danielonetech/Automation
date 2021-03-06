package carwale;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtilsSame;

public class CarwaleFactory { 




	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String car1,String car2,String car3,String car4) {
		return new Object[] {new CarwaleTest(car1,car2,car3,car4)};
	}

	@DataProvider	 
    public Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtilsSame.getTableArray("D://testing//Webdemo//src//testData//Carwale.xlsx","Sheet1");
          return (testObjArray);

 }
		 }

