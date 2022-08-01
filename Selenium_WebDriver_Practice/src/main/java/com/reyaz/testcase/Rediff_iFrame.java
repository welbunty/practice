package com.reyaz.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_iFrame {
	public static WebDriver driver;
	public static String url = "https://www.rediff.com/";

	public static void main(String[] args) {

		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to(url);
			Thread.sleep(5000);
			driver.manage().window().maximize();

			// Option1 switch to ifram base on index
			driver.switchTo().frame(0);
			WebElement search = driver.findElement(By.id("query"));
			search.sendKeys("Mrf");
			// Click on search button
			driver.findElement(By.xpath("//input[contains(@class,'qbtn')]")).click();

			Thread.sleep(2000);

			// driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
