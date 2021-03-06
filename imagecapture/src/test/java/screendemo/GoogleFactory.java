package screendemo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import utility.ExcelUtils;

public class GoogleFactory {

	@Factory(dataProvider = "Authentication")
	public Object[] createInstances(String tc, String search, String searchfield, String Address, String Email,
			String Password, String Comment) {
		return new Object[] { new GoogleTest(tc, search, searchfield, Address, Email, Password, Comment) };
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelUtils
				.getTableArray("D://testing//imagecapture//src//test//resources//Google.xlsx", "Sheet1");
		return (testObjArray);
	}
}
