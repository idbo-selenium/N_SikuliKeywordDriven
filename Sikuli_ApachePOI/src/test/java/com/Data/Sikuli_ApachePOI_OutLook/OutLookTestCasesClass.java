package com.Data.Sikuli_ApachePOI_OutLook;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class OutLookTestCasesClass {

	WebDriver driver;
	Pattern username = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\SikuliProject\\OutLook\\username.png");
	Pattern password = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\SikuliProject\\OutLook\\password.png");
	Pattern signIn = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\SikuliProject\\OutLook\\signIn.png");
	Pattern newMail = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\SikuliProject\\OutLook\\newMail.png");
	Pattern toAddress = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\SikuliProject\\OutLook\\toAddress.png");
	Pattern subject = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\SikuliProject\\OutLook\\subject.png");
	//Pattern send = new Pattern("F:\\Eclipse_Selenium\\Java_Selenium_Maven\\SikuliProject\\OutLook\\send.png");
	Screen src = new Screen();
	
	public void Open_Browser(String s){
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse_Selenium\\Java_Selenium_Maven\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void Navigate_To(String s){
		driver.navigate().to(s);
	}
	
	public void Wait_For_PageLoad(String s) throws InterruptedException{
		System.out.println("Wait_For_PageLoad Method");
		Thread.sleep(2000);
	}
	
	public void Enter_Username(String s) throws FindFailed{
		System.out.println("Enter_Username Method");
		src.type(username, s);
	}
	
	public void Enter_Password(String s) throws FindFailed{
		System.out.println("Enter_Password Method");
		src.type(password, s);
	}
	
	public void Click_SignIn(String s) throws FindFailed{
		System.out.println("Click_SignIn Method");
		src.click(signIn);
	}
	
	public void Click_NewMail(String s) throws FindFailed{
		System.out.println("Click_NewMail Method");
		src.click(newMail);
	}
	
	public void Wait_For(String s) throws InterruptedException{
		System.out.println("Wait_For Method");
		Thread.sleep(20000);
	}
	
	public void Enter_ToAddress(String s) throws FindFailed{
		System.out.println("Enter_ToAddress Method");
		src.type(toAddress, s);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).build().perform();
	}
	
	public void Enter_Subject(String s) throws FindFailed{
		System.out.println("Enter_Subject Method");
		src.type(subject, s);
	}
	
	public void Click_Send(String s) throws FindFailed{
		System.out.println("Click_Send Method");
		//src.click(send);
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/div/div[1]/div[6]/div/div/div[2]/div[1]/span[1]/div[1]/button[1]/span[2]")).click();
	}
	
	public void Close_Browser(String s){
		System.out.println("Close_Browser Method");
		driver.close();
	}
}