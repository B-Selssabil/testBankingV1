package com.testBanking.Utilities;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row ;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String xlfile)throws IOException{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheetAt(0);
		int rowcount = ws.getLastRowNum();
		System.out.println("row "+rowcount );
		wb.close();
		fi.close();
		
		return rowcount;
		
	}
	
	public static int getCellCount(String xlfile , int rownum) throws IOException {
		
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheetAt(0);
		row = ws.getRow(0);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
		
		
	}
	
	public static String getCellData(String xlfile, int rownum, int colnum)throws IOException {
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheetAt(0);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			
			String cellData = cell.getStringCellValue();
			return cellData;
			
		}catch(Exception e) {
			
			data="";
		}
		
		wb.close();
		fi.close();
		return data;
	}
	
	
	public static void setCellData(String xlfile, int rownum, int column, String data)throws IOException {
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheetAt(0);
		row = ws.getRow(rownum);
		cell= row.createCell(column);
		cell.setCellValue(data);
		fo= new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	
	
	
	

}
