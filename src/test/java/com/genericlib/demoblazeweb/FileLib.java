package com.genericlib.demoblazeweb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getDataFromProperties(String path,String key) {
		FileInputStream ip=null;
		try {
			ip=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	Properties prop=new Properties();
	try {
		prop.load(ip);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return prop.getProperty(key);
	}
	public String getDataFromExcel(String path,String Sheet,int row,int cell) {
		FileInputStream ip=null;
		try {
			ip=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook wb = null;
			try {
				wb=WorkbookFactory.create(ip);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			org.apache.poi.ss.usermodel.Sheet sh=wb.getSheet(Sheet);
			return sh.getRow(row).getCell(cell).toString();
	
		
	}
	
}
