package phptravels1;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtils;

public class PhptravelsFactory { 
	

	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String testname,String email, String password, String hotelname, String booingid, String value, String result) {
		return new Object[] {new PhptravelsTest(testname,email,password,hotelname,booingid,value,result)};
	}

	@DataProvider	 
    public static Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtils.getTableArray("D://testing//Webdemo//src//testData//Phptravels1.xlsx","Sheet1");
          return testObjArray;
 }
		 }





