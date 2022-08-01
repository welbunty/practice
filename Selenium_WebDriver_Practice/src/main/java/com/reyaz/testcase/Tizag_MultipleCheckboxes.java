package com.reyaz.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tizag_MultipleCheckboxes {
	public static WebDriver driver;
	public static String url = "http://www.tizag.com/htmlT/htmlcheckboxes.php";

	public static void main(String[] args) {
		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			// driver.findElement(By.name("sports")).click();
			List<WebElement> multiplechk_Box = driver.findElements(By.name("sports"));

			for (int i = 0; i < multiplechk_Box.size(); i++) {
				multiplechk_Box.get(i).click();
			}

			Thread.sleep(5000);

			// driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
