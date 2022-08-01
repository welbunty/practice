package com.reyaz.testcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wikipedia_Link {
	public static WebDriver driver;
	public static String url = "https://www.wikipedia.org/";

	public static void main(String[] args) {
		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.navigate().to(url);
			driver.manage().window().maximize();
		WebElement	footer=driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]"));
		List<WebElement> 	link=footer.findElements(By.tagName("a"));
		System.out.println("How many link on footer--->"+link.size());	//
		for(int i=0;i<link.size();i++)
		{
			System.out.println("Footer Links are---->"+link.get(i).getText()+"---------->"+link.get(i).getAttribute("href"));
			
		}
			
			// driver.quit();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
