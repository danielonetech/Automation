package upload;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtilsSame;

public class UploadFactory { 

	@Factory(dataProvider="Authentication")
	public Object[] createInstances(String image, String imagename) {
		return new Object[] {new UploadTest(image,imagename)};
	}

	@DataProvider	 
    public Object[][] Authentication() throws Exception{ 
         Object[][] testObjArray = ExcelUtilsSame.getTableArray("D://testing//Webdemo//src//testData//Upload.xlsx","Sheet1");
          return (testObjArray);
 }
		 }

