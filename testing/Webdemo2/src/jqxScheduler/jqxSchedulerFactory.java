package jqxScheduler;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;

import utility.ExcelUtils;

public class jqxSchedulerFactory {

	@Factory(dataProvider = "Authentication")
	public Object[] createInstances(String testCase, String date,
			String appointmenttime, String subject, String time,
			String timezone, String repeat, String repeatendson, String color) {
		return new Object[] { new jqxSchedulerTest(testCase, date,
				appointmenttime, subject, time, timezone, repeat, repeatendson,
				color) };
	}

	@DataProvider
	public Object[][] Authentication() throws Exception {
		Object[][] testObjArray = ExcelUtils.getTableArray(
				"D://testing//Webdemo//src//testData//jqxScheduler.xlsx",
				"Sheet1");
		return (testObjArray);

	}
}
