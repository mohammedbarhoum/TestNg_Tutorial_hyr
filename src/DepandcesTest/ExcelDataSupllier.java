package DepandcesTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupllier {
	@DataProvider(name = "loginTestData" ,parallel = true)
	public static String[][] getData() throws Exception {
		File excelFile = new File("D:\\TEst_Sort\\src\\DepandcesTest\\Test.xlsx");
		// System.out.println(excelFile.exists());
		FileInputStream fls = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fls);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int NumberOfRows = sheet.getPhysicalNumberOfRows();
		int NumberOfCouloms = sheet.getRow(0).getLastCellNum();
		// System.out.println(NumberOfRows);
		// System.out.println( NumberOfCouloms);
		String[][] data = new String[NumberOfRows - 1][NumberOfCouloms];

		for (int i = 0; i < NumberOfRows - 1; i++) {
			for (int j = 0; j < NumberOfCouloms; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));

			}

		}

		workbook.close();
		fls.close();

		// for (String[] dataArr : data) {

		// System.out.println(Arrays.toString(dataArr));
		return data;
	}
}
