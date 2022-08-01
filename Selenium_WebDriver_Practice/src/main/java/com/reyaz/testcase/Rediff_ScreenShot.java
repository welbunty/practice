package com.reyaz.testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.reyaz.tesutil.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_ScreenShot {
	public static WebDriver driver;
	public static String url = "https://www.rediff.com/";

	public static String getCurrentTimeStamp() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-mm-hh:ss.sss");
		Date now = new Date(); // It'll take current data & store into now variable
		String strDate = sdfDate.format(now);
		return strDate;
	}

	public static void getScreenShot(String path) throws IOException {
		// Capture screenShots in memory
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path));
	}

	public static void main(String[] args) {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to(url);
			Thread.sleep(5000);
			driver.manage().window().maximize();
			Thread.sleep(5000);
			// Global Page Load timeout
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITPAGELOADTIMEOUT, TimeUnit.SECONDS);
			// Global implicit wait timeout
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGEWAITLOADTIME, TimeUnit.SECONDS);
			// Click on About us Object identification
			driver.findElement(By.xpath("//a[normalize-space()='About us']")).click();
			// getScreenShot("../Selenium_WebDriver_Practice/ScreenShots/About Us.jpg");
			// Screen with Time
			getScreenShot("../Selenium_WebDriver_Practice/ScreenShots/"
					+ getCurrentTimeStamp().replace(":", "_").replace(",", "_") + "About_Us.jpg");
			Thread.sleep(5000);

			// driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
