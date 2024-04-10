package com.kalopap.guru99.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Common {
	
	public static final String directory = "/src/main/java/com/kalopap/guru99/";

	Properties prop;

	public void readDataFromExcel(String fileName,String sheetName,String cellName) {
		
		
		try {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+directory+fileName);
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				//sheet == iterating over rows; rows == iterating over cells(columns)
				int totalSheets = workbook.getNumberOfSheets();
				for(int i=0;i< totalSheets;i++ ) {
					if(workbook.getSheetName(i).equals(sheetName)) {
						XSSFSheet sheet = workbook.getSheetAt(i);
						//Identify testcases by scanning the first row(headers if any)
						Iterator<Row> rows=sheet.rowIterator();
						Row firstRow = rows.next();//access to first row
						
						//read the data in this row
						Iterator<Cell> cell = firstRow.cellIterator();
						int k=0; int column=0;
						while(cell.hasNext()) {
							Cell value = cell.next();
							if(value.getStringCellValue().equalsIgnoreCase("Password")) {
								column=k;
							}
							k++;
						}
						 
					System.out.println("U made it till here..." + column);
					}
					
				}
			}
			catch(IOException ex) {
				ex.printStackTrace();
				
			}
		
	}

	public Properties loadValuesFromPropertiesFile(String filename) {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+directory+filename);
			prop.load(ip);
		}catch(FileNotFoundException fe) {
			fe.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}
		return prop;
	}

}
