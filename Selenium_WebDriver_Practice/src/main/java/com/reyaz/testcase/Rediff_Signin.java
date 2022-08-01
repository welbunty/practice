package com.reyaz.testcase;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Rediff_Signin {
	public static WebDriver driver;
	public static String url="https://www.rediff.com/";
	public static String username,password,actualErrorText,expectedErrorText;
	
	public static String decodedString(String password)
	{
		byte[] decodedString=Base64.decodeBase64(password);
		return ( new String(decodedString));
	}
	
	public static void main(String[] args) 
	{
		username="welbunty";
		//password="tester";
		
		try {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.navigate().to(url);
			Thread.sleep(5000);
			driver.manage().window().maximize();
			driver.findElement(By.linkText("Sign in")).click();
			Thread.sleep(5000);
//	Emaol-Id
			driver.findElement(By.id("login1")).sendKeys(username);
			
//	Password
			driver.findElement(By.name("passwd")).sendKeys(decodedString("cmV5YXoxMTIz"));
			Thread.sleep(5000);
			driver.findElement(By.name("proceed")).click();
			Thread.sleep(5000);
			actualErrorText=driver.findElement(By.xpath("//div[@id='div_login_error']")).getText();
			expectedErrorText="Temporary Issue. Please try again later. [#5002]";
			if(actualErrorText.equals(expectedErrorText))
			{
				System.out.println("PASS");
			}
			else
			{
				System.out.println("FAIL");
			}
			driver.quit();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
