package com.reyaz.testng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NoParameterWithTestNGXML 
{
   public static String url="https://www.google.com/";
	
	@Test
	@Parameters({"author","searchKey"})
	public void testParameterWithXML(@Optional("Abc") String author,String searchKey) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	WebElement	searchtext=driver.findElement(By.name("q"));
	searchtext.sendKeys(searchKey);
	
	System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	Thread.sleep(5000);
	
	System.out.println("Value in Google Search Box ="+searchtext.getAttribute("value") +" ::: Value given by input ="+searchKey);
	//verifying the value in google search box
	AssertJUnit.assertTrue(searchtext.getAttribute("value").equalsIgnoreCase(searchKey));
	}
	/*public void testNoParameter() throws InterruptedException
	{
		String author = "guru99";
		String searchKey = "india";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	WebElement	searchtext=driver.findElement(By.name("q"));
	searchtext.sendKeys(searchKey);
	
	System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	Thread.sleep(5000);
	
	System.out.println("Value in Google Search Box ="+searchtext.getAttribute("value") +" ::: Value given by input ="+searchKey);
	//verifying the value in google search box
	AssertJUnit.assertTrue(searchtext.getAttribute("value").equalsIgnoreCase(searchKey));
		
	}*/
}
