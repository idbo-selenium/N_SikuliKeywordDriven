package com.Data.Sikuli_ApachePOI_Gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class GmailTestCasesClass {

	public WebDriver driver;
	Pattern username = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\username.png");
	Pattern nextButton = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\nextButton.png");
	Pattern password = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\password.png");
	Pattern signInButton = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\signinButton.png");
	Pattern profileClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\profile_click.png");
	Pattern signoutClick = new Pattern("C:\\Users\\sravan\\Desktop\\important\\Sikuli_Snippets\\gmail\\signout_click.png");
	Screen src = new Screen();
	
	public void OpenBrowser(String d){
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
	}
	
	public void Navigate_To(String d){
		driver.navigate().to("https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl=en&service=mail#identifier");
	}
	
	public void Wait_For(String d)throws Exception{
		Thread.sleep(4000);
	}
	
	public void Enter_Username(String d) throws Exception {
		src.setAutoWaitTimeout(40);
		src.type(username, d);
		Thread.sleep(4000);
	}
	
	public void Click_NextButton(String d)throws Exception {
		src.click(nextButton);
		Thread.sleep(4000);
	}
	
	public void Enter_Password(String d) throws Exception{
		src.type(password, d);
		Thread.sleep(4000);
	}
	
	public void Click_SignIn(String d)throws Exception{
		src.click(signInButton);
		Thread.sleep(4000);
	}
	
	public void Click_Profile(String d)throws Exception{
		src.click(profileClick);
		Thread.sleep(4000);
	}
	
	public void Click_SignOut(String d)throws Exception{
		src.click(signoutClick);
		Thread.sleep(4000);
	}
	
	public void CloseBrowser(String d){
		driver.close();
	}
}