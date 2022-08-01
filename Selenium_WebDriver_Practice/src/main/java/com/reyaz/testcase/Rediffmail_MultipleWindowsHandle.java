package com.reyaz.testcase;

import java.sql.Time;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediffmail_MultipleWindowsHandle {
	public static WebDriver driver;
	public static String url = "https://www.rediff.com/";

	public static void main(String[] args) {
		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

			Set<String> mywindows = driver.getWindowHandles();
			Iterator<String> winid = mywindows.iterator();

			// Click on Search Button
			driver.switchTo().frame("moneyiframe");
			driver.findElement(By.xpath(" //input[contains(@type,'submit')]")).click();

			// Click on Import PortFollo
			mywindows = driver.getWindowHandles();
			winid = mywindows.iterator();

			String frstwinid = winid.next();
			System.out.println("First winId is--->" + frstwinid);
			String scendwinid = winid.next();
			System.out.println("second winId is--->" + scendwinid);
			Thread.sleep(3000);
			driver.switchTo().window(scendwinid);
			driver.findElement(By.xpath("//*[@id='moremoney']/ul/li[7]/a")).click();
			// Click on Rediff Moneywiz
			mywindows = driver.getWindowHandles();
			winid = mywindows.iterator();
			frstwinid = winid.next();
			scendwinid = winid.next();
			String thirdwinid = winid.next();
			System.out.println("Thjird winId is-->" + thirdwinid);
			driver.switchTo().window(thirdwinid);
			driver.findElement(By.linkText("Rediff Moneywiz")).click();

			mywindows = driver.getWindowHandles();
			winid = mywindows.iterator();
			frstwinid = winid.next();
			scendwinid = winid.next();
			thirdwinid = winid.next();
			String fourthwindow = winid.next();
			System.out.println("Thjird winId is-->" + fourthwindow);
			driver.switchTo().window(fourthwindow);
			driver.close();
			Thread.sleep(7000);
			driver.switchTo().window(thirdwinid);
			driver.close();
			Thread.sleep(3000);
			driver.switchTo().window(scendwinid);
			driver.close();
			Thread.sleep(3000);
			driver.switchTo().window(frstwinid);
			driver.quit();
			Thread.sleep(3000);
			System.out.println("==Done So BYE BYE==");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
