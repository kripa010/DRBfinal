package com.drb.utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelUtilities  {
	static XSSFWorkbook wbook;
	static XSSFSheet sheet;
	public static String getcelldata(int sheetno, int row,int col) throws IOException
	{
	String datapath=System.getProperty("user.dir")+"\\src\\test\\resources\\Excel_data.xlsx";
	
	FileInputStream fis=new FileInputStream(datapath);
	 wbook=new XSSFWorkbook(fis);
	 sheet=wbook.getSheetAt(sheetno);
	 fis.close();
	return sheet.getRow(row).getCell(col).toString();
	
	}
}
