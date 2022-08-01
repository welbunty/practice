package com.reyaz.testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_MultipleDropdown_Options {
	public static WebDriver driver;
	public static WebElement day, month, year;
	public static Select se, se2, se3;
	public static String url = "http://register.rediff.com/register/register.php?FormName=user_details";

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}

	public static void specificDropDown() {
		// Click on Day DropDown
		day = driver.findElement(By.xpath("//table[@width='660']/tbody/tr[22]/td[3]/select[1]"));
		// click on Month Dropdown
		month = driver.findElement(By.xpath("//table[@width='660']/tbody/tr[22]/td[3]/select[2]"));
		// click on the year dropdown
		year = driver.findElement(By.xpath("//table[@width='660']/tbody/tr[22]/td[3]/select[3]"));
		// Specific value
		// Select class constructor to select values from day dropdown like 15
		se = new Select(day);
		se2 = new Select(month);
		se3 = new Select(year);

		se.selectByIndex(15);
		se2.selectByIndex(07);
		se3.selectByValue("1980");
	}

	public static void main(String[] args) {
		launchBrowser();
		specificDropDown();

	}

}
