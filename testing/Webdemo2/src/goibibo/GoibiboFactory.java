package goibibo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtils;

public class GoibiboFactory { 




	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String name,String checkindate,String checkoutdate,String actualcheckin,String actualcheckout,String title) {
		return new Object[] {new GoibiboTest(name,checkindate,checkoutdate,actualcheckin,actualcheckout,title)};
	}

	@DataProvider	 
    public Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtils.getTableArray("D:\\testing\\Webdemo\\src\\testData\\goibibo.xlsx","Sheet1");
          return (testObjArray);

 }
		 }

