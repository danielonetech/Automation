package javascript;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtils;

public class JavascriptFactory { 
	

	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String testname,String email, String password, String customer, String customerid) {
		return new Object[] {new JavascriptTest(testname,email,password,customer,customerid)};
	}

	@DataProvider	 
    public static Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtils.getTableArray("D://testing//Webdemo//src//testData//Javascript.xlsx","Sheet1");
          return testObjArray;
 }
		 }






