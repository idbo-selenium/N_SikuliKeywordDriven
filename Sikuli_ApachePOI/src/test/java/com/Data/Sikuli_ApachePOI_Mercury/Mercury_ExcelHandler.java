package com.Data.Sikuli_ApachePOI_Mercury;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class Mercury_ExcelHandler {

	@Test
	public void ExcelHandler(){
		try {
			FileInputStream mercuryFile = new FileInputStream("MercuryLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(mercuryFile);
			XSSFSheet testCasesSheet = workbook.getSheet("TestCases");
			XSSFSheet loginSheet = workbook.getSheet("Login");
			
			int testcaseseSheetRows = testCasesSheet.getLastRowNum();
			System.out.println("testcaseseSheetRows : "+testcaseseSheetRows);
			
			int loginSheetRows = loginSheet.getLastRowNum();
			System.out.println("loginSheetRows : "+loginSheetRows);
			
			MercuryTestCasesClass mercury = new MercuryTestCasesClass();
			Method mercuryMethods[] = mercury.getClass().getMethods();
			
			for(int i=1;i<=testcaseseSheetRows;i++){
				String testcasesSheet_TestID = String.valueOf(testCasesSheet.getRow(i).getCell(0));
				String testcasesSheet_Type = String.valueOf(testCasesSheet.getRow(i).getCell(2));
				if(testcasesSheet_Type.equals("Yes")){
					for(int j=1;j<=loginSheetRows;j++){
						String loginSheet_TestID = String.valueOf(loginSheet.getRow(j).getCell(0));
						if(testcasesSheet_TestID.equals(loginSheet_TestID)){
							String loginSheet_Action = String.valueOf(loginSheet.getRow(j).getCell(2));
							String loginSheet_Data = String.valueOf(loginSheet.getRow(j).getCell(3));
							
							for(int k=0;k<mercuryMethods.length;k++){
								if(mercuryMethods[k].getName().equals(loginSheet_Action)){
									mercuryMethods[k].invoke(mercury, loginSheet_Data);
								}
							}
						}
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
}