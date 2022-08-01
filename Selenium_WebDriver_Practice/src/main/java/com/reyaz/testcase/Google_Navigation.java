package com.reyaz.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google_Navigation {
	public static WebDriver driver;
	public static String url = "https://www.google.com/";

	public static void main(String[] args) {
		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			// Click on About Link
			driver.findElement(By.linkText("About")).click();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().forward();
			driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
