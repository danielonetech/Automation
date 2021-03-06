package w3s;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtilsSame;

public class W3sFactory { 

	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String search, String link, String name) {
		return new Object[] {new W3sTest(search,link,name)};
	}

	@DataProvider	 
    public Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtilsSame.getTableArray("D://testing//Webdemo//src//testData//W3s.xlsx","Sheet1");
          return (testObjArray);
 }
		 }


