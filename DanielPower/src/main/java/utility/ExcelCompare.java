package utility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ExcelCompare {

	private static HSSFSheet ExcelWSheet;
	private static HSSFWorkbook ExcelWBook;
	private static HSSFCell Cell;
	private static HSSFRow Row;

	public static String[] getTableArray(String FilePath, String SheetName) throws Exception {

		String[] tabArray = null;
		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new HSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startRow = 0;
			int totalRows = ExcelWSheet.getLastRowNum();
			tabArray = new String[totalRows + 1];
			for (int i = startRow; i <= totalRows; i++) {
				tabArray[i] = getCellData(i, 0);
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

		return (tabArray);

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

}
