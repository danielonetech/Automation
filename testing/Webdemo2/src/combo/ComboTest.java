package combo;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ComboTest {
	static WebDriver driver;
	ComboPage objgo;
	private static HSSFSheet ExcelWSheet;

	private static HSSFWorkbook ExcelWBook;

	private static HSSFCell Cell;

	//private static HSSFRow Row;
	static int l=1;

	@BeforeMethod
	public void beforeMethod() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"D:\\testing\\chromedriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://w2ui.com/web/demos/#!combo/combo-2");
		Thread.sleep(2000);

	}

	@Test
	public void Google() throws Exception {

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(
					"D://testing//Webdemo//src//testData//Combo.xlsx");

			// Access the required test data sheet

			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet("Sheet1");

			int startRow = 1;
			int startCol = 1;

			int ci, cj;

			int totalRows = ExcelWSheet.getLastRowNum();
			int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
			tabArray = new String[totalRows][totalCols];

			ci = 0;

			for (int i = startRow; i <= totalRows; i++, ci++) {

				cj = 0;

				for (int j = startCol; j < totalCols; j++, cj++) {

					tabArray[ci][cj] = getCellData(i, j);

				}

				ComboPage objgo = new ComboPage(driver);
				driver.findElement(
						By.xpath("//tr[@id='grid_grid_rec_" + l + "']"))
						.click();
				Thread.sleep(2000);
				int k=0;
				objgo.fname(tabArray[ci][k]);
				k++;
				Thread.sleep(1000);
				objgo.lname(tabArray[ci][k]);
				k++;
				Thread.sleep(1000);
				objgo.email(tabArray[ci][k]);
				k++;
				Thread.sleep(1000);
				objgo.sdate(tabArray[ci][k]);
				k++;
				Thread.sleep(1000);
				objgo.save();
				l++;

			}

		}

		catch (FileNotFoundException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e) {

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			// System.out.println(RowNum + " " + ColNum);
			if (Cell != null) {
				CellType dataType = Cell.getCellType();
				if (dataType == CellType.BLANK) {

					return "";

				} else {

					String CellData = Cell.getStringCellValue();

					return CellData;

				}
			} else {
				return "";
			}
		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}

	@AfterTest
	public void afterMethod() throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(
				"D://testing//Webdemo//src//testData//Combo.png"));
		// driver.quit();
	}
}
