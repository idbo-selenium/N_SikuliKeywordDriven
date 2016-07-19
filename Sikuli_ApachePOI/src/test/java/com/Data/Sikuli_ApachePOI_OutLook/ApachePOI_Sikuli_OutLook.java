package com.Data.Sikuli_ApachePOI_OutLook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ApachePOI_Sikuli_OutLook {

	@Test
	public void OutLook_Login(){
		try {
			FileInputStream outlookFile = new FileInputStream("OutLookLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(outlookFile);
			XSSFSheet testcasesSheet = workbook.getSheet("TestCases"); 
			XSSFSheet loginSheet = workbook.getSheet("Login");
			
			int testcasesSheetRows = testcasesSheet.getLastRowNum();
			System.out.println("testcasesSheetRows : "+testcasesSheetRows);
			
			int loginSheetRows = loginSheet.getLastRowNum();
			System.out.println("loginSheetRows : "+loginSheetRows);
			
			OutLookTestCasesClass outlook = new OutLookTestCasesClass();
			Method outlookMethods[] = outlook.getClass().getMethods();
			
			for(int i = 1;i<=testcasesSheetRows;i++){
				String testcasesSheet_TestID = String.valueOf(testcasesSheet.getRow(i).getCell(0));
				String testcasesSheet_Type = String.valueOf(testcasesSheet.getRow(i).getCell(2));
				if(testcasesSheet_Type.equals("Yes")){
					for(int j=1;j<=loginSheetRows;j++){
						String loginSheet_TestID = String.valueOf(loginSheet.getRow(j).getCell(0));
						if(testcasesSheet_TestID.equals(loginSheet_TestID)){
							for(int k = 0;k<outlookMethods.length;k++){
								String testAction = String.valueOf(loginSheet.getRow(j).getCell(2));
								String testData = String.valueOf(loginSheet.getRow(j).getCell(3));
								if(outlookMethods[k].getName().equals(testAction)){
									outlookMethods[k].invoke(outlook, testData);
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