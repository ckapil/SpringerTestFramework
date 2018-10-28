package com.sm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.sm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;

	public static String TESTDATA_SHEET_PATH = "..\\SpringerTestFramework\\src\\main\\java\\com\\sm\\qa\\testdata\\SpringerTestData.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataFormatter dataFormatter = new DataFormatter();
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = dataFormatter.formatCellValue(sheet.getRow(i + 1).getCell(k));
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static Object[][] getTestData(String sheetName, int rowNum) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataFormatter dataFormatter = new DataFormatter();
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[1][sheet.getRow(0).getLastCellNum()];

		for (int k = 0; k < sheet.getRow(rowNum).getLastCellNum(); k++) {
			data[0][k] = dataFormatter.formatCellValue(sheet.getRow(rowNum).getCell(k));
			// System.out.println(data[0][k]);
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		File destFile = new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(scrFile, destFile);
		System.out.println("Screenshot created at path: " + destFile.getPath());
	}

}
