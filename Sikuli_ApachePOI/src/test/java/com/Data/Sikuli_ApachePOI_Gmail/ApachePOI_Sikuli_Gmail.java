package com.Data.Sikuli_ApachePOI_Gmail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ApachePOI_Sikuli_Gmail {

	@Test
	public void ApachePOI(){
		try {
			FileInputStream gmailFile = new FileInputStream("GmailLogin.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(gmailFile);
			XSSFSheet testcasesSheet = workBook.getSheet("Test_Cases");
			XSSFSheet loginSheet = workBook.getSheet("Gmail_Login");
			int testcasesSheetRows = testcasesSheet.getLastRowNum();
			System.out.println("testcasesSheetRows : "+testcasesSheetRows);
			
			int loginSheetRows = loginSheet.getLastRowNum();
			System.out.println("loginSheetRows : "+loginSheetRows);
			
			GmailTestCasesClass gmailObject = new GmailTestCasesClass();
			Method gmailMethods[] = gmailObject.getClass().getMethods();
			
			
			for(int i = 1;i<=testcasesSheetRows;i++){
				String testCases_TestID = String.valueOf(testcasesSheet.getRow(i).getCell(0));
				String testCases_Mode = String.valueOf(testcasesSheet.getRow(i).getCell(2));
				if(testCases_Mode.equals("Yes")){
					for(int j= 1;j<=loginSheetRows;j++){
						String loginSheet_TestID = String.valueOf(loginSheet.getRow(j).getCell(0));
						if(testCases_TestID.equals(loginSheet_TestID)){
							//String loginSheet_Object = String.valueOf(loginSheet.getRow(j).getCell(2));
							String loginSheet_Action = String.valueOf(loginSheet.getRow(j).getCell(2));
							String loginSheet_Data = String.valueOf(loginSheet.getRow(j).getCell(3));
							System.out.println(loginSheet_Action+" , "+loginSheet_Data);
							for(int k=0;k<gmailMethods.length;k++){
								if(gmailMethods[k].getName().equals(loginSheet_Action)){
									gmailMethods[k].invoke(gmailObject,loginSheet_Data);
									//System.out.println("serdtfhujikol");
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
		} 
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}