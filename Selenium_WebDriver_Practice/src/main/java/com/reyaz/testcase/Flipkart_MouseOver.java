package com.reyaz.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_MouseOver {
	public static WebDriver driver;
	public static String url = "https://www.flipkart.com/";

	public static void main(String[] args) {

		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("7905959559");
			driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("reyaz12345");
			driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button")).click();
			
			//Mouse cursor move on appliances
		WebElement	appliances=driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[2]/div/div/div[7]/a/div[1]/div/img"));
		Actions act = new Actions(driver);
		act.moveToElement(appliances).build().perform();
		Thread.sleep(5000);
		// click on Home Appliance
			//driver.findElement(By.xpath("//a[@class='_6WOcW9 _2-k99T']")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='_6WOcW9 _2-k99T']")));
		driver.findElement(By.xpath("//a[@class='_6WOcW9 _2-k99T']")).click();

			// driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
