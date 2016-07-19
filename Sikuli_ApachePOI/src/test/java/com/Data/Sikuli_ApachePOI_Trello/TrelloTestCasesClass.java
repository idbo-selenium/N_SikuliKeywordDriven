package com.Data.Sikuli_ApachePOI_Trello;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class TrelloTestCasesClass {

	public WebDriver driver;
	Pattern username = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\username.png");
	Pattern password = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\password.png");
	Pattern login = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\loginButton.png");
	Pattern profile = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\profile_click.png");
	Pattern logout = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\Trello\\logout_click.png");
	Screen src = new Screen();
	
	public void Open_Browser(String d){
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Open_Browser");
		driver.manage().window().maximize();
	}
	
	public void Navigate_To(String d)throws Exception{
		driver.navigate().to("https://trello.com/login");Thread.sleep(4000);
		System.out.println("Navigate_To");
	}
	
	public void Wait_For(String d)throws Exception{
		Thread.sleep(4000);
	}
		
	public void Enter_Username(String d)throws Exception{
		//src.setAutoWaitTimeout(40);
		src.type(username, d);
		Thread.sleep(2000);
		System.out.println("Enter_Username : "+d);
	}	
	
	public void Enter_Password(String d)throws Exception{
		src.type(password, d);
		Thread.sleep(2000);
		System.out.println("Enter_Password");
	}
	
	public void Click_Login(String d)throws Exception{
		src.click(login);
		Thread.sleep(2000);
		System.out.println("Click_Login");
	}
	
	public void Click_Profile(String d)throws Exception{
		src.click(profile);
		System.out.println("Click_Profile");
		Thread.sleep(2000);
	}
	
	public void Click_Logout(String d)throws Exception{
		src.click(logout);
		Thread.sleep(2000);
		System.out.println("Click_Logout");
	}
	
	public void Close_Browser(String d)throws Exception{
		driver.close();
		System.out.println("Close_Browser");
	}
}