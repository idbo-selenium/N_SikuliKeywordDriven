package com.Data.Sikuli_ApachePOI_Mercury;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class MercuryTestCasesClass {

	public WebDriver driver;
	Pattern signOn = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\signOn_button.png");
	Pattern username = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\username.png");
	Pattern password = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\password.png");
	Pattern submit = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\submit.png");
	Pattern signOff = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Mercury\\signOut_button.png");
	Screen src = new Screen();
	public void Open_Browser(String d){
		//driver = new FirefoxDriver();		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sravan\\Desktop\\important\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void Navigate_To(String d){
		driver.get("http://newtours.demoaut.com/");
	}
	
	public void Wait_For(String d)throws Exception{
		Thread.sleep(4000);
	}
	
	public void Click_SignOn(String d)throws Exception{
		src.click(signOn); 
		Thread.sleep(4000);
	}
	
	public void Enter_Username(String d)throws Exception{
		src.type(username, d);
		Thread.sleep(4000);
	}
	
	public void Enter_Password(String d)throws Exception{
		src.type(password, d);
		Thread.sleep(4000);
	}
	
	public void Click_Submit(String d)throws Exception{
		src.click(submit);
		Thread.sleep(4000);
	}
	
	public void Click_SignOff(String d)throws Exception{
		src.click(signOff);
		Thread.sleep(4000);
	}
	
	public void Close_Browser(String d){
		driver.close();
	}
}