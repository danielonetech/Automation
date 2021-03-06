package cricket;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtilsSame;

public class CricketFactory { 

	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String search) {
		return new Object[] {new CricketTest(search)};
	}

	@DataProvider	 
    public Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtilsSame.getTableArray("D://testing//Webdemo//src//testData//Cricket.xlsx","Sheet1");
          return (testObjArray);
 }
		 }



