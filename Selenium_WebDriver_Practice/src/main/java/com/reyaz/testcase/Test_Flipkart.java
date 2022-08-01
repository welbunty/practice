package com.reyaz.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Flipkart {
	public static WebDriver driver;
	public static String url = "https://www.flipkart.com/";

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(url);
		WebElement appliance = driver.findElement(By.xpath("//img[@alt='Appliances']"));

		Actions act = new Actions(driver);
		act.moveToElement(appliance).build().perform();
		Thread.sleep(5000);
		WebElement refigerators = driver.findElement(By.xpath("//a[contains(@class,'_6WOcW9')] [4]"));

		Actions act2 = new Actions(driver);
		act2.moveToElement(refigerators).build().perform();
		Thread.sleep(8000);

		WebElement single_door = driver.findElement(By.linkText("Single Door"));
		Actions act3 = new Actions(driver);
		act3.moveToElement(single_door).build().perform();
		single_door.click();
		Thread.sleep(5000);
		WebElement lg_ref = driver.findElement(By.xpath(
				"//body/div[@id='container']/div/div[@class='_36fx1h _6t1WkM _3HqJxg']/div[@class='_1YokD2 _2GoDe3']/div[@class='_1YokD2 _3Mn1Gg']/div[8]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]"));
		lg_ref.click();

	}
}
