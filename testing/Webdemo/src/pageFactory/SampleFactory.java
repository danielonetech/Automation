package pageFactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtilsSame;

public class SampleFactory {
	
	 
	 @Factory(dataProvider="Authentication")
		public Object[] createInstances(String sUserName,String sPassword,String devicename) {
			return new Object[] {new Factor(sUserName,sPassword,devicename)};
		}
	 
	@DataProvider
	public Object[][] Authentication() throws Exception{
		 
        Object[][] testObjArray = ExcelUtilsSame.getTableArray("D://testing//Webdemo//src//testData//TestData.xlsx","Sheet1");

        return (testObjArray);
}
}
