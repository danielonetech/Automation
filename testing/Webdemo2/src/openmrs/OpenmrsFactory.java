package openmrs;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtils;

public class OpenmrsFactory { 
	

	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String testname,String login, String name, String dob, String address, String relative, String identifier) {
		return new Object[] {new OpenmrsTest(testname,login,name,dob,address,relative,identifier)};
	}

	@DataProvider	 
    public static Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtils.getTableArray("D://testing//Webdemo//src//testData//Openmrs.xlsx","Sheet1");
          return testObjArray;
 }
		 }
