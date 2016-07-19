package com.Data.Sikuli_ApachePOI_Trello;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ApachePOI_Sikuli_Trello {
	@Test
	public void Excel_Handler(){
		try {
			FileInputStream trelloFile = new FileInputStream("TrelloLogin.xlsx");
			XSSFWorkbook workbook =new XSSFWorkbook(trelloFile);
			XSSFSheet testCasesSheet = workbook.getSheet("TestCases");
			XSSFSheet loginSheet = workbook.getSheet("LoginSheet");
			
			int testcaseSheetRows = testCasesSheet.getLastRowNum();
			System.out.println("TestCases Sheet Rows : "+testcaseSheetRows);
			int loginSheetRows = loginSheet.getLastRowNum();
			System.out.println("LoginSheet Rows : "+loginSheetRows);
			
			TrelloTestCasesClass trello = new TrelloTestCasesClass();
			Method trelloMethods[] = trello.getClass().getMethods();
			
			for(int i=1;i<=testcaseSheetRows;i++){
				String testcasesSheetTestID = String.valueOf(testCasesSheet.getRow(i).getCell(0));
				String testcasesSheetType = String.valueOf(testCasesSheet.getRow(i).getCell(2));
				if(testcasesSheetType.equals("Yes")){
					for(int j=1;j<=loginSheetRows;j++){
						String loginSheet_TestID = String.valueOf(loginSheet.getRow(j).getCell(0));
						if(testcasesSheetTestID.equals(loginSheet_TestID)){
							String loginSheetAction = String.valueOf(loginSheet.getRow(j).getCell(2));
							String loginSheetData = String.valueOf(loginSheet.getRow(j).getCell(3));
							for(int k=0;k<trelloMethods.length;k++){
								if(trelloMethods[k].getName().equals(loginSheetAction)){
									trelloMethods[k].invoke(trello, loginSheetData);
									System.out.println("loginSheetAction : "+loginSheetAction +" , trelloMethods[k].getName() : "+trelloMethods[k].getName());
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