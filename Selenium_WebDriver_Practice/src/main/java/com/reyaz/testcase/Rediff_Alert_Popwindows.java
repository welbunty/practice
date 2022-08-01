package com.reyaz.testcase;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_Alert_Popwindows {
	public static WebDriver driver;
	public static String url = "https://www.rediff.com/";
	public static String username, password, actualAlertmsg, expectedAlertmsg;

	public static void main(String[] args) {

		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to(url);
			Thread.sleep(5000);
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Sign in")).click();
			Thread.sleep(5000);
			driver.findElement(By.name("proceed")).click();
			Thread.sleep(5000);
			// Use Alert Interface
			Alert alertmsg = driver.switchTo().alert();
			actualAlertmsg = alertmsg.getText();
			expectedAlertmsg = "Please enter a valid user name";
			if (actualAlertmsg.equals(expectedAlertmsg)) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
			// click on Ok button to accept alert
			alertmsg.accept();
			Thread.sleep(5000);
			// mouse cursor should from alert to default PAGE
			driver.switchTo().defaultContent();
			driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
