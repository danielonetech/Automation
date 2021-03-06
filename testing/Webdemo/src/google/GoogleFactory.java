package google;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtilsSame;

public class GoogleFactory { 

	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String search,String searchfield,String Address,String Email,String Password,String Comment) {
		return new Object[] {new GoogleTest(search,searchfield, Address,Email,Password,Comment)};
	}

	@DataProvider	 
    public Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtilsSame.getTableArray("D://testing//Webdemo//src//testData//Google.xlsx","Sheet1");
          return (testObjArray);
 }
		 }
