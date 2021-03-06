package phptravels;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtils;

public class PhptravelsFactory { 

	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String email, String password, String booingid, String value,String email2, String password2, String booingid2, String value2) {
		return new Object[] {new PhptravelsTest(email,password,booingid,value,email2,password2,booingid2,value2)};
	}

	@DataProvider	 
    public Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtils.getTableArray("D://testing//Webdemo//src//testData//Phptravels.xlsx","Sheet1");
          return (testObjArray);
 }
		 }




