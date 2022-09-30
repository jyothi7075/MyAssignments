package com.leaftaps.ui.utils;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static String[][] getData(String excelFileName) throws IOException {
		XSSFWorkbook book=new XSSFWorkbook("./Testdata/"+excelFileName+".xlsx");
		XSSFSheet sheet=book.getSheetAt(0);
		int rowNum= sheet.getLastRowNum();
		XSSFRow header = sheet.getRow(0);
		short cellNum = header.getLastCellNum();
		String[][] data=new String[rowNum][cellNum];
		for(int i=1; i<=rowNum; i++) {
			XSSFRow eachRow = sheet.getRow(i);
			for(int j=0; j<cellNum; j++) {
				XSSFCell eachCell = eachRow.getCell(j);
				String cellValue = eachCell.getStringCellValue();
				data[i-1][j]=cellValue;
				System.out.println(cellValue);
			}
		}
		book.close();
		return data;
	}

}



