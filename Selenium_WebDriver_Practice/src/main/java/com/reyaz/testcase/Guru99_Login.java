package com.reyaz.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Guru99_Login {
	public static WebDriver driver;
	public static String url = "https://www.guru99.com/";
	public static WebElement userId,password,btnlogin,btnreset;
	public static String Username,pwd;

	public static void main(String[] args) throws InterruptedException
	{
		Username="bunty";
		pwd="tester123";
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
	
		driver.findElement(By.xpath("//*[@id='java_technologies']/child::li[1]")).click();
		Thread.sleep(5000);
		
		

	}
}
