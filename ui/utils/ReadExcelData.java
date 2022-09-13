package com.leaftaps.ui.utils;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws IOException {
		//Locate and oprn the excel file
		XSSFWorkbook book=new XSSFWorkbook("./Testdata/Tesst data.xlsx");
		XSSFSheet sheet = book.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		System.out.println(rowNum);
		XSSFRow header = sheet.getRow(0);
		int cellNum = header.getLastCellNum();
		System.out.println(cellNum);
		for(int i=1; i<=rowNum; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for(int j=0; j<cellNum; j++) {
				XSSFCell eachCell = eachRow.getCell(j);
				String cellValue = eachCell.getStringCellValue();
				System.out.println(cellValue);
			}
		}
		book.close();

	}

}
