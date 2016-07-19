package com.Data.Sikuli_ApachePOI_GitHub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ApachePOI_Sikuli_GitHub {
	
	@Test
	public void ExcelHandler(){
		try {
			FileInputStream githubFile = new FileInputStream("GitHubLogin.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(githubFile);
			XSSFSheet testCasesSheet = workbook.getSheet("TestCases");
			XSSFSheet loginSheet = workbook.getSheet("Login");
			
			int testCasesSheetRows = testCasesSheet.getLastRowNum();
			System.out.println("testCasesSheetRows : "+testCasesSheetRows);
			
			int loginSheetRows = loginSheet.getLastRowNum();
			System.out.println("loginSheetRows : "+loginSheetRows);
			
			GitHubTestCasesClass github = new GitHubTestCasesClass();
			Method githubMethods[] = github.getClass().getMethods();
			
			for(int i = 1;i<=testCasesSheetRows;i++){
				String testcases_TestID = String.valueOf(testCasesSheet.getRow(i).getCell(0));
				String testcases_Type = String.valueOf(testCasesSheet.getRow(i).getCell(2));
				
				if(testcases_Type.equals("Yes")){
					for(int j=1;j<=loginSheetRows;j++){
						String loginSheet_TestID = String.valueOf(loginSheet.getRow(j).getCell(0));
						if(loginSheet_TestID.equals(testcases_TestID)){
							String loginSheet_Action = String.valueOf(loginSheet.getRow(j).getCell(2));
							String loginSheet_Data = String.valueOf(loginSheet.getRow(j).getCell(3));
							
							for(int k=0;k<githubMethods.length;k++){
								if(githubMethods[k].getName().equals(loginSheet_Action)){
									githubMethods[k].invoke(github, loginSheet_Data);
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