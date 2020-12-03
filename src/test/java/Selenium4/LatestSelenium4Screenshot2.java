package Selenium4;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LatestSelenium4Screenshot2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium All Stuff\\Selenium Jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.facebook.com/");
		

		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("pass"));
		WebElement loginButton = driver.findElement(By.name("login"));
		WebElement forgotPwd = driver.findElement(By.linkText("Forgotten password?"));
		email.sendKeys("naveen@gmail.com");
		password.sendKeys("Test@l23");
		takeElementScreenshot(email, "email Element1");
		takeElementScreenshot(password, "passwordElement1");
		takeElementScreenshot(loginButton, "loginButtonElement1");
		takeElementScreenshot(forgotPwd, "forgotPwdLink1");
		driver.quit();
	}

	public static void takeElementScreenshot(WebElement element, String fileName) { 
	TakesScreenshot scrShot = ((TakesScreenshot) element); 
	File srcFile = scrShot.getScreenshotAs(OutputType.FILE); 
	try { 
		FileUtils.copyFile(srcFile, new File("./target/screenshots/" + fileName + ".png")); } 
	catch (Exception e) 
	{ e.printStackTrace(); 
	}


}
	
}
