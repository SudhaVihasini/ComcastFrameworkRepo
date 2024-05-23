package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName,int rowNum, int celNum) throws EncryptedDocumentException, Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\Raja\\Desktop\\selenium\\ComcastCRMGUIFramework\\testdata\\tek.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis); 
		String data= wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		
		return data;
}
	public int getRowcount(String Sheet1) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/tek.xlsx");
		Workbook wb=WorkbookFactory.create(fis); 
		int rowCount=wb.getSheet("contact").getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDataIntoExcel (String sheetName,int rowNum, int celNum,String data) throws EncryptedDocumentException, Throwable{
	FileInputStream fis = new FileInputStream("./testdata/tek.xlsx");
	Workbook wb=WorkbookFactory.create(fis); 
	Cell cel=wb.getSheet("contact").getRow(rowNum).createCell(celNum);
	//cel.setCellType(CellType .STRING);
//	cel.setCellValue(data);
	FileOutputStream fos = new FileOutputStream("./testdata/tek.xlsx");
	wb.write(fos);
	wb.close();
}
}