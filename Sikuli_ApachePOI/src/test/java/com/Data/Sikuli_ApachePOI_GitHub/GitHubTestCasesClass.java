package com.Data.Sikuli_ApachePOI_GitHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class GitHubTestCasesClass {

	public WebDriver driver;
	Pattern username = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\username_textbox.png");
	Pattern password = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\password_textbox.png");
	Pattern signIn = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\signin_button.png");
	Pattern profile = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\profile.png");
	Pattern signOut = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\GitHub\\signout.png");
	Screen src = new Screen();
	
	public void Open_Browser(String d){
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void Navigate_To(String d){
		driver.get("https://github.com/login");
	}
	
	public void Wait_For(String d)throws Exception{
		Thread.sleep(4000);
	}
	
	public void Enter_Username(String d)throws Exception{
		src.type(username, d);
		Thread.sleep(2000);
	}
	
	public void Enter_Password(String d)throws Exception{
		src.type(password, d);
		Thread.sleep(2000);
	}
	
	public void Click_SignIn(String d)throws Exception{
		src.click(signIn);
		Thread.sleep(2000);
	}
	
	public void Click_Profile(String d)throws Exception{
		src.click(profile);
		Thread.sleep(2000);
	}
	
	public void Click_SignOut(String d)throws Exception{
		src.click(signOut);
		Thread.sleep(2000);
	}
	
	public void Close_Browser(String d){
		driver.close();
	}
}